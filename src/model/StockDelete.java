package model;

import controller.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StockDelete {
    public void delete(List<Product> productList) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the ID of the product you want to delete: ");
            Integer productId = Integer.parseInt(scanner.nextLine());
            for (Product product : productList) {
                if (product.getProId().equals(productId)) {
                    Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                    table.addCell(" ID            : "+product.getProId()+" ".repeat(10));
                    table.addCell(" Name          : "+product.getProName()+" ".repeat(10));
                    table.addCell(" Unit price    : "+product.getProPrice()+" ".repeat(10));
                    table.addCell(" Qty           : "+product.getProQty()+" ".repeat(10));
                    table.addCell(" Imported Date : "+ LocalDate.now()+" ".repeat(10));
                    System.out.println(table.render());
                    System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                    String options = scanner.nextLine();
                    switch (options) {
                        case "y","Y" -> {
                            productList.remove(product);
                            System.out.println("Product with ID " + productId + " deleted successfully.");
                            return;
                        }
                        case "n","N" -> {
                            System.out.println("Product is not deleted");
                            return;
                        }
                        default -> System.out.println("Invalid options");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

