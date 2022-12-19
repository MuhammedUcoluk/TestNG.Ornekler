package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions extends TestBase {

    @Test
    public void test(){

        //https://demoga.com/droppable adresine gidelim.
        driver.get("https://demoga.com/droppable");
        //"Drag me" butonunu tutup "Drop here"kutusunun üstüne bırakalım.
        Actions actions=new Actions(driver);
        WebElement dragElementi=driver.findElement(By.id("draggable"));
        WebElement dropElementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragElementi,dropElementi).perform();
        //"Drop here" yazisi yerine "Dropped!" olduğunu test edin.

        WebElement droppedYazisi= driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualDropYazisi=droppedYazisi.getText();
        String expectedDropYazisi="Dropped!";
        Assert.assertEquals(actualDropYazisi,expectedDropYazisi,"dropped yazisi beklenenden farkli");



    }

}
