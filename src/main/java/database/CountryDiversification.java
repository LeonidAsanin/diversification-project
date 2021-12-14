package database;

import assets.FinExTicker;
import assets.VTBTicker;
import diversificationCritetion.Country;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryDiversification {
    private static Map<Country, Double> map = new HashMap<>();

    private CountryDiversification() {
    }

    static {
        calculate();
        sort();
    }

    private static void calculate() {
        for (var country : Country.values()) {
            var totalShareInRubles = 0.;

            for (var ticker : FinExTicker.values())
                totalShareInRubles += CountryShares.get(country, ticker) *
                                      InvestmentPortfolio.getTotalPriceByTicker(ticker);
            for (var ticker : VTBTicker.values())
                totalShareInRubles += CountryShares.get(country, ticker) *
                                      InvestmentPortfolio.getTotalPriceByTicker(ticker);

            if (totalShareInRubles < 0.01) continue;

            map.put(country, totalShareInRubles);
        }
    }

    private static void sort() {
        map = map.entrySet().stream().sorted(Map.Entry.<Country, Double>comparingByValue().reversed()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static void show() {
        System.out.println("\nDiversification you have:");

        for (var entry : map.entrySet())
            System.out.printf("%-15s %13.2f ₽ (%6.2f %%)\n", entry.getKey() + ":", entry.getValue(),
                              entry.getValue() / InvestmentPortfolio.getSum() * 100);
    }
}
