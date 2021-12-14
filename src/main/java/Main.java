import database.InvestmentPortfolio;
import consoleInput.StockQuantityEntering;
import database.CountryDiversification;
import database.StockPrices;

public class Main {
    public static void main(String[] args) {
        StockPrices.updateAll(); // works concurrently while user enters data
        StockQuantityEntering.enterAll(); // entering data by user
        InvestmentPortfolio.show();
        CountryDiversification.show();
    }
}
