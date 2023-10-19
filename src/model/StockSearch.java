package model;

import controller.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockSearch {
    public  void search(List<Product> productList, int currentPage, int rowsPerPage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search product by keyword: ");
        String searchKeyword = scanner.nextLine().toLowerCase();

        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : productList) {
            String productName = product.getProName().toLowerCase();

            if (productName.contains(searchKeyword)) {
                matchingProducts.add(product);
            }
        }

        int totalPages = (int) Math.ceil((double) matchingProducts.size() / rowsPerPage);
        if (matchingProducts.isEmpty()) {
            System.out.println("No products found containing the keyword '" + searchKeyword + "'.");
        } else {
            if (currentPage < 1) {
                currentPage = 1;
            } else if (currentPage > totalPages) {
                currentPage = totalPages;
            }

            int startIndex = (currentPage - 1) * rowsPerPage;
            int endIndex = Math.min(startIndex + rowsPerPage, matchingProducts.size());

            Table tableDisplay = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
            tableDisplay.addCell(" ".repeat(2) + "ID" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Name" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Unit Price" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Qty" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Imported Date" + " ".repeat(2));

            for (int i = startIndex; i < endIndex; i++) {
                Product product = matchingProducts.get(i);
                tableDisplay.addCell(" ".repeat(2) + product.getProId().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getProName());
                tableDisplay.addCell(" ".repeat(2) + product.getProPrice().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getProQty().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getImportedPro().toString());
            }

            System.out.println(tableDisplay.render());
            Table pagination = new Table(25,BorderStyle.DESIGN_CURTAIN, ShownBorders.SURROUND);
            pagination.addCell(" Page: \t");
            pagination.addCell(String.valueOf(currentPage));
            pagination.addCell("  of ");
            pagination.addCell(String.valueOf(totalPages));
            pagination.addCell(" ".repeat(30));
            pagination.addCell("Total records : ");
            pagination.addCell(String.valueOf(matchingProducts.size()));
            System.out.println(pagination.render());

        }
    }
}
