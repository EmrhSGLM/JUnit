package day06_JUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu {

    WebDriver driver;

    @Test
    public void test01() {
        // https://www.amazon.com 'a gidelim ve Title'in "amazon" icerdigini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle =  driver.getTitle();
        String expectedTitle = "amazon";

        System.out.println(actualTitle.contains(expectedTitle) ? "Title test PASSED" : "Title test FAILED");
    }

    @Test
    public void test02() {
        // https://www.google.com ' a gidelim ve Title'nin "google" icerdigini test edelim
        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "google";

        System.out.println(actualTitle.contains(expectedTitle) ? "Title test PASSED" : "Title test FAILED");

    }

    @Before
    public void ayarlariDuzenle() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void ortalıgıTopla() {
        driver.close();
    }
}
