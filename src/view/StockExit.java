package view;

import java.util.Scanner;

public class StockExit {
    public void stockExit(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("You miss to save record. Do you want to save it? [Y/y] or [N/n]: ");

        System.exit(0);
    }

}
