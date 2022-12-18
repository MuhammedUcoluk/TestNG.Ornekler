package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void dropdownTesti(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1 i seçin ve yazdırın.
        WebElement dropDownElementi=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDownElementi);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2 yi seçin ve yazdırın.
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //3.Visiable Text(Görünen metin) kullanarak Seçenek 1 i seçin ve yazdırın.
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri yazdırın.
        List<WebElement>optionList=select.getOptions();
        for (WebElement each:optionList
             ) {
            System.out.println(each.getText());
        }


        //5.Dropdownun boyutunu bulun, Dropdown da 4 öğe bulunduğunu test edin.
        int actualSize= optionList.size();
        int expectedSize=4;

        Assert.assertEquals(actualSize,expectedSize,"Opsiyon sayisi beklentileri karşilamıyor");

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
