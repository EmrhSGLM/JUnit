package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyriTestler {
    //1)    //Bir class oluşturun: BestBuy Assertions
    //2)    //https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    //          Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
    //          titleTest => Sayfa başlığının “ R est” içer me diğini(contains) test edin
    //          logoTest => BestBuy logosunun görüntülen digini test edin
    //          Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void urlTest(){
        //Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.bestbuy.com/";
        Assert.assertEquals("Lutfen test degerlerini gozden gecir",expectedURL, actualURL);
    }
    @Test
    public void titleTest(){
        //titleTest => Sayfa başlığının “ Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Rest";
        Assert.assertFalse("Icermiyor",actualTitle.contains(expectedTitle));
    }
    @Test
    public void logoTest(){
        //logoTest => BestBuy logosunun görüntülen digini test edin
        WebElement logoControl = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor ",logoControl.isDisplayed());
    }
    @Test
    public void francaisTest(){
        //Francais LinkTest => Fransizca Linkin görüntülen diğini test edin
        WebElement francais = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Francais gorunmuyor ",francais.isDisplayed());
    }
    @AfterClass
    public static void teardown() {
        driver.close();
    }
}
