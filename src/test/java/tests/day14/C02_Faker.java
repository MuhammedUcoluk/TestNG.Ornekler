package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //“firstName” giris kutusuna bir isim yazin
        WebElement firstNameElementi= driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.click(firstNameElementi)
                .sendKeys(faker.name().name())
        //“surname” giris kutusuna bir soyisim yazin
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
        //“email” giris kutusuna bir email yazin
                .sendKeys(Keys.TAB)
                .sendKeys(email)
        //“email” onay kutusuna emaili tekrar yazin
                .sendKeys(Keys.TAB)
                .sendKeys(email)
        //Bir sifre girin
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
        //Tarih icin gun secin
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
        //Tarih icin ay secin
                .sendKeys(Keys.TAB)
                .sendKeys("15")
        //Tarih icin yil secin
                .sendKeys(Keys.TAB)
                .sendKeys("1972")
        //Cinsiyeti secin
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();


        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement erkeksecimElemnti= driver.findElement(By.xpath("//input[@value='2']"));
        WebElement kadinsecim= driver.findElement(By.xpath("//input[@value='1']"));

        Assert.assertTrue(erkeksecimElemnti.isSelected());
        Assert.assertFalse(kadinsecim.isSelected());

        //Sayfayi kapatin
    }
}