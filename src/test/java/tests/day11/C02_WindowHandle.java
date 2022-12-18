package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {

    WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void windowHandletest(){
        // ● Tests package’inda yeni bir class olusturun: C02_WindowHandle
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaText= driver.findElement(By.tagName("h3"));
        String actualtext=sayfaText.getText();
        String expectedText="Opening a new window";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualtext,expectedText,"Sayfadaki yazi beklenenden farkli");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle(),"The Internet","Sayfa title ı beklenenden farkli");

        // 1- window handle ederken ilk adim 1 sayfa acik iken o sayfanin handle degerini alip bir string'e atamak
        String handle1=driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        // bu satirda 2.window acildi
        // 2- ikinci adim iki sayfa acildiginda her iki sayfanin handle degerlerini koymak icin
        //   bir set olusturup, getWindowhandles methodu ile bu degerleri elde etmek

        Set<String> HandleDegerleriSet=driver.getWindowHandles();
        System.out.println(HandleDegerleriSet);



        // 3- ucuncu adim set icerisinde birinci sayfanin handle degerine esit olmayan
        //    handle degerini bulup bir string degiskene atamak
        String handle2="";
        for (String each:HandleDegerleriSet
             ) {

            if (!each.equals(handle1)){
                handle2=each;
            }
        }


        // bu satira geldigimizde elimizde 2.sayfain handle degeri var olacak ve 2inci sayfaya geçebilirim
        driver.switchTo().window(handle2);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        softAssert.assertEquals(driver.getTitle(),"New Window","2.sayfa titleı aynı değil");

        // switchTo ile window degistireceksek gidecegimiz window'un windowhandle degerine ihtiyacimiz var...


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaText= driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikinciSayfaText.getText(),"New Window","Sayfa Texti ayni değil");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(handle1);
        softAssert.assertEquals(driver.getTitle(),"The Internet", "Sayfa başlığı aynı değil.");

        softAssert.assertAll();
    }
    @AfterMethod
    public void tearndown(){
        driver.quit();
    }




    }

