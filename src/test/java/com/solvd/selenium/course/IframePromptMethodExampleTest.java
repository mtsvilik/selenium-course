package com.solvd.selenium.course;

import com.solvd.selenium.course.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframePromptMethodExampleTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() throws InterruptedException {
        WebElement iFrame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("/html/body/button")).click();
        Alert alertOnPage = driver.switchTo().alert();
        alertOnPage.sendKeys(PropertyReader.getProperties("name"));
        Thread.sleep(2000);
        alertOnPage.accept();
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
