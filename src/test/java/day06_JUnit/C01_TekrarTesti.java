package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_TekrarTesti {

    //1-C01_TekrarTesti isimli bir class olusturun
    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6-Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8-Sayfayi kapatin

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");
        //3- cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println(actualTitle.contains(expectedTitle) ? "Google Title test PASS" : "Google Title test FAIL");
        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement searchBox =  driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        //6-Bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Result => " + result.getText());
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String resultString= result.getText();
        String resultSentences[] = resultString.split(" ");
        String resultNumber = resultSentences[1].replace(".","");
        System.out.println(Integer.valueOf(resultNumber) > 10000000 ? "Nutella arama testi PASS" : "Nutella arama testi FAIL");
        //8-Sayfayi kapatin
        driver.close();
    }
}
