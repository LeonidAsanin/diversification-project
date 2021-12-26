package database;

import assets.Ticker;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that stores information about user's each stock quantity.
 *
 * @author lennardjones
 * @version 1.1
 * @since 1.0
 */
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
