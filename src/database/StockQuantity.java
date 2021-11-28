package database;

import assets.Ticker;

import java.util.HashMap;
import java.util.Map;

public class StockQuantity {
    private static final Map<Ticker, Integer> MAP = new HashMap<>();

    private StockQuantity() {
    }

    public static void put(Ticker ticker, Integer quantity) {
        MAP.put(ticker, quantity);
    }

    public static int get(Ticker ticker) {
        return MAP.get(ticker);
    }
}
