package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
}
@Test
public void handleWindow() throws InterruptedException {
    driver.get("https://www.amazon.com");
    String windowHandle1=driver.getWindowHandle();
    System.out.println("ilk sayfanin handle değeri "+driver.getWindowHandle());//driver in içinde bulunduğu handle değeri verdi

    driver.switchTo().newWindow(WindowType.WINDOW); //yeni bir pencere açilir.
    driver.get("https://www.bestbuy.com");
    String windowHandle2=driver.getWindowHandle();
    System.out.println("ikinci sayfanin handle değeri "+driver.getWindowHandle());// driver i yeni pencereye yollamistik. Yeni sayfanın değerini verdi.

    Set<String> handleDegerleriSet=driver.getWindowHandles();
    System.out.println(handleDegerleriSet);
    Thread.sleep(3000);

    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.facebook.com");

    //amazonun açık olduğu sayfaya geçin ve nutella için arama yapın.

    driver.switchTo().window(windowHandle1);
    WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

    //bestbuya geçin ve title nın bestbuy içerdiğini test edin.
    driver.switchTo().window(windowHandle2);
    Assert.assertTrue(driver.getTitle().contains("Best Buy"));

    //facebook un açık olduğu sayfaya geçin ve sayfa url sinin https://www.facebook.com olduğunu test edin.

    //Eğer açık olan pencerelerden sadece 1 tanesinin window handle değeri bilinmiyorsa;
    //Önce tüm handle değerlerini bulup bir Set e koyarız.
    handleDegerleriSet=driver.getWindowHandles();


    //bu soru için şu anda Set te 3 window handle değeri var. 1 ve 2. sayfanın window handle değerlerini biliyoruz.
    //Setimizde olup ilk 2 sayfaya ait olmayan handle değeri 3. ü sayfa handle değeridir.

    String windowHandle3="";
    for (String each:handleDegerleriSet
         ) {
        if (!(each.equals(windowHandle1)||each.equals(windowHandle2))){
            windowHandle3=each;
        }
    }
    System.out.println("üçüncü sayfanın handle değeri" + windowHandle3);
    System.out.println(handleDegerleriSet);

    driver.switchTo().window(windowHandle3);
    String actualfaceUrl= driver.getCurrentUrl();
    String expectedUrl="https://www.facebook.com/";

    Assert.assertEquals(actualfaceUrl,expectedUrl,"url değerleri aynı değil.");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
