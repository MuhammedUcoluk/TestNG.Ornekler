package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_SoftAssert {
    WebDriver driver;

    //1. "http://zero.webappsecurity.com/" adresine gidin.
    //2. Sign in butonuna basın
    //3. Login kutusuna "username" yazın
    //4. Password kutusuna "password" yazın
    //5. sign in yuşuna basın
    //6. Online banking menüsü içinde Pay Bills sayfasına gidin.
    //7. "Purchase Foreign Currency" tuşuna basın.
    //8. "Currency" drop down menüsünden Eurozone'u seçin.
    //9. soft assert kullanarak "Eurozone(Euro)"seçildiğini test edin.
    //10. soft assert kullanarak Dropdown listesinin şu seçenekleri olduğunu test edin. " Select one","Australia(dollar)
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    public void test() {
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropDown);
        select.selectByValue("EUR");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        String actualData = select.getFirstSelectedOption().getText();
        String expectedValue = "Eurozone (euro)";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualData, expectedValue, "seilen option Euro Zone degil");


        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> tumOpsiyonlar = select.getOptions();
        // option listesi webelementlerden olusyor
        // expected liste ise String, bunun icin opsiyon listyesini String yapmaliyiz

        List<String> tumOpsiyonlarString = new ArrayList<>();
        for (WebElement each : tumOpsiyonlar
        ) {
            tumOpsiyonlarString.add(each.getText());
        }

        List<String> expectedOptionsList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)");

        softAssert.assertEquals(tumOpsiyonlarString, expectedOptionsList, "liste farkli");

        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown() {

        driver.close();
    }
}
