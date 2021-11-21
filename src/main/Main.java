package main;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;
import consoleIO.CalculationOfInvestmentPortfolio;
import database.ShareOfCountryInAssetMatrix;
import database.SharePrices;
import diversificationCriterion.Country;
import consoleIO.EnteringOfShareQuantity;
import utilities.MapUtil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var priceInitializingThread =  new Thread(SharePrices::update);
        priceInitializingThread.setDaemon(true);
        priceInitializingThread.start();

        System.out.println("Enter the number of shares you have:");
        var scanner = new Scanner(System.in);
        for (var ticker : FinExTicker.values())
            EnteringOfShareQuantity.enter(ticker, scanner);
        for (var ticker : VTBTicker.values())
            EnteringOfShareQuantity.enter(ticker, scanner);
        scanner.close();

        System.out.println();
        System.out.println("Your investment portfolio: ");
        var portfolioSum = 0.;
        var portfolioMap = new HashMap<Ticker,Double>();
        for (var ticker : FinExTicker.values())
            portfolioSum += CalculationOfInvestmentPortfolio.returnTotalPriceByTickerAndPutIntoMap
                    (ticker, portfolioMap);
        for (var ticker : VTBTicker.values()) {
            portfolioSum += CalculationOfInvestmentPortfolio.returnTotalPriceByTickerAndPutIntoMap
                    (ticker, portfolioMap);
        }
        System.out.println("------------------------------------------");
        System.out.print("Sum of all assets:\t\t");
        System.out.printf("%16.2f ₽\n", portfolioSum);

        Map<Country,Double> diversificationMap = new HashMap<>();
        for (Country country : Country.values()) {
            var totalShareInRubles = 0.;
            for (var ticker : FinExTicker.values())
                totalShareInRubles += ShareOfCountryInAssetMatrix.getShare(country,ticker) *
                        portfolioMap.getOrDefault(ticker,0.);
            for (var ticker : VTBTicker.values())
                totalShareInRubles += ShareOfCountryInAssetMatrix.getShare(country,ticker) *
                        portfolioMap.getOrDefault(ticker,0.);
            if (totalShareInRubles < 0.01) continue;
            diversificationMap.put(country,totalShareInRubles);
        }
//        var sortedDiversificationMap = diversificationMap.entrySet().stream().
//                sorted(Map.Entry.<Country,Double>comparingByValue().reversed()).
//                collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
        diversificationMap = MapUtil.sortByValue(diversificationMap);

        System.out.println();
        System.out.println("Diversification you have:");
        for (Map.Entry<Country,Double> entry : diversificationMap.entrySet()) {
            System.out.printf("%-15s %13.2f ₽ (%6.2f %%)\n",entry.getKey() + ":", entry.getValue(), entry.getValue() / portfolioSum * 100);
        }
    }
}