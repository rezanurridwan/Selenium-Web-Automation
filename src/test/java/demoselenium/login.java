package demoselenium;

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

@Epic("Login")
@Feature("Login Feature")
public class login {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/LENOVO/Documents/chrome/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
        this.driver.get("https://saucedemo.com");
    }

    public void userdata( String username, String password){
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        WebElement buttonlogin = driver.findElement(By.id("login-button"));

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonlogin.click();
    }
    public void setTitlehomepage (String titlehomepage){
        WebElement titlehp = driver.findElement(By.cssSelector("#header_container > div.primary_header > div.header_label > div"));
        Assertions.assertThat(titlehp.getText()).isEqualTo(titlehomepage);
    }
    public void setUsernamenull (String usernamenull){
        WebElement usernull = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assertions.assertThat(usernull.getText()).isEqualTo(usernamenull);
    }
    public void setPasswordnull (String passwordnull){
        WebElement passnull = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assertions.assertThat(passnull.getText()).isEqualTo(passwordnull);

    }
    public void invalidCredential ( String invalcred){
        WebElement incred = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assertions.assertThat(incred.getText()).isEqualTo(invalcred);
    }
    @Test
    public void loginWithValidData() {
        userdata ("standard_user","secret_sauce");
        setTitlehomepage("Swag Labs");

        driver.quit();
    }
    @Test
    public void loginWithDataNull() {
        userdata ("","");
        setUsernamenull("Epic sadface: Username is required");

        driver.quit();
    }
    @Test
    public void loginWithUsernameNull() {
        userdata ("","secret_sauce");
        setUsernamenull("Epic sadface: Username is required");

        driver.quit();
    }
    @Test
    public void loginWithPasswordNull() {
        userdata ("standard_user","");
        setPasswordnull("Epic sadface: Password is required");

        driver.quit();
    }
    @Test
    public void invalidCredential() {
        userdata ("standard_username","secret_labs");
        invalidCredential("Epic sadface: Username and password do not match any user in this service");

        driver.quit();
    }
}
