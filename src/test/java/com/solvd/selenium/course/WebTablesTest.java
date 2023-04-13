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

public class WebTablesTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://finance.yahoo.com/currency-converter/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogInTest() {
        //Step 1 - switch to frame which has that particular table
        //Step 2 - get the number of rows
        //Step 3 - get the number of columns
        //Step 4 - iterate rows and columns, get text and print it

        List<WebElement> rowElements = driver.findElements(By.xpath("//*[@id='data-util-col']/section[3]/table/tbody/tr"));
        System.out.println(rowElements.size());

        List<WebElement> columnElements = driver.findElements(By.xpath("//*[@id='data-util-col']/section[3]/table/tbody/tr[1]/td"));
        System.out.println(columnElements.size());

        for (int i = 1; i <= rowElements.size(); i++) {
            for (int j = 1; j <= columnElements.size(); j++) {
                System.out.println(driver.findElement(By.xpath(
                        "//*[@id='data-util-col']/section[3]/table/tbody/tr[" + i + "]/td[" + j + "]")).getText());
            }
        }
        System.out.println();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
