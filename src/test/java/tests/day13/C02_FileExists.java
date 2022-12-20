package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home"));

        //masaüstündeki deneme klasörünün Pathi

        //dinamik olarak masaüstündeki deneme klasörünün pathini yazmak istersem.

        String path=System.getProperty("user.home")+"\\Desktop\\DENEME\\selenium.xlsx";
        System.out.println(path);

        System.out.println("user.dir"+System.getProperty("user.dir"));

        //Masaüstünde DENEME klasörü içerisinde selenium.xlsx isminde bir dosya olduğunu test edin.

        //1. Önce bu dosyaya ulaşmak için gerekli dinamik path oluşturulmalı.

        String dosyaYolu=System.getProperty("user home")+"\\Desktop\\DENEME\\selenium.xlsx";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        //Projemizde pom.xml var olduğunu test edin.

        //C:\Users\SAMSUNG\IdeaProjects\com.TestNGBatch44\pom.xml

        System.out.println(System.getProperty("user.dir")); //proje yolunu verir.
        //C:\Users\SAMSUNG\IdeaProjects\com.TestNGBatch44

        String pomPath=System.getProperty("user.dir") + "\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));

    }
}
