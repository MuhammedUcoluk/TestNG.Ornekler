package tests.day08;

import org.testng.annotations.Test;

public class C01_Priority {
    @Test(priority = 9)
    public void youtubeTesti(){
        System.out.println("youtube testi çalıştı");
    }
    @Test(priority = 3)
    public void amazonTesti(){
        System.out.println("amazon testi çalıştı");
    }
    @Test // eğer priority atanmazsa default olarak 0 sıfır kabul eder.
    public void bestBuyTesti(){
        System.out.println("bestbuy testi çalıştı");
    }
}
