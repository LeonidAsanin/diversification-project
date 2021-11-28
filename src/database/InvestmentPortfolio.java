package database;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;

import java.util.HashMap;
import java.util.Map;

public class InvestmentPortfolio {
    private static final Map<Ticker, Double> PORTFOLIO_MAP = new HashMap<>();
    private static double sum = 0;
    private static volatile boolean calculationCompleted = false;

    private InvestmentPortfolio() {
    }

    /*
    * Initialization block to perform calculateInvestmentPortfolio() method as a separate thread
    * in order to other calculations can be performed independently and concurrently.
    */
    static {
        new Thread(InvestmentPortfolio::calculateInvestmentPortfolio).start();
    }

    private static double calculateTotalPriceByTicker(Ticker ticker) {
        var quantity = StockQuantity.get(ticker);
        if (quantity == 0) return 0;

        return quantity * StockPrices.get(ticker);
    }

    private static void calculateInvestmentPortfolio() {
        for (var ticker : FinExTicker.values()) {
            var assetTotalPrice = calculateTotalPriceByTicker(ticker);
            sum += assetTotalPrice;
            PORTFOLIO_MAP.put(ticker, assetTotalPrice);
        }
        for (var ticker : VTBTicker.values()) {
            var assetTotalPrice = calculateTotalPriceByTicker(ticker);
            sum += assetTotalPrice;
            PORTFOLIO_MAP.put(ticker, assetTotalPrice);
        }
        calculationCompleted = true;
    }

    /* Waits for calculateInvestmentPortfolio() method to complete */
    public static double getTotalPriceByTicker(Ticker ticker) {
        while (!calculationCompleted) Thread.onSpinWait();
        return PORTFOLIO_MAP.getOrDefault(ticker, 0.);
    }

    /* Waits for calculateInvestmentPortfolio() method to complete */
    public static double getSum() {
        while (!calculationCompleted) Thread.onSpinWait();
        return sum;
    }

    public static void showTotalPriceByTicker(Ticker ticker) {
        System.out.printf("%s: %12.2f ₽/share\t", ticker, StockPrices.get(ticker));
        System.out.printf("%12.2f ₽\n", calculateTotalPriceByTicker(ticker));
    }

    public static void show() {
        System.out.println("\nYour investment portfolio: ");

        for (var ticker : FinExTicker.values())
            if (StockQuantity.get(ticker) > 0) showTotalPriceByTicker(ticker);
        for (var ticker : VTBTicker.values())
            if (StockQuantity.get(ticker) > 0) showTotalPriceByTicker(ticker);

        System.out.println("------------------------------------------");
        System.out.print("Sum of all assets:\t\t");
        System.out.printf("%16.2f ₽\n", getSum());// getSum() returns value after calculation completion
    }
}
