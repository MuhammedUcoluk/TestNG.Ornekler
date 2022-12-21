package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotWebElement extends TestBase {

    @Test
    public void nutellaTesti() throws InterruptedException, IOException {
        //amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");

        //nutella için arama yapalım
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //sonuçların nutella içerdiğini test edelim
        WebElement sonucYazisiElemeti= driver.findElement(By.xpath("//span[text()='\"Nutella\"']"));
        String sonucYazisiStr= sonucYazisiElemeti.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Nutella"));

        //Testin çalıştığının ispatı için sonuc yazısı Webelementinin screenshot unu alalım

        //Tüm sayfa screenshot için 4 adım gerekli.

        //1==>Screenshot çekeceğimiz Webelementi locate ederim.


        //2==>Screenshot ı Kaydedeceğimiz dosyayı oluşturalım.
        File webElementSS=new File("target/screenshot/webelement.jpeg");

        //3==> Bir dosya daha oluşturup screenshot objesi ile screenshot ı alalım
        File geciciResim=sonucYazisiElemeti.getScreenshotAs(OutputType.FILE);

        //4==> geçici resmi kaydetmek istediğimiz asıl dosyaya copy yapalım

        FileUtils.copyFile(geciciResim,webElementSS);






        Thread.sleep(5000);
    }
}
