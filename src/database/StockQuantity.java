package database;

import assets.Ticker;

import java.util.HashMap;
import java.util.Map;

public class StockQuantity {
    private static final Map<Ticker, Integer> QUANTITY_MAP = new HashMap<>();

    private StockQuantity() {
    }

    public static void put(Ticker ticker, Integer quantity) {
        QUANTITY_MAP.put(ticker, quantity);
    }

    public static int get(Ticker ticker) {
        return QUANTITY_MAP.get(ticker);
    }
}
