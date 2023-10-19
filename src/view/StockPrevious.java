package view;


import java.util.List;
import controller.Product;

import java.util.List;

public class StockPrevious {
    public static int previous(int currentPage, int rowsPerPage, List<Product> productList) {
        if (currentPage > 1) {
            currentPage--;
            StockDisplay previousDisplay = new StockDisplay();
            previousDisplay.stockDisplay(productList, currentPage, rowsPerPage);
        } else {
            System.out.println("You are already on the previous page.");
        }
        return currentPage;
    }
}
