package consoleInput;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;
import database.StockQuantity;

import java.util.Scanner;

public class StockQuantityEntering {
    private StockQuantityEntering() {
    }

    public static void enter(Ticker ticker, Scanner scanner) {
        var quantity = 0;
        var correctInput = false;

        System.out.print(ticker + ": ");

        while (!correctInput) {
            String inputLine = scanner.nextLine();
            try {
                quantity = Integer.parseInt(inputLine);
                correctInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Please, enter an integer number: ");
            }
        }

        StockQuantity.put(ticker, quantity);
    }

    public static void enterAll() {
        System.out.println("\nEnter the number of shares you have:");
        var scanner = new Scanner(System.in);
        for (var ticker : FinExTicker.values())
            enter(ticker, scanner);
        for (var ticker : VTBTicker.values())
            enter(ticker, scanner);
        scanner.close();
    }
}
