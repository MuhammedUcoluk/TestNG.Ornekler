package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BasicAuthentication {

    WebDriver driver;
    @BeforeClass
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void authenticationTesti(){
        //http://the-internet.herokuapp.com/basic_auth sayfasına gidin.
        //aşağıdaki yöntem ve test datalarını kullanaraka authentication u yapın.
        //
        //Html komutu : https://username:password@URL
        //username : admin
        //password : admin
        //driver.get("http://the-internet.herokuapp.com/basic_auth");


        //driver get le gidemem authentication u geçip giriş yapamam.
        //basicauthentication isteyen web servisleri bize nasıl ve hangi bilgilerle auyhentication
        //yapabileceğimiz bilgisini vermek zorundadır.
        //biz de bize tarif edilen yöntem ve bize verilen bilgileri bire bir uygulayarak
        //istediğimiz web servise giriş sağlayabiliriz.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Başarılı şekilde sayfaya girildiğini doğrulayın.

        WebElement basariliGirisElementi= driver.findElement(By.tagName("p"));
        String basariligiris= basariliGirisElementi.getText();

        Assert.assertTrue(basariliGirisElementi.isDisplayed());



    }
}
