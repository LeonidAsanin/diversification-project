import database.StockPrices;
import database.InvestmentPortfolio;
import database.CountryDiversification;
import dataEntering.StockQuantityEntering;

public class Main {
    public static void main(String[] args) {

        /* Gets thread that works concurrently while user enters data */
        var priceInitializingThread = StockPrices.updateAllAsSeparateThread();

        /* Entering data by user */
        var stockQuantity = StockQuantityEntering.enterAll();

        /*
        * Interrupting initialized downloading of data from the remote servers
        * because next method gets all needed price information by its own
        */
        priceInitializingThread.interrupt();

        var investmentPortfolio = new InvestmentPortfolio(stockQuantity, true);
        investmentPortfolio.show();

        new CountryDiversification(investmentPortfolio).show();
    }
}
