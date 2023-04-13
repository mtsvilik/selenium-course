package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyBoardEventTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://extendsclass.com/text-compare.html");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() throws InterruptedException {
        WebElement sourceTextArea = driver.findElement(By.xpath("//*[@id='dropZone']/div[2]//div[5]/pre/span"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.keyDown(sourceTextArea, Keys.COMMAND).sendKeys("a").sendKeys("c").build().perform();

        WebElement destinationArea = driver.findElement(By.xpath("//*[@id='dropZone2']//div[4]/pre/span"));
        action.keyDown(destinationArea, Keys.COMMAND).sendKeys("a").sendKeys("v").build().perform();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
