package database;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;
import price.PriceGetter;

import java.util.HashMap;
import java.util.Map;

public class StockPrices {
    private static final Map<Ticker, Double> MAP = new HashMap<>();

    private StockPrices() {
    }

    public static void update(Ticker ticker) {
        try {
            MAP.put(ticker, PriceGetter.get(ticker));
        } catch (NumberFormatException e) {
            System.err.println("Cannot get " + ticker + " price");
            e.printStackTrace();
        }
    }

    /* Works as a separate thread */
    public static Thread updateAll() {
        var priceInitializingThread = new Thread(() -> {
            for (var ticker : FinExTicker.values()) {
                if (!Thread.interrupted()) {
                    update(ticker);
                } else {
                    return;
                }
            }
            for (var ticker : VTBTicker.values()) {
                if (!Thread.interrupted()) {
                    update(ticker);
                } else {
                    return;
                }
            }
        });
        priceInitializingThread.setDaemon(true);
        priceInitializingThread.start();
        return priceInitializingThread;
    }

    public static double get(Ticker ticker) {
        if (!MAP.containsKey(ticker))
            update(ticker);
        return MAP.get(ticker);
    }
}
