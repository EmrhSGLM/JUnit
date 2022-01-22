package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestbuyAssertion{
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){
        //2)    //https://www.bestbuy.com/ A dresine gidin farkli test
        // method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");
        //Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.bestbuy.com/";
        Assert.assertEquals("Lutfen test degerlerini gozden gecir",expectedURL, actualURL);
        //titleTest => Sayfa başlığının “ Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Rest";
        Assert.assertFalse("Icermiyor",actualTitle.contains(expectedTitle));
        //logoTest => BestBuy logosunun görüntülen digini test edin
        WebElement logoControl = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor ",logoControl.isDisplayed());
        //Francais LinkTest => Fransizca Linkin görüntülen diğini test edin
        WebElement francais = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Francais gorunmuyor ",francais.isDisplayed());
    }
    @After
    public void teardown() {
       driver.close();
    }
}
