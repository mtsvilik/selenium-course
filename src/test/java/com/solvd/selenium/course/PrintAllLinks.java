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

public class PrintAllLinks {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.sugarcrm.com/uk/request-demo/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() throws InterruptedException {
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        List<WebElement> allTags = driver.findElements(By.tagName("a"));
        System.out.println("Total tags are: " + allTags.size());

        for (int i = 0; i < allTags.size(); i++) {
            System.out.println("Links on page are " + allTags.get(i).getAttribute("href"));
            System.out.println("Links on page are " + allTags.get(i).getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}