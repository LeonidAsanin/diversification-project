package database;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;
import price.PriceGetter;

import java.util.HashMap;
import java.util.Map;

public class SharePrices {
    private static final Map<Ticker,Double> priceMap = new HashMap<>();

    private SharePrices(){}

    public static void update(Ticker ticker) {
        try {
            priceMap.put(ticker,PriceGetter.get(ticker));
        } catch (NumberFormatException e) {
            System.out.println("Cannot get " + ticker + " price");
        }
    }

    public static void updateAll() {
        for (var ticker : FinExTicker.values())
            update(ticker);
        for (var ticker : VTBTicker.values())
            update(ticker);
    }

    public static double get(Ticker ticker) {
        if (!priceMap.containsKey(ticker))
            update(ticker);
        return priceMap.get(ticker);
    }
}
