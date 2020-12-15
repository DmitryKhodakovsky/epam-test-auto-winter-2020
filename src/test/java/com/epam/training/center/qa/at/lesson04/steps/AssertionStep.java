package com.epam.training.center.qa.at.lesson04.steps;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка,что выбранные товары были добавлены к сравнению")
    public void selectedProductsShouldBeAddedToTheCompareList(List<String> expectedProducts) {
        List<String> actualProducts = yandexMarketCompareProductPage.getProductNames();

        assertThat(actualProducts)
                .as("Проверка что выбранные товары добавлены в список сравнения")
                .containsExactlyInAnyOrderElementsOf(expectedProducts);
    }

    @Step("Проверка что текст поиска присутствует в названии товара")
    public void searchTextShouldBeExistInResults(String expectedText) {
        List<String> productNames = yandexMarketCatalogItemPage.getProductNames();

        SoftAssertions softAssertions = new SoftAssertions();
        productNames.forEach(productName ->
                softAssertions.assertThat(productName)
                        .as("Проверка что поисковый текст присутствует в заголовке продукта")
                        .contains(expectedText));
        softAssertions.assertAll();
    }
}
