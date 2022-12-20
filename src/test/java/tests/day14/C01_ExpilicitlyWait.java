package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExpilicitlyWait extends TestBase {

    @Test
    public void implicitlyWaitTest(){

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

    }

    @Test
    public void explicitlyWaitTest() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //expilictlywait kullanabilmek için önce wait objesi oluşturmalıyız.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
       // WebElement itsGoneElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));

        //wait.until(ExpectedConditions.visibilityOf(itsGoneElementi));

        //Her ne kadar kodun anlaşılabilir olması için önce locate sonra bekle yaklaşımı güzel gözükse de
        //Web Element zaten görüünür olmadığından Locacte etmemizde mümkün olmayacaktır.
        //Bu durumda locate ve bekleme işini beraber yapmamız gerekir.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        WebElement itsGoneElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        // veya once locate edip uygun method kullanarak beklemeyi yaptirabiliriz
        // ancak bu test icin once webelement'i olusturmak anlamsiz olur
        // cunku biz wait i;lemini zaten o webelement olussun diye yapiyoruz
        // wait olmadan o element olmaz , o element olmadan da sectigimiz method caismaz
        /*
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed());
        */

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='add']"));

        //7. It’s back mesajinin gorundugunu test edin

    }
}