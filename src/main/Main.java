package main;

import database.InvestmentPortfolio;
import consoleInput.StockQuantityEntering;
import database.CountryDiversification;
import price.PriceInitializer;

public class Main {
    public static void main(String[] args) {
        PriceInitializer.initialize(); // works concurrently while user enters data
        StockQuantityEntering.enterAll(); // entering data by user
        InvestmentPortfolio.show();
        CountryDiversification.show();
    }
}
