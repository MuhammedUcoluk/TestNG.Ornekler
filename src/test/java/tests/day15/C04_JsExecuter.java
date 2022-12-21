package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_JsExecuter extends TestBase {

    //Amazon a gidip
    //Sell linkine JSExecuter ile tıklayalım
    //ilgili sayfaya gittiğimizi test edelim.

    @Test
    public void test01() throws InterruptedException, IOException {
        driver.get("https://www.amazon.com");

        //1.Adım Js Executer objesi oluşturalım ve cast edelim.
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //2.Adım İlgili web elementi locate edelim.
        WebElement sellElementi=driver.findElement(By.xpath("//a[text()='Sell']"));

        //3.Adım İlgili script ve argüment ile Js objemiz üzerinden executedScript methodunu çalıştıralım

        jse.executeScript("arguments[0].click();",sellElementi);

        Thread.sleep(5000);

        WebElement ilgiliSayfaElementi= driver.findElement(By.xpath("//h1[text()='Sell on Amazon']"));


        TakesScreenshot tss=(TakesScreenshot) driver;
        File tumSayfa=new File("target/screenshot/sell.jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfa);


        Assert.assertTrue(ilgiliSayfaElementi.isDisplayed());

    }
}
