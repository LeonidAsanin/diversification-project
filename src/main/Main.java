package main;

import Assets.FinExTicker;
import Assets.Ticker;
import price.PriceGetter;

public class Main {
    public static void main(String[] args) {
        for (Ticker ticker : FinExTicker.values()) {
            try {
                System.out.println(ticker + ": " + PriceGetter.get(ticker) + " ₽");
            } catch (NumberFormatException e) {
                System.out.println(ticker + " causes NumberFormatException");
            }
        }
    }
}