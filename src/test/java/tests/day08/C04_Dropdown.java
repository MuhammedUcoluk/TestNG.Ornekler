package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {


    WebDriver driver;
    WebElement dropDownElementi;
    Select select;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void kategoriSayisiTesti(){
        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //Test-1
        //1.Kategori seçeneğinden Books seçeneğini seçin.
        WebElement kategori= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(kategori);

        List<WebElement> optionList=select.getOptions();
        int actualKategoriSayisi=optionList.size();
        int expectedkategoriSayisi=45;

        Assert.assertEquals(actualKategoriSayisi,expectedkategoriSayisi);
    }
    @Test
    public void test02(){
        driver.get("https://www.amazon.com/");
        //1. Kategori menüsünden Books seçeneğini seçin.
        WebElement kategori= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(kategori);
        select.selectByIndex(5);

        //2.Arama kutusuna java yazın ve aratın.
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        //3.Bulunan sonuç sayısını yazdırın.
        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
        //4.Sonucun Java kelimesini içerdiğini test edin.

    }
    @AfterClass
    public void teardown(){
        //driver.close();
    }
}
