package com.solvd.selenium.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDropdownExample2 {

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
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='how-select']"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByVisibleText("YouTube");
        Thread.sleep(2000);
        select.selectByValue("Event");
        Thread.sleep(2000);

        WebElement firstOption = select.getFirstSelectedOption();
        System.out.println(firstOption.getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
