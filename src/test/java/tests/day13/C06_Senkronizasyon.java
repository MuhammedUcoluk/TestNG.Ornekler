package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //TESTBASE DEKİ İMPLİCİTYWAİT İ KAPATINCA THREAD KOYMAZSAM KOD DOĞRU OLMASINA RAĞMEN ÇALIŞMIYOR.
        //HER DEFASINDA UĞRAŞMAMAK İÇİN İMPLİCİTYWAİT AKTİF OLARAK BİZİ BEKLER.

       // driver.get("https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin");
        //disable butonuna basın
        //disable yazdıgını test edin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        Thread.sleep(3500);

        WebElement itsEnableYazisi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnableYazisi.isDisplayed());

        Thread.sleep(5000);


    }
}
