package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Print the title of the page
        String script = "return document.title;";
        String title = (String) js.executeScript(script);
        System.out.println(title);

        //Click the button
        driver.switchTo().frame("iframeResult");
        js.executeScript("myFunction()");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //Highlight the button
        WebElement tryButton = driver.findElement(By.xpath("/html/body/button"));
        js.executeScript("arguments[0].style.border='5px solid green'", tryButton);

        //Scroll the page
        driver.navigate().to("https://www.w3schools.com/");
        WebElement learnMoreButton = driver.findElement(By.xpath("//*[@id='howto_padding']/a"));
        js.executeScript("arguments[0].scrollIntoView(true);", learnMoreButton);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
