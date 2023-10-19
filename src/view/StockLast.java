package view;

import controller.Product;

import java.util.List;

public class StockLast {
    public static int last(int currentPage, int rowsPerPage, List<Product> productList) {
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
        if (currentPage == totalPages) {
            System.out.println("You are already on the last page.");
        } else {
            currentPage = totalPages;
            StockDisplay lastDisplay = new StockDisplay();
            lastDisplay.stockDisplay(productList, currentPage, rowsPerPage);
        }
        return currentPage;
    }
}
