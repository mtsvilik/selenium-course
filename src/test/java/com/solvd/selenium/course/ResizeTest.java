package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResizeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() throws InterruptedException {
        WebElement frame = driver.findElement(By.xpath("//*[@id='content']/iframe"));
        driver.switchTo().frame(frame);
        WebElement element = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(element, 300,100).perform();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
