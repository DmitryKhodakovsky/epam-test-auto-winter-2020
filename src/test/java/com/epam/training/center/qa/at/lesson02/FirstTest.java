package com.epam.training.center.qa.at.lesson02;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {

    private WebDriverWait webDriverWait;
    WebDriver webDriver;

    private WebElement webElement;

    @Test
    public void simpleTest() {
        System.setProperty("webdriver.chrome.driver", "c://driver//chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.epam.com");
        List<WebElement> list = webDriver.findElements(By.xpath("//header"));
        assertEquals(webDriver.getTitle(),"EPAM | Enterprise Software Development, Design & Consulting");
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
//        webDriverWait.until(ex -> webElement.isDisplayed());
//        webDriver.switchTo().frame("frame-id");
//        webDriver.switchTo().defaultContent();
//        webDriver.switchTo().parentFrame();
    }

    @After
    public void clear() {
        webDriver.close();
    }

}
