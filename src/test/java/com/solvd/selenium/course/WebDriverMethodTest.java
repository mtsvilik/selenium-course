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

import java.util.List;
import java.util.Set;

public class WebDriverMethodTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);


    }

    @Test
    public void verifyLogInTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> webElements = driver
                .findElements(By.xpath("//div[@class='inventory_list']/div"));
        System.out.println(webElements);

        driver.navigate().to("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("mobile");
        driver.findElement(By.id("gh-btn")).click();
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);

        driver.findElement(By.xpath("//*[@id='srp-river-results']/ul/li[2]/div/div[2]/a/div/span")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
    }

    @AfterMethod
    public void tearDown() {
        driver.navigate().to("https://google.com/");
        driver.close();
    }
}
