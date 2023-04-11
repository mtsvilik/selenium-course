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

public class CheckBoxAndRadioButtonExample {

    WebDriver driver;

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
        driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
        WebElement radioButton = driver.findElement(By.id("doi0"));
        Actions actions = new Actions(driver);
        actions.moveToElement(radioButton).perform();
        Thread.sleep(2000);
        radioButton.click();

        driver.navigate().to("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("mobile");
        driver.findElement(By.id("gh-btn")).click();
        WebElement checkBox = driver.findElement(By.id("s0-51-12_incl_desc"));
        checkBox.click();
        System.out.println(checkBox.isSelected());
        Thread.sleep(2000);
        checkBox.click();

        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
