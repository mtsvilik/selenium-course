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

public class WebTablesWithIFrameTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://wpdatatables.com/examples-of-data-tables/");
    }

    @Test
    public void verifyLogInTest() {
        //Step 1 - switch to frame which has that particular table
        //Step 2 - get the number of rows
        //Step 3 - get the number of columns
        //Step 4 - iterate rows and columns, get text and print it

        WebElement iFrame = driver.findElement(By.xpath("//*[@id='post-41571']/div/div[2]/p[33]/iframe"));
        driver.switchTo().frame(iFrame);

        List<WebElement> rowElements = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
        System.out.println(rowElements.size());

        List<WebElement> columnElements = driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td"));
        System.out.println(columnElements.size());

        for (int i = 1; i <= rowElements.size(); i++) {
            for (int j = 1; j <= columnElements.size(); j++) {
                System.out.println(driver.findElement(By.xpath(
                        "/html/body//table/tbody/tr[" + i + "]/td[" + j + "]")).getText());
            }
        }
        System.out.println();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
