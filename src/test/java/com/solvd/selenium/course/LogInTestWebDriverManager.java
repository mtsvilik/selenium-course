package com.solvd.selenium.course;

import com.solvd.selenium.course.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTestWebDriverManager {

    private WebDriver driver;
    private final String browser = PropertyReader.getProperties("browser");

    @BeforeMethod
    public void setUp() {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Check the browser");
        }
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() {
        WebElement password = driver.findElement(By.id("password"));
        driver.findElement(RelativeLocator.with(By.tagName("input")).above(password))
                .sendKeys("standard_user");
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
