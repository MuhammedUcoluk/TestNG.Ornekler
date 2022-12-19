package tests.day12;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {
    //Amazon anasayfaya gidin.
    //Hello Sign in elementi üzerinde mouse ı bekletin.
    //Açılan menüden new list linkine tıklayın
    //ve new list sayfasının açıldığını test edin.

    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement helloElement=driver.findElement(By.xpath("(//span[@class='nav-line-1 nav-progressive-content'])[2]"));
        actions.moveToElement(helloElement).perform();

        Thread.sleep(5000);
        WebElement createList= driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.click(createList).perform();

        String actualtite= driver.getTitle();
        String arananMetin="Your List";
        //Assert.assertTrue(actualtite.contains(arananMetin));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualtite.contains(arananMetin));
        softAssert.assertAll();
    }


}
