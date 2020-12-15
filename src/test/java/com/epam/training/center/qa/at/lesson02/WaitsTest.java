package com.epam.training.center.qa.at.lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitsTest {

    WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru");
    }

    @Test
    public void correctLocatorWithImplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        long start = System.currentTimeMillis();
        try {
            WebElement searchField = driver.findElement(By.id("header-search"));
            searchField.sendKeys("jshdjsdjkvh");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("correctLocatorWithImplicitWaitTest Execution time: %s", (end - start)));
        }

    }

    @Test
    public void incorrectLocatorWithImplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        long start = System.currentTimeMillis();
        try {
            WebElement searchField = driver.findElement(By.id("header-search12"));
            searchField.sendKeys("jshdjsdjkvh");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("incorrectLocatorWithImplicitWaitTest Execution time: %s", (end - start)));
        }

    }

    @Test
    public void correctLocatorWithExplicitWaitTest() {
//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);

        long start = System.currentTimeMillis();
        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search")));
            searchField.sendKeys("jshdjsdjkvh");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("correctLocatorWithExplicitWaitTest Execution time: %s", (end - start)));
        }
    }

    @Test
    public void incorrectLocatorWithExplicitWaitTest() {
//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);

        long start = System.currentTimeMillis();
        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search12")));
            searchField.sendKeys("jshdjsdjkvh");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("incorrectLocatorWithExplicitWaitTest Execution time: %s", (end - start)));
        }
    }

    @Test
    public void incorrectLocatorWithImplicitAndExplicitWaitExplicitMoreThanImplicitTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 22);

        long start = System.currentTimeMillis();
        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search12")));
            searchField.sendKeys("jshdjsdjkvh");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("incorrectLocatorWithImplicitAndExplicitWaitExplicitMoreThanImplicitTest Execution time: %s", (end - start)));
        }
    }

    @Test
    public void incorrectLocatorWithImplicitAndExplicitWaitExplicitLessThanImplicitTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        long start = System.currentTimeMillis();
        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search12")));
            searchField.sendKeys("jshdjsdjkvh");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("incorrectLocatorWithImplicitAndExplicitWaitExplicitLessThanImplicitTest Execution time: %s", (end - start)));
        }
    }

    @Test
    public void correctLocatorWithImplicitAndExplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        // 1
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        long start = System.currentTimeMillis();
        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search12")));
            searchField.sendKeys("jshdjsdjkvh");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("correctLocatorWithImplicitAndExplicitWaitTest1 Execution time: %s", (end - start)));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        }

        // 2
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 15);
        start = System.currentTimeMillis();
        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search12")));
            searchField.sendKeys("jshdjsdjkvh");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("correctLocatorWithImplicitAndExplicitWaitTest1 Execution time: %s", (end - start)));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private void sleep(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
