package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C05_MouseActions extends TestBase {

    @Test
    public void test(){
        //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement accountMenu= driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountMenu).perform();

        //3- “Create a list” butonuna basalim
        WebElement createmenu= driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.click(createmenu).perform();

        String birinciSayfaHandle= driver.getWindowHandle();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        Set<String> handles=driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each: handles
             ) {
            if (!each.equals(birinciSayfaHandle)){
                ikinciSayfaHandle+=each;

            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
        WebElement yourList= driver.findElement(By.xpath("//li[@class='a-tab-heading a-active a-size-large']"));
        String actualyazi=yourList.getText();
        String expectedYazi="Your Lists";

        Assert.assertEquals(actualyazi,expectedYazi);
    }
}
