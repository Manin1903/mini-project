package model;

import controller.Product;

import java.util.List;
import java.util.Scanner;

public class StockSetRow {
    public int setRow( int rowsPerPage, List<Product> products) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number of row(s) you want to display : ");
            int numberOfRows = Integer.parseInt(sc.nextLine());
            if (numberOfRows >0 && numberOfRows <= products.size()){
                return numberOfRows;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rowsPerPage;
    }
}
