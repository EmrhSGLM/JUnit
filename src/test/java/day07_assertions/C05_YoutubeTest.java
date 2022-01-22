package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTest {

    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
    }
    @Test
    public void titleTest(){
        // titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle ="YouTube";
        Assert.assertEquals("Title is not YouTube",actualTitle, expectedTitle);
    }
    @Test
    public void imageTest(){
        //imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.xpath("(//a[@id='logo'])[1]"));
        Assert.assertTrue("It isn't  seeing Image",image.isDisplayed());
    }
    @Test
    public void searchBoxTest(){
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("Search box is not accessible",searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle=driver.getTitle();
        String expectedTitle= "youtube";
        Assert.assertFalse("Title of page is youtube ",actualTitle.equals(expectedTitle));
    }
    @AfterClass
    public static void teardown() {
       driver.close();
    }
}
