package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTestler {
   static WebDriver driver;
   static WebElement searchBox;
   static WebElement sonucYazisiElementi;

    @Test
    public void test01() {
        // amazon sayfasinda nutella icin arama yapip sonuc yazisinin nutella icerdigini test edelim
        searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella" + Keys.ENTER);
        sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        String arananKelime="nutella";

        System.out.println(actualSonucYazisi.contains(arananKelime) ? "Nutella testi PASS" : "Nutella testi FAIL");
    }

    @Test
    public void test02() {
        // amazon sayfasinda java icin arama yapip sonuc yazisinin java icerdigini test edelim
        // searchBox.clear();
        driver.navigate().back();
        searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java" + Keys.ENTER);
        sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        String arananKelime="java";

        System.out.println(actualSonucYazisi.contains(arananKelime) ? "java testi PASS" : "java testi FAIL");
    }

    @Test
    public  void test03() {
        // amazon sayfasinda ali icin arama yapip sonuc yazisinin ali icerdigini test edelim
        // searchBox.clear();
        driver.navigate().back();
        searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("ali" + Keys.ENTER);
        sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        String arananKelime="ali";

        System.out.println(actualSonucYazisi.contains(arananKelime) ? "ali testi PASS" : "ali testi FAIL");

    }

    @BeforeClass
    public static void ayarlariDuzenle() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void ortaligiTopla() {
        driver.close();
    }
}
