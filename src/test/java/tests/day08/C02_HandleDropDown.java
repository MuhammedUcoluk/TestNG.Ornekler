package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropDown {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void dropDownTesti() throws InterruptedException {
        //=======dropdown da var olan seçeneklerden birini seçmek için========
        //1. adim: Droptan web elementini locate edip bir değişkene atıyoruz.
        driver.get("https://www.amazon.com");
        WebElement dropDownElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2. adim: Select classından bir obje oluşturalım ve
        //parametre olarak locate ettiğimiz Webelementi yazalım.

        Select select=new Select(dropDownElementi);

        //3. adım : Select objesini kullanarak Select classından var olan 3 seçim methodundan
        //istediğimizi kullanarak dropdown da var olan option lardan istediğimizi seçebiliriz.
        // Seçim yapmamıza yardım eden bu 3 method void dir. Dolayısı ile bize birşey döndürmezler.
        select.selectByIndex(3);

        //eğer seçtiğimiz option değerini yazdırmak istersek
        System.out.println(select.getFirstSelectedOption().getText());//Baby

        Thread.sleep(3000);

        select.selectByVisibleText("Deals");

        Thread.sleep(3000);

        select.selectByValue("search-alias=arts-crafts-intl-ship");
         // drop içindeki tüm optionları yazdırmak için önce Liste attık.
        //Sonra for each ile yazdırdık.
        List<WebElement> optionList=select.getOptions();
        for (WebElement each:optionList
             ) {
            System.out.println(each.getText());
        }


    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
