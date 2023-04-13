package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.singaporeair.com/en_UK/pl/home#/book/bookflight");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() throws InterruptedException {
        WebElement radioButton1 = driver.findElement(By.id("bookFlights"));
        WebElement radioButton2 = driver.findElement(By.id("redeemFlights"));
        radioButton2.click();
        Thread.sleep(2000);
        System.out.println(radioButton1.isSelected());
        System.out.println(radioButton2.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
