package view;

import controller.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class StockDisplay {
    public void stockDisplay(List<Product> products, int currentPage, int rowsPerPage){
        int startIndex = (currentPage - 1) * rowsPerPage;
        Table stockTable = getStockTable(products, rowsPerPage, startIndex);
        System.out.println(stockTable.render());
        rowsPerPage = 2;
        int totalPages = (int) Math.ceil((double) products.size() / rowsPerPage);
        //int totalPages = products.size()/rowsPerPage;
        Table pagination = new Table(25,BorderStyle.DESIGN_CURTAIN,ShownBorders.SURROUND);
        pagination.addCell(" Page: \t");
        pagination.addCell(String.valueOf(currentPage));
        pagination.addCell("  of ");
        pagination.addCell(String.valueOf(totalPages));
        pagination.addCell(" ".repeat(30));
        pagination.addCell("Total records : ");
        pagination.addCell(String.valueOf(products.size()));
        System.out.println(pagination.render());
    }

    private static Table getStockTable(List<Product> products, int rowsPerPage, int startIndex) {
        int endIndex = Math.min(startIndex + rowsPerPage, products.size());
        Table stockTable = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,ShownBorders.ALL);
        stockTable.setColumnWidth(0,10,20);
        stockTable.setColumnWidth(1,10,20);
        stockTable.setColumnWidth(2,10,20);
        stockTable.setColumnWidth(3,10,20);
        stockTable.setColumnWidth(4,10,20);
        stockTable.addCell("ID");
        stockTable.addCell("NAME");
        stockTable.addCell("Unit Price");
        stockTable.addCell("Qty");
        stockTable.addCell("Imported Date");
        int counter = 0;
        for (Product product : products) {
            if (counter >= startIndex && counter < endIndex) {
                stockTable.addCell(String.valueOf(product.getProId()));
                stockTable.addCell(product.getProName());
                stockTable.addCell(String.valueOf(product.getProPrice()));
                stockTable.addCell(String.valueOf(product.getProQty()));
                stockTable.addCell(String.valueOf(product.getImportedPro()));
            }
            counter++;
        }
        return stockTable;
    }

}
