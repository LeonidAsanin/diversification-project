package main;

import assets.VTBTicker;
import price.PriceGetter;

public class TestMain {
    public static void main(String[] args) {
        for (var ticker : VTBTicker.values()) {
            try {
                System.out.println(ticker + ": " + PriceGetter.get(ticker));
            } catch (Exception e) {
                System.out.println("Exception");
            }
        }
    }
}
