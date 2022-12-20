package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
            public void Test01(){
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //1. File seçme butonunu locate edelim.
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));

        //2.Yükleyeceğimiz dosyanın dinamik yolunu hazırlayalım
        String dosyaYolu=System.getProperty("user.home") +"\\Desktop\\DENEME\\metinbelgesi.txt";

        //3.SendKeys methodu ile dinamik pathi dosya seç butonuna yollayalım.
        dosyaSec.sendKeys(dosyaYolu);

        //Yuklemek istediginiz dosyayi secelim.


        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();


        //“File Uploaded!” textinin goruntulendigini test edelim.
         WebElement fileupload=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileupload.isDisplayed());

    }

}
