package database;

import assets.Ticker;

import java.util.HashMap;
import java.util.Map;

public class QuantityOfShares {
    private static final Map<Ticker, Integer> quantityMap = new HashMap<>();

    private QuantityOfShares() {
    }

    public static void put(Ticker ticker, Integer quantity) {
        quantityMap.put(ticker, quantity);
    }

    public static int get(Ticker ticker) {
        return quantityMap.get(ticker);
    }
}
