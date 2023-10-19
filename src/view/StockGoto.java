package view;

import controller.Product;

import java.util.List;
import java.util.Scanner;

public class StockGoto {
    public  int goTo(int currentPage, int rowsPerPage, List<Product> productList) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the page number you want to go to: ");

        int targetPage = scanner.nextInt();
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);

        if (targetPage >= 1 && targetPage <= totalPages) {
            currentPage = targetPage;
            StockDisplay gotoDisplay = new StockDisplay();
            gotoDisplay.stockDisplay(productList, currentPage, rowsPerPage);
        } else {
            System.out.println("Invalid page number. Please enter a page number between 1 and " + totalPages + ".");
        }
        return currentPage;
    }
}
