package org.lennardjones.diversificationproject.dataEntering;

import org.lennardjones.diversificationproject.assets.FinExTicker;
import org.lennardjones.diversificationproject.assets.Ticker;
import org.lennardjones.diversificationproject.assets.VTBTicker;
import org.lennardjones.diversificationproject.database.StockQuantity;

import java.util.Scanner;


/**
 * Class that provides functionality for entering of the user's stock quantities.
 *
 * @author lennardjones
 * @version 1.3
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
     * @param stockQuantity Stocks quantity to put data in
     */
    public static void enter(Ticker ticker, Scanner scanner, StockQuantity stockQuantity) {
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

        stockQuantity.put(ticker, quantity);
    }

    /**
     * Provides functionality for entering the quantities of all FinEx and VTB funds using console.
     *
     * @return StockQuantity object that represents quantity of stocks entered by user
     */
    public static StockQuantity enterAll(Scanner scanner) {
        var stockQuantity = new StockQuantity();

        System.out.println("\nEnter the number of shares you have:");

        for (var ticker : FinExTicker.values())
            enter(ticker, scanner, stockQuantity);
        for (var ticker : VTBTicker.values())
            enter(ticker, scanner, stockQuantity);

        return stockQuantity;
    }
}
