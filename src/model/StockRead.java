package model;

import controller.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StockRead {
    public void read(List<Product> productList){

        Scanner sc = new Scanner(System.in);
        boolean isFound = false;
        try {
            System.out.print("Read by ID : ");
            Integer productID = Integer.parseInt(sc.nextLine());
            for (Product product : productList) {
                if (product.getProId().equals(productID)) {
                    Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                    table.addCell(" ID            : "+productID+" ".repeat(10));
                    table.addCell(" Name          : "+product.getProName()+" ".repeat(10));
                    table.addCell(" Unit price    : "+product.getProPrice()+" ".repeat(10));
                    table.addCell(" Qty           : "+product.getProQty()+" ".repeat(10));
                    table.addCell(" Imported Date : "+ LocalDate.now()+" ".repeat(10));
                    System.out.println(table.render());
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Product with ID : "+productID+" is not found");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
