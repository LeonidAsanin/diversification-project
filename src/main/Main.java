package main;

import assets.FinExTicker;
import database.SharePrices;
import database.QuantityOfShares;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var priceInitializingThread =  new Thread(SharePrices::update);
        priceInitializingThread.setDaemon(true);
        priceInitializingThread.start();

        System.out.println("Enter the number of shares you have:");
        var scanner = new Scanner(System.in);
        var quantity = 0;
        for (FinExTicker ticker : FinExTicker.values()) {
            System.out.print(ticker + ": ");
            var correctInput = false;
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
        scanner.close();

        System.out.println();
        System.out.println("Your investment portfolio: ");
        var portfolioSum = 0.;
        for (FinExTicker ticker : FinExTicker.values()) {
            if ((quantity = QuantityOfShares.get(ticker)) > 0) {
                var price = SharePrices.get(ticker);
                portfolioSum += quantity * price;
                System.out.print(ticker + " (" + price + " ₽/share):\t");
                System.out.printf("%10.2f ₽\n", quantity * price);
            }
        }
        System.out.println("-------------------------------------");
        System.out.print("Sum of all assets:\t\t");
        System.out.printf("%10.2f ₽\n", portfolioSum);
    }
}