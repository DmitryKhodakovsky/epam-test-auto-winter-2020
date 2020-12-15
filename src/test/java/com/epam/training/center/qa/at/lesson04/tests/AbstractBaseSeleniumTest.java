package com.epam.training.center.qa.at.lesson04.tests;

import com.epam.training.center.qa.at.lesson04.service.page.YandexMarketCatalogItemPage;
import com.epam.training.center.qa.at.lesson04.service.page.YandexMarketCategoryPage;
import com.epam.training.center.qa.at.lesson04.service.page.YandexMarketCompareProductPage;
import com.epam.training.center.qa.at.lesson04.service.page.YandexMarketIndexPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseSeleniumTest {

    private WebDriver driver;

    YandexMarketIndexPage yandexMarketIndexPage;
    YandexMarketCategoryPage yandexMarketCategoryPage;
    YandexMarketCatalogItemPage yandexMarketCatalogItemPage;
    YandexMarketCompareProductPage yandexMarketCompareProductPage;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        driver.manage().window().maximize();


        yandexMarketIndexPage = new YandexMarketIndexPage(driver);
        yandexMarketCategoryPage = new YandexMarketCategoryPage(driver);
        yandexMarketCatalogItemPage = new YandexMarketCatalogItemPage(driver);
        yandexMarketCompareProductPage = new YandexMarketCompareProductPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
