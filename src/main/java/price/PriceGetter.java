package price;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PriceGetter {
    private PriceGetter() {
    }

    public static <T extends Ticker> double get(T ticker) {
        if (ticker instanceof FinExTicker)
            return getForFinEx((FinExTicker) ticker);
        if (ticker instanceof VTBTicker)
            return getForVTB((VTBTicker) ticker);
        return 0;
    }

    private static double getForFinEx(FinExTicker ticker) {
        String currentPrice = "";
        URLConnection urlConnection;
        double thousands = 0;

        try {
            var url = new URL("https://finex-etf.ru/products/" + ticker);
            urlConnection = url.openConnection();
        } catch (MalformedURLException e) {
            System.out.println("Error in the URL address");
            return 0;
        } catch (IOException e) {
            System.out.println("Error of Input/Output");
            return 0;
        }

        try (var inputStream = urlConnection.getInputStream();
             var bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String infoString;

            /* marker substring for search required string with price data */
            String requiredString = "data-testid=\"singleStockPrice\">";

            while ((infoString = bufferedReader.readLine()) != null) {
                if (infoString.contains(requiredString)) {
                    int requiredIndex = infoString.indexOf(requiredString);

                    /* search for substring that contains price information excluding thousands */
                    int end = infoString.indexOf('₽', requiredIndex);
                    while (infoString.charAt(end) != '<')
                        end--;
                    int start = end;
                    while (infoString.charAt(start) != '>')
                        start--;
                    currentPrice = infoString.substring(start + 1, end);

                    /* obtaining thousands in price if present */
                    int markerIndex = infoString.indexOf(requiredString) + requiredString.length();
                    String substringToFindThousandComponent = infoString.substring(markerIndex, markerIndex + 5);
                    if (substringToFindThousandComponent.contains(",")) {
                        end = 0;
                        while (substringToFindThousandComponent.charAt(end) != ',')
                            end++;
                        thousands = Double.parseDouble(substringToFindThousandComponent.substring(0, end));
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException from BufferedReader");
        }

        return thousands * 1000 + Double.parseDouble(currentPrice);
    }

    private static double getForVTB(VTBTicker ticker) {
        String currentPrice = "";
        URLConnection urlConnection;

        try {
            var url = new URL("https://www.vtbcapital-am.ru/products/bpif/" +
                              ticker.getFundOfficialSitePage() + "/investment_strategy/");
            urlConnection = url.openConnection();
        } catch (MalformedURLException e) {
            System.out.println("Error in the URL address");
            return 0;
        } catch (IOException e) {
            System.out.println("Error of Input/Output");
            return 0;
        }

        try (var inputStream = urlConnection.getInputStream();
             var bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String infoString;

            String requiredString = "Расчетная стоимость пая, рублей"; /* marker substring for search
                                                                          required string with price data */
            var stringFoundMarker = false;
            while ((infoString = bufferedReader.readLine()) != null) {
                if (infoString.contains(requiredString)) {
                    stringFoundMarker = true;
                    continue;
                }
                if (stringFoundMarker) {
                    /* search for substring that contains price information */
                    int end = infoString.indexOf('.');
                    while (infoString.charAt(end) != '<')
                        end++;
                    int start = end;
                    while (infoString.charAt(start) != '>')
                        start--;
                    currentPrice = infoString.substring(start + 1, end);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException from BufferedReader");
        }

        return Double.parseDouble(currentPrice);
    }
}
