package com.epam.training.center.qa.at.lesson04.steps;

import com.epam.training.center.qa.at.lesson04.service.page.YandexMarketCatalogItemPage;
import com.epam.training.center.qa.at.lesson04.service.page.YandexMarketCategoryPage;
import com.epam.training.center.qa.at.lesson04.service.page.YandexMarketCompareProductPage;
import com.epam.training.center.qa.at.lesson04.service.page.YandexMarketIndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    YandexMarketIndexPage yandexMarketIndexPage;
    YandexMarketCategoryPage yandexMarketCategoryPage;
    YandexMarketCatalogItemPage yandexMarketCatalogItemPage;
    YandexMarketCompareProductPage yandexMarketCompareProductPage;

    protected AbstractStep(WebDriver driver) {
        yandexMarketIndexPage = new YandexMarketIndexPage(driver);
        yandexMarketCategoryPage = new YandexMarketCategoryPage(driver);
        yandexMarketCatalogItemPage = new YandexMarketCatalogItemPage(driver);
        yandexMarketCompareProductPage = new YandexMarketCompareProductPage(driver);
    }

    @Step("Открыть домашнюю страницу Яндекс Маркета")
    public void openYandexMarketIndexPage() {
        yandexMarketIndexPage.open();
    }
}
