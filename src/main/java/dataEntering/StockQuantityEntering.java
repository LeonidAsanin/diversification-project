package dataEntering;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;
import database.StockQuantity;

import java.util.Scanner;


/**
 * Class that provides functionality for entering of the user's stock quantities.
 *
 * @author lennardjones
 * @version 1.1
 * @since 1.0
 */
public class StockQuantityEntering {
    private StockQuantityEntering() {
    }

    /**
     * Provides functionality for entering the quantity of a specific asset using specific scanner.
     *
     * @param ticker Ticker of the specific asset
     * @param scanner Scanner to data entering
     */
    public static void enter(Ticker ticker, Scanner scanner) {
        var quantity = 0;
        var correctInput = false;

        System.out.print(ticker + ": ");

        while (!correctInput) {
            String inputLine = scanner.nextLine();
            try {
                quantity = Integer.parseInt(inputLine);
                if (quantity < 0) {
                    System.out.print("Please, enter a positive number: ");
                } else {
                    correctInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Please, enter a proper integer number: ");
            }
        }

        StockQuantity.put(ticker, quantity);
    }

    /**
     * Provides functionality for entering the quantities of all FinEx and VTB funds using console.
     */
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
