package tests.day14;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.google.com");

        //1.Adım
        //Screenshot almak için obje oluşturalım ve değer olarak driverımızı atayalım7
        //değer olarak driver ı kabul etmesi için casting yapmamız gerekir.
        TakesScreenshot tss=(TakesScreenshot) driver;

        //2.Adım
        //tüm sayfanın screenshot ını almak için bir file oluşturalım ve dosya yolunu belirtelim.
        File tumsayfaSS=new File("src\\tumsayfa.png");

        //3.Adım
        //Oluşturduğumuz file ile takescreenshot ojesini ilişkilendirelim.
        tumsayfaSS=tss.getScreenshotAs(OutputType.FILE);


        //eğer spesifik bir webelementin screenshot unu almak istiyorsak

        WebElement logoElementi= driver.findElement(By.xpath("//img[@class='lnXdpd']"));

       // File googleResmi=new File("src/")
        }

    }

