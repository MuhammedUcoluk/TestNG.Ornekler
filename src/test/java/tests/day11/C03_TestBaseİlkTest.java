package tests.day11;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseİlkTest extends TestBase {
    @Test
    public void Test01(){
        driver.get("https://www.amazon.com");
    }
}
