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
@Feature("Strip Bar feature")
public class homepage {
    private WebDriver driver;

    @BeforeEach
    public void setup (){
        System.setProperty("webdriver.chrome.driver", "C:/Users/LENOVO/Documents/chrome/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.driver.get("https://pertamina.com/");
    }
    public void Search (String textinput) throws InterruptedException {
        WebElement iconsearch = driver.findElement(By.cssSelector(".fas.fa-search"));
        WebElement inputsearch = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        WebElement btnsearch = driver.findElement(By.cssSelector("#basic-addon2"));

        iconsearch.click();
        inputsearch.sendKeys(textinput);
        btnsearch.click();
    }

    public void stripbar() {
        WebElement stripbar = driver.findElement(By.cssSelector(".fas.fa-bars"));
        stripbar.click();
    }
    public void tentangkami() {
        WebElement tentangKami = driver.findElement(By.linkText("Tentang Kami"));
        tentangKami.click();

    }public void bisniskami() {
        WebElement bisniskami = driver.findElement(By.linkText("Bisnis Kami"));
        bisniskami.click();

    }public void hubunganivestor() {
        WebElement hubunganinvestor = driver.findElement(By.linkText("Hubungan Investor"));
        hubunganinvestor.click();

    }public void mediadaninformasi() {
        WebElement mediadaninformasi = driver.findElement(By.linkText("Media & Informasi"));
        mediadaninformasi.click();

    }public void keberlanjutan() {
        WebElement keberlanjutan = driver.findElement(By.linkText("Keberlanjutan"));
        keberlanjutan.click();

    }public void pengadaan() {
        WebElement pengadaan = driver.findElement(By.linkText("Pengadaan"));
        pengadaan.click();

    }public void karir() {
        WebElement karir = driver.findElement(By.linkText("Karir"));
        karir.click();

    }
    public void hubungikami() {
        WebElement hubungikami = driver.findElement(By.linkText("Hubungi Kami"));
        hubungikami.click();

    }

    @Test
    public void fieldSearch() throws InterruptedException {
        Search("Pertamina Gas");
        driver.quit();
    }
    @Test
    public void TentangKami (){
        stripbar();
        tentangkami();
        driver.quit();
    }
    @Test
    public void BisnisKami (){
        stripbar();
        bisniskami();
        driver.quit();
    }
    @Test
    public void HubunganInvestor (){
        stripbar();
        hubunganivestor();
        driver.quit();
    }
    @Test
    public void MediadanInformasi (){
        stripbar();
        mediadaninformasi();
        driver.quit();
    }
    @Test
    public void Pengadaan (){
        stripbar();
        pengadaan();
        driver.quit();
    }
    @Test
    public void Keberlanjuta (){
        stripbar();
        keberlanjutan();
        driver.quit();
    }
    @Test
    public void Karir (){
        stripbar();
        karir();
        driver.quit();
    }
    @Test
    public void HubungiKami (){
        stripbar();
        hubungikami();
        driver.quit();
    }
}
