package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist() ve downloadTest()



    @Test
    public void isExist(){
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\logotitle.png";
        System.out.println(dosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
    @Test
    public void downloadTest() throws InterruptedException {
        //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
        //		- https://the-internet.herokuapp.com/download adresine gidelim.


        //		- logo.png dosyasını indirelim
        driver.get("https://the-internet.herokuapp.com/download");

        WebElement logoTitle= driver.findElement(By.xpath("//a[text()='logotitle.png']"));
        logoTitle.click();

        Thread.sleep(5000);
    }

}


