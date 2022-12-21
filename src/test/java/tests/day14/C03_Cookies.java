package tests.day14;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void test01(){
        //amazona gidin.
        driver.get("https://www.amazon.com");
        //tüm cookileri listeleyin.
        Set<Cookie> cookieSet=driver.manage().getCookies();
        System.out.println(cookieSet);

        int sayac=1;
        for (Cookie each:cookieSet
             ) {
            System.out.println(sayac+". cookie" + each);
            sayac++;
        }

        //Sayfadaki cookies sayısının 5 ten büyük olduğunu test edin.

        Assert.assertTrue(cookieSet.size()>5);

        //ismi i18n-prefs olan cookie değerinin USD olduğunu test edin.
        Cookie i18n= driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("cookie i18n değeri" + i18n);
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"));

        //ismi "en sevdiğim cookie" ve değeri "cikolatalı" olan bir cookie oluşturun ve sayfaya ekleyin.
        Cookie mycookie=new Cookie("en sevdiğim cookie","çikolatali");
        driver.manage().addCookie(mycookie);

        //eklediğiniz cookie nin sayfaya eklendiğini test edin.
        int sayac2=1;
        Set<Cookie>cookieSet2=driver.manage().getCookies();
        for (Cookie each:cookieSet2
        ) {
            System.out.println(sayac2+". cookie" + each);
            sayac2++;
        }
        Assert.assertTrue(cookieSet2.contains(mycookie));

        //ismi skin olan cookie yi silin ve silindiğini test edin.
        driver.manage().deleteCookieNamed("skin");
        int sayac3=1;
        Set<Cookie>cookieSet3=driver.manage().getCookies();
        for (Cookie each:cookieSet3
        ) {
            System.out.println(sayac3+". cookie" + each);
            sayac3++;
        }
        Assert.assertFalse(cookieSet3.contains(driver.manage().getCookieNamed("skin")));

        //tüm cookileri silin ve silindiğini test edin.
        driver.manage().deleteAllCookies();
        Set<Cookie> cookieSet4=driver.manage().getCookies();

        Assert.assertTrue(cookieSet4.size()==0);

    }
}
