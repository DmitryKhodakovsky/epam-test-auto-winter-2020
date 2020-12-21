package com.epam.training.center.qa.at.lesson05.steps;

import com.epam.training.center.qa.at.lesson05.context.TextContext;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenStepDef extends AbstractBaseStepDef {

    @Then("product titles should contain {string} on Yandex Market Catalog page")
//    @Then("^product titles should contain '([^\"]*)' on Yandex Market Catalog page$")
    public void productTitlesShouldContainOnYandexMarketCatalogPage(String expectedText) {
        List<String> productNames = yandexMarketCatalogItemPage.getProductNames();

        SoftAssertions softAssertions = new SoftAssertions();
        productNames.forEach(productName ->
                softAssertions.assertThat(productName)
                        .as("Проверка что поисковый текст присутствует в заголовке продукта")
                        .contains(expectedText));
        softAssertions.assertAll();
    }

    @Then("added products should be displayed on Yandex Market Compare page")
    public void selectedProductsShouldBeAddedToTheCompareList() {
        List<String> expectedProducts = TextContext.getInstance().getTestObject("compare-list");
        List<String> actualProducts = yandexMarketCompareProductPage.getProductNames();

        assertThat(actualProducts)
                .as("Проверка что выбранные товары добавлены в список сравнения")
                .containsExactlyInAnyOrderElementsOf(expectedProducts);
    }

}
