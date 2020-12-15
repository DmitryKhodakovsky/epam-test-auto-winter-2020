package com.epam.training.center.qa.at.lesson04.tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

public class ProductSearchYandexMarketTest extends AbstractBaseSeleniumTest {

    @Test
    public void testProductSearch() {
        // 1. Открыть Яндекс маркет
        yandexMarketIndexPage.open();

        // 2. Найти заданный товар
        yandexMarketIndexPage.sendKeysToSearchInputField("iPhone");
        yandexMarketIndexPage.clickToSearchButton();

        // 3. Проверить что текст присутсвует в названии продукта
        List<String> productNames = yandexMarketCatalogItemPage.getProductNames();

        SoftAssertions softAssertions = new SoftAssertions();
        productNames.forEach(productName ->
                softAssertions.assertThat(productName)
                        .as("Проверка что поисковый текст присутствует в заголовке продукта")
                        .contains("iPhone"));
        softAssertions.assertAll();
    }
}
