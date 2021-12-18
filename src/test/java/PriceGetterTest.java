import assets.FinExTicker;
import assets.VTBTicker;
import org.junit.Assert;
import org.junit.Test;
import price.PriceGetter;

public class PriceGetterTest {

    @Test(timeout = 60_000L)
    public void shouldGetAllValues() {
        for (var ticker : FinExTicker.values()) {
            Assert.assertNotEquals(0, PriceGetter.get(ticker), 0.01);
        }
        for (var ticker : VTBTicker.values()) {
            Assert.assertNotEquals(0, PriceGetter.get(ticker), 0.01);
        }
    }
}
