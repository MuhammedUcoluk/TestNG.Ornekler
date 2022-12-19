package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Set;

public class C03_MouseActions extends TestBase {

    @Test
    public void mouseAction(){
        //1- Yeni bir class olusturalim: C03_MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan= driver.findElement(By.xpath("//div[@oncontextmenu='displayMessage()']"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String expectedAllertYazisi="You selected a context menu";
        String actualAllertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(actualAllertYazisi,expectedAllertYazisi,"Allert yazisi beklenenden farklı.");



        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String okuhandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String> handles=driver.getWindowHandles();
        String elementalhandle="";
        for (String each:handles
             ) {
            if (!each.equals(okuhandle)){

                elementalhandle+=each;
            }
        }
        driver.switchTo().window(elementalhandle);
        String expectedYazi="Elemental Selenium";
        String h1tag= driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(h1tag,expectedYazi,"ikinciSayfa yazi istenenden farkli.");

    }

}
