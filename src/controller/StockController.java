package controller;
import Utils.UtilsTextTable;
import model.*;
import Utils.JTable;
import Utils.UtilsTextTable;
import view.StockDisplay;
import view.StockGoto;
import view.StockHelp;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
// view package
import static view.StockFirst.first;
import static view.StockPrevious.previous;
import static view.StockLast.last;
import static view.StockNext.next;

public class StockController {
    public static void main(String[] args) {
        int currentPage = 1;
        int rowsPerPage=2;
        UtilsTextTable ascii = new UtilsTextTable();
        ascii.display();
        System.out.println("STOCK MANAGEMENT SYSTEM");
        boolean isTrue = true;
        LocalDate localDate =LocalDate.now();
        // Stock of Products
        Product product = new Product(1,"Coca",1.5,1,localDate);
        Product product2 = new Product(12,"String",1.5,1,localDate);
        Product product3 = new Product(13,"Anchor",1.5,1,localDate);
        Product product4 = new Product(2,"Soda",1.5,1,localDate);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        do{
            JTable jtable = new JTable();
            jtable.displayTable();
            // add Option Input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Command ———> ");
            String option = scanner.nextLine();
            switch(option){
                case "*"-> {
                    StockDisplay display = new StockDisplay();
                    display.stockDisplay(productList,currentPage,rowsPerPage);
                }
                case "w","W"->{
                    StockWrite write = new StockWrite();
                    write.write(productList);
                }
                case "r","R"->{
                    StockRead read = new StockRead();
                    read.read(productList);

                }
                case "u","U"->{
                    StockUpdate update = new StockUpdate();
                    update.update(productList);
                }
                case "d","D"->{
                    StockDelete delete = new StockDelete();
                    delete.delete(productList);
                }
                case "f","F"->{
                    currentPage = first(currentPage, rowsPerPage, productList);
                }
                case "p","P"->{
                    currentPage = previous(currentPage,rowsPerPage,productList);
                }
                case "n","N"->{
                    currentPage = next(currentPage,rowsPerPage,productList);
                }
                case "l","L"->{
                    currentPage = last(currentPage,rowsPerPage,productList);
                }
                case "s","S"->{
                    StockSearch search = new StockSearch();
                    search.search(productList,currentPage,rowsPerPage);
                }
                case "g","G"->{
                    StockGoto gotoStock = new StockGoto();
                    currentPage = gotoStock.goTo(currentPage,rowsPerPage,productList);

                }
                case "se","Se"->{
                    StockSetRow setRowStock = new StockSetRow();
                    rowsPerPage = setRowStock.setRow(rowsPerPage,productList);
                }
                case "h","H"->{
                    StockHelp helpDisplay = new StockHelp();
                    helpDisplay.displayHelp();
                }
                case "e","E"->{

                    System.out.print("You miss to save the record. Do you want to save it? [Y/y] or [N/n]: ");
                    String yesNo = scanner.nextLine();
                    if(yesNo.equals("y")){
                        continue;
                    }
                    isTrue=false;
                    if(yesNo.equals("n")){

                        System.out.println();
                        JTable tableExit = new JTable();
                        tableExit.displayExitTable();

                        System.exit(0);
                    }
                }
                default ->{
                    String [] shortcutOption = option.split("#");
                    String [] values;
//                    System.out.println(Arrays.toString(shortcutOption));
                    switch(shortcutOption[0]){
                        case "w","W"->{
                            values=shortcutOption[1].split("-");
                            Product productAdd = new Product(Integer.parseInt(values[0]),values[1],Double.parseDouble(values[2]),
                                    Integer.parseInt(values[3]),localDate);
                            productList.add(productAdd);
//
                        }
                        case "r","R"->{
                            boolean isFound=false;
                            for (Product product1 : productList) {
                                if (product1.getProId().toString().equals(shortcutOption[1])) {
                                    Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                                    table.addCell(" ID            : "+product1.getProId()+" ".repeat(10));
                                    table.addCell(" Name          : "+product1.getProName()+" ".repeat(10));
                                    table.addCell(" Unit price    : "+product1.getProPrice()+" ".repeat(10));
                                    table.addCell(" Qty           : "+product1.getProQty()+" ".repeat(10));
                                    table.addCell(" Imported Date : "+ LocalDate.now()+" ".repeat(10));
                                    System.out.println(table.render());
                                    isFound = true;
                                    break;
                                }
                            }
                            if (!isFound) {
                                System.out.println("Product with ID : "+shortcutOption[0]+" is not found");
                            }
                        }
                        case "d","D"->{
                            productList.removeIf(product1 -> product1.getProId().toString().equals(shortcutOption[1]));
                        }
                    }
                }
            }
        }while(isTrue);
    }
}

