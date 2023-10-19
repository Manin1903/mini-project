package view;

import controller.Product;

import java.util.List;

public class StockNext {
    public static int next(int currentPage, int rowsPerPage, List<Product> productList) {
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
        if (currentPage < totalPages) {
            currentPage++;
            StockDisplay nextDisplay = new StockDisplay();
            nextDisplay.stockDisplay(productList, currentPage, rowsPerPage);
        } else {
            System.out.println("You are already on the next page.");
        }
        return currentPage;
    }
}

