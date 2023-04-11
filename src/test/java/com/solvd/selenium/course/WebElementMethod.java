package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementMethod {

    private WebDriver driver;

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
    public void verifyLogInTest() {
        driver.findElement(By.id("gh-ac")).sendKeys("mobile");
        driver.findElement(By.id("gh-ac")).clear();
        System.out.println(driver.findElement(By.id("gh-ac")).getAttribute("class"));
        System.out.println(driver.findElement(By.id("gh-btn")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.id("gh-btn")).getSize());
        System.out.println(driver.findElement(By.id("gh-btn")).getLocation());
        System.out.println(driver.findElement(By.id("gh-btn")).getText());
        System.out.println(driver.findElement(By.id("gh-btn")).getTagName());
        System.out.println(driver.findElement(By.id("gh-btn")).isDisplayed());
        System.out.println(driver.findElement(By.id("gh-btn")).isEnabled());
        System.out.println(driver.findElement(By.id("gh-btn")).isSelected());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
