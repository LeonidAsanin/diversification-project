import assets.FinExTicker;
import assets.VTBTicker;
import dataEntering.StockQuantityEntering;
import database.StockQuantity;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StockQuantityEnteringTest {

    @Test
    public void testEntering() {
        var unsuccessfulCounter = 0;
        var tryCounter = 0;

        for (var ticker : FinExTicker.values()) {
            try (var fileInputStream = new FileInputStream("src/test/resources/UnsuccessfulEnteringScenarios.txt")) {
                tryCounter++;
                var scanner = new Scanner(fileInputStream);
                StockQuantityEntering.enter(ticker, scanner, new StockQuantity());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e) {
                unsuccessfulCounter++;
            }
        }

        for (var ticker : VTBTicker.values()) {
            try (var fileInputStream = new FileInputStream("src/test/resources/UnsuccessfulEnteringScenarios.txt")) {
                tryCounter++;
                var scanner = new Scanner(fileInputStream);
                StockQuantityEntering.enter(ticker, scanner, new StockQuantity());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e) {
                unsuccessfulCounter++;
            }
        }
        Assert.assertEquals(tryCounter, unsuccessfulCounter);
    }
}
