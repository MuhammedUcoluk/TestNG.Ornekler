package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {

    //https://html.com/tags/iframe/ sayfasına gidelim.
    //videoyu görecek kadar aşağı inin
    //videoyu izlemek için play tuşuna basın
    //videoyu çalıştırdığınızı test edin.

    @Test
    public void test() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        driver.findElement(By.xpath("//div[@class='render']"));

        WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframeElementi);
        WebElement playTusu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();


        Assert.assertTrue(playTusu.isEnabled());

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
    }

}
