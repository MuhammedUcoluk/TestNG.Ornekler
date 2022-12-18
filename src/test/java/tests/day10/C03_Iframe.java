package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_Iframe {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    //https://the-internet.herokuapp.com/iframe adresine gidin
    //Bir method oluşturun



    @Test
    public void IframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        //"An IFrame containing.." textinin erişelebilir olduğunu test edin ve consolda yazdirin.
    WebElement girisYazisiElementi= driver.findElement(By.tagName("h3"));
    SoftAssert softAssert=new SoftAssert();
    softAssert.assertTrue(girisYazisiElementi.isEnabled(),"Iframe yazisi görünmüyor.");
        System.out.println(girisYazisiElementi.getText());


        //Text Box a "Merhaba Dünya!"yazin.
        //Yazi yazmak istediğimiz text kutusu iframe içinde olduğundan direk ulaşamıyoruz!
        //önce frame yi locate edip, onun içine switch yapmalıyız.
        WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textbox= driver.findElement(By.tagName("p"));
        textbox.clear();
        textbox.sendKeys("Merhaba Dünya!");
        //Text Box ın altında bulunan "Elemental Selenium" linkini tiklayin.


        //Yukarida iframe içine switch yaptigimizdan yeniden dışarı çıkmadan  sayfa içinde başka yere tıklayamayız.
        // burada parentFrame=içinde bulunduğumuz iframe den eğer girdiysek bir önceki iframe e geçiş
        //defaultContent = ana sayfaya dönmek için kullanılır.
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //yeni sayffada "Sponsored by Sauce Labs" textinin görünür olduğunu doğrulayın ve consolda yazdirin.

        //sponsored yazisi yeni sayfada olduğundan ve driver eski sayfada kaldığından yazıyı locate edemedik!!!

        WebElement sponsoredYazisiElementi= driver.findElement(By.xpath("//p[text()='Sponsored by '] "));
        softAssert.assertTrue(sponsoredYazisiElementi.isDisplayed(),"sponsored yazisi görünmüyor.");

        softAssert.assertAll();

    }
    @AfterClass
    public void teardown(){

        driver.quit();
    }
}
