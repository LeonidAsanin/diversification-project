import org.lennardjones.diversificationproject.assets.FinExTicker;
import org.lennardjones.diversificationproject.assets.VTBTicker;
import org.lennardjones.diversificationproject.database.CountryShares;
import org.lennardjones.diversificationproject.diversificationCriterion.Country;
import org.junit.Assert;
import org.junit.Test;

public class CountrySharesTest {

    @Test
    public void shouldGetAllValues() {
        System.out.printf("%15s", "");

        for (var ticker : FinExTicker.values()) {
            System.out.printf("%-5s ", ticker);
        }
        for (var ticker : VTBTicker.values()) {
            System.out.printf("%-5s ", ticker);
        }
        System.out.println();

        for (var country : Country.values()) {
            System.out.printf("%-15s", country);
            for (var ticker : FinExTicker.values()) {
                System.out.printf("%.3f ", CountryShares.get(country, ticker));
            }
            for (var ticker : VTBTicker.values()) {
                System.out.printf("%.3f ", CountryShares.get(country, ticker));
            }
            System.out.println();
        }
    }

    @Test
    public void shouldGetAllValuesFromDatabase() {
        Assert.assertTrue(CountryShares.getAllValuesFromDatabase());
    }
}
