package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;


public class StockWrite {
    public  void write(List<Product> productList){

        Product lastProduct = productList.get(productList.size() - 1);
        Integer productID = lastProduct.getProId()+1;

        Scanner sc = new Scanner(System.in);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Product ID : ");
            Integer proId = Integer.parseInt(scanner.nextLine());
            System.out.print("Product's Name : ");
            String proName = scanner.nextLine();
            System.out.print("Product's Price : ");
            Double proUnitPrice = Double.parseDouble(scanner.nextLine());
            System.out.print("Product's Qty: ");
            Integer proQty = Integer.parseInt(scanner.nextLine());
            LocalDate getImported = LocalDate.now();
            Product product = new Product(proId,proName,proUnitPrice,proQty,getImported);
            productList.add(product);
            do {
                Table table = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                table.addCell(" ID            : "+proId+" ".repeat(10));
                table.addCell(" Name          : "+proName+" ".repeat(10));
                table.addCell(" Unit price    : "+proUnitPrice+" ".repeat(10));
                table.addCell(" Qty           : "+proQty+" ".repeat(10));
                table.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                System.out.println(table.render());
                System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                String options = sc.nextLine();
                switch (options) {
                    case "y","Y" -> {
                        Table tableYesNo = new Table(15,BorderStyle.DESIGN_CAFE);
                        tableYesNo.addCell("       ");
                        tableYesNo.addCell(String.valueOf(proId));
                        tableYesNo.addCell("was added successfully");
                        System.out.println(tableYesNo.render());
                        System.out.println();
                        System.out.println("Product added successfully.");
                        return;
                    }
                    case "n","N" -> {
                        productList.remove(product);
                        System.out.println("Product is not added");
                        return;
                    }
                    default -> System.out.println("Invalid options.");
                }
            }while (true);
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }
    }
}


