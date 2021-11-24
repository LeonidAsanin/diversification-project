package consoleIO;

import assets.Ticker;
import database.QuantityOfShares;

import java.util.Scanner;

public class EnteringOfShareQuantity {
    private EnteringOfShareQuantity() {}

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

        QuantityOfShares.put(ticker,quantity);
    }
}
