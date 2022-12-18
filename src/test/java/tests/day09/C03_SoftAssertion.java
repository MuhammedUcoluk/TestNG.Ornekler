package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {
    @Test
    public void test(){

        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(a,b,"1. Test Başarısız");//Failed
        softAssert.assertTrue(a>b,"2.Test Başarısız");//Failed
        softAssert.assertTrue(a<c,"3.Test Başarısız");//Passed
        softAssert.assertTrue(c>b,"4.Test Başarısız");//Passed
        softAssert.assertTrue(c<a,"5.Test Başarısız");//Failed
        //assertAll demezsek class çalışır ve pass yazsar. Aslında raporlama yapmaz.SAdece kodlar çalışmış olur.
        softAssert.assertAll();
        System.out.println("eğer softassertlardan failed olan varsa bu satır çalışmaz.");
    }
}
