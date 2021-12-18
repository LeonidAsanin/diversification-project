import database.InvestmentPortfolio;
import consoleInput.StockQuantityEntering;
import database.CountryDiversification;
import database.StockPrices;

public class Main {
    public static void main(String[] args) {

        /* Gets thread that works concurrently while user enters data */
        var priceInitializingThread = StockPrices.updateAll();

        /* Entering data by user */
        StockQuantityEntering.enterAll();

        /*
        * Interrupting initialized downloading of data from the remote servers
        * because next method gets all needed price information by its own
        */
        priceInitializingThread.interrupt();

        InvestmentPortfolio.show();
        CountryDiversification.show();
    }
}
