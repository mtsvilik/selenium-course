package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CapturingScreenshotTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() throws IOException {
        Date currentDate = new Date();
        System.out.println(currentDate);
        String screenshotFileName =
                currentDate.toString().replace(" ", "-").replace(":", "-");
        System.out.println(screenshotFileName);

        File screenchotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenchotFile, new File("screenshot/screenshot.png"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
