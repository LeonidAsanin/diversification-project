package consoleIO;

import assets.Ticker;
import database.QuantityOfShares;
import database.SharePrices;

import java.util.Map;

public class CalculationOfInvestmentPortfolio {
    private CalculationOfInvestmentPortfolio() {}

    public static double returnTotalPriceByTickerAndPutIntoMap(Ticker ticker, Map<Ticker,Double> portfolioMap) {
        var quantity = 0;
        var totalPrice = 0.;

        if ((quantity = QuantityOfShares.get(ticker)) > 0) {
            var price = SharePrices.get(ticker);
            totalPrice = quantity * price;
            portfolioMap.put(ticker,totalPrice);
            System.out.printf("%s: %12.2f ₽/share\t", ticker, price);
            System.out.printf("%12.2f ₽\n", totalPrice);
        }

        return totalPrice;
    }
}
