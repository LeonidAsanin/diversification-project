package org.lennardjones.diversificationproject;

import org.lennardjones.diversificationproject.database.StockPrices;
import org.lennardjones.diversificationproject.database.InvestmentPortfolio;
import org.lennardjones.diversificationproject.database.CountryDiversification;
import org.lennardjones.diversificationproject.dataEntering.StockQuantityEntering;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* For entering data from the console */
        var scanner = new Scanner(System.in);

        /* Gets thread that works concurrently while user enters data */
        var priceInitializingThread = StockPrices.updateAllAsSeparateThread();

        /* Entering data by user */
        var stockQuantity = StockQuantityEntering.enterAll(scanner);

        /*
        * Interrupting initialized downloading of data from the remote servers
        * because next method gets all needed org.lennardjones.diversificationproject.price information by its own
        */
        priceInitializingThread.interrupt();

        var investmentPortfolio = new InvestmentPortfolio(stockQuantity, true);
        investmentPortfolio.show();

        var countryDiversification = new CountryDiversification(investmentPortfolio);
        System.out.println("""
                
                Choose a view of the diversification table:
                 - Standard view : enter 1
                 - Extended view : enter 2""");
        var view = scanner.nextLine();
        if (view.equals("2")) {
            countryDiversification.showExtended();
        } else {
            countryDiversification.show();
        }

        scanner.close();
    }
}
