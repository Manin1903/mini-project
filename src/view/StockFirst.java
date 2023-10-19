package view;

import controller.Product;

import java.util.List;


public class StockFirst {
    public static int first(int currentPage, int rowsPerPage, List<Product> productList) {
        if (currentPage == 1) {
            System.out.println("You are already on the first page.");
        } else {
            currentPage = 1;
            StockDisplay displayFirst = new StockDisplay();
            displayFirst.stockDisplay(productList, currentPage, rowsPerPage);
        }
        return currentPage;
    }
}
