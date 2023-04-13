package com.solvd.selenium.course;

import com.solvd.selenium.course.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTestTest {

    private WebDriver driver;
    private final String browser = PropertyReader.getProperties("browser");

    @BeforeMethod
    public void setUp() {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/solvd/Selenium/chromedriver111");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", "/Users/solvd/Selenium/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
