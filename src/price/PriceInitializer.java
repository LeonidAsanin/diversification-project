package price;

import database.StockPrices;

public class PriceInitializer {
    private PriceInitializer() {
    }

    public static void initialize() {
        var priceInitializingThread = new Thread(StockPrices::updateAll);
        priceInitializingThread.setDaemon(true);
        priceInitializingThread.start();
    }
}
