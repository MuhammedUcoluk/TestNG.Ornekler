package tests.day09;
//  ====================================ÇALIŞMASI ... METHODUNA BAĞLI OLSUN İSTERSEK============================
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {

    //3. 1. test başarılı ise searchBoxı kullanarak "Nutella" aratın
    //"Nutella" için arama yapıldıysa ilk ürünü tıklayın ve fiyatının $16.83 olduğunu test edin.
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    //2. Amazon ana sayfaya gittiğinizi test edin.
    @Test
    public void logoTest(){
        driver.get("https://www.amazon.com");
        WebElement logoElementi= driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(logoElementi.isDisplayed());

    }
    //3. 1. test başarılı ise searchBoxı kullanarak "Nutella" aratın
    @Test(dependsOnMethods = "logoTest")
    public void aramaTesti(){
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        String actualTitle= driver.getTitle();
        String arananKelime="Nutella";

        Assert.assertTrue(actualTitle.contains(arananKelime));


    }
     //"Nutella" için arama yapıldıysa ilk ürünü tıklayın ve fiyatının $16.83 olduğunu test edin.
     @Test(dependsOnMethods = "aramaTesti")
        public void fiyatTesti(){
        driver.findElement(By.xpath("(//img[@alt='Nutella Hazelnut Spread with Cocoa for Breakfast, Great for Holiday Baking, 35.3 oz Jar'])[1]")).click();
         WebElement fiyat= driver.findElement(By.xpath("//p[@class='a-spacing-none a-text-left a-size-mini twisterSwatchPrice']"));
         String fiyat1= fiyat.getText();
        String expendetFiyat="$16.83";

      Assert.assertTrue(fiyat1.contains(expendetFiyat),"fiyat eşit değil!!!");
    }
    @AfterClass
    public void tearndown(){
        driver.quit();
    }
}
