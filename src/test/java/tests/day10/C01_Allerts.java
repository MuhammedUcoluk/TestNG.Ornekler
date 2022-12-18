package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Allerts {



    WebDriver driver;
    @BeforeClass
    public void setup(){
        //1. https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAllert(){
        //Bir method oluşturun acceptAlert
        //  1.butona tıklayın,uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert"
        //olduğunu test edin.
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        WebElement kabulyazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualKabulYazisi= kabulyazisiElementi.getText();
        String expectedyazi="You successfully clicked an alert";

        Assert.assertEquals(actualKabulYazisi,expectedyazi,"verilen yazi ile eşleşmiyor");


    }
    @Test
    //Bir method oluşturun dismissAlert
    public void dismissAlert(){
        //2.butona tıklayın uyarıdaki cancel butonuna tıklayın ve result mesajının "successfully" içermediğini test edin.
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        WebElement resultYazisi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult= resultYazisi.getText();
        String istenmeyenKelime="successfully";

        Assert.assertFalse(actualResult.contains(istenmeyenKelime));
    }
    @Test
    //Bir method oluşturunsendKeysAlert
    public void sendKeysAlert(){
    // 3.butona tıklayın uyarıdaki metin kutusuna isminizi yazın
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Muhammed");
        //  Ok butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().accept();
        WebElement resultYazisi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult= resultYazisi.getText();
        String expectedResult="Muhammed";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
