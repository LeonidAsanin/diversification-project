package database;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;
import price.PriceGetter;

import java.util.HashMap;
import java.util.Map;

public class StockPrices {
    private static final Map<Ticker, Double> PRICE_MAP = new HashMap<>();

    private StockPrices() {
    }

    public static void update(Ticker ticker) {
        try {
            PRICE_MAP.put(ticker, PriceGetter.get(ticker));
        } catch (NumberFormatException e) {
            System.out.println("Cannot get " + ticker + " price");
        }
    }

    /* Works as a separate thread */
    public static void updateAll() {
        var priceInitializingThread = new Thread(() -> {
            for (var ticker : FinExTicker.values())
                update(ticker);
            for (var ticker : VTBTicker.values())
                update(ticker);
        });
        priceInitializingThread.setDaemon(true);
        priceInitializingThread.start();
    }

    public static double get(Ticker ticker) {
        if (!PRICE_MAP.containsKey(ticker))
            update(ticker);
        return PRICE_MAP.get(ticker);
    }
}
