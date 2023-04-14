package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class AuthenticationTest {

    private static String userName = "admin";
    private static String password = "admin";

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//        driver.manage().window().maximize();

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://" + userName + ":" + password + "@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() throws IOException {
        // https://the-internet.herokuapp.com/basic_auth
        // https://admin:admin@the-internet.herokuapp.com/basic_auth
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
