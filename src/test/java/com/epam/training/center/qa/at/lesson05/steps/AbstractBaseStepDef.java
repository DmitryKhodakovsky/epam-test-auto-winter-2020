package com.epam.training.center.qa.at.lesson05.steps;

import com.epam.training.center.qa.at.lesson05.services.driver.WebDriverSingleton;
import com.epam.training.center.qa.at.lesson05.services.page.YandexMarketCatalogItemPage;
import com.epam.training.center.qa.at.lesson05.services.page.YandexMarketCategoryPage;
import com.epam.training.center.qa.at.lesson05.services.page.YandexMarketCompareProductPage;
import com.epam.training.center.qa.at.lesson05.services.page.YandexMarketIndexPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseStepDef {

    YandexMarketIndexPage yandexMarketIndexPage;
    YandexMarketCategoryPage yandexMarketCategoryPage;
    YandexMarketCatalogItemPage yandexMarketCatalogItemPage;
    YandexMarketCompareProductPage yandexMarketCompareProductPage;

    protected AbstractBaseStepDef() {
        WebDriver driver = WebDriverSingleton.getDriver();
        yandexMarketIndexPage = new YandexMarketIndexPage(driver);
        yandexMarketCategoryPage = new YandexMarketCategoryPage(driver);
        yandexMarketCatalogItemPage = new YandexMarketCatalogItemPage(driver);
        yandexMarketCompareProductPage = new YandexMarketCompareProductPage(driver);
    }
}
