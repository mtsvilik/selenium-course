package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class HandingWindowsTest {

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
    public void verifyLogInTest() throws InterruptedException {
        driver.findElement(By.id("gh-ac")).sendKeys("mobile");
        driver.findElement(By.id("gh-btn")).click();
        driver.findElement(By.xpath("//*[@id='srp-river-results']/ul/li[2]/div/div[1]/div/a/div")).click();
        Thread.sleep(2000);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        System.out.println(parentWindow);
        String childWindow = iterator.next();
        System.out.println(childWindow);
        driver.switchTo().window(childWindow);
        driver.findElement(By.xpath("//*[@id='mainContent']/form/div[2]/div/div[1]/div[2]/ul/li[2]/div/a/span/span"));
        driver.switchTo().window(parentWindow);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
