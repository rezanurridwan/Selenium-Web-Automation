package Pertamina;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import java.time.Duration;

@Epic("homepage")
@Feature("Registrasi Dana Penyarlur feature")
public class registrasidanapenyalur {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/LENOVO/Documents/chrome/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.driver.get("https://kemitraan.pertamina.com/");
    }

    public void kemitraan (String judulkemitraan){
        WebElement berandakemitraan = driver.findElement(By.linkText("Beranda"));
        WebElement judulmitra = driver.findElement(By.cssSelector("div[class='mitra-banner desktop'] h2"));

        berandakemitraan.click();
        Assertions.assertThat(judulmitra.equals(judulkemitraan));
    }

    @Test
    public void Beranda(){
        kemitraan("JENIS KEMITRAAN");
    }

}