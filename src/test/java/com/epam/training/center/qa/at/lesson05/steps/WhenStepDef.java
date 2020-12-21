package com.epam.training.center.qa.at.lesson05.steps;

import com.epam.training.center.qa.at.lesson05.context.TextContext;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WhenStepDef extends AbstractBaseStepDef {

    @When("I search {string} in Search bar on Yandex Market page")
    public void iSearchInSearchBarOnTheYandexMarketPage(String searchText) {
        yandexMarketIndexPage.sendKeysToSearchInputField(searchText);
        yandexMarketIndexPage.clickToSearchButton();
    }

    @When("I open {string} subcategory in {string} category in Top level menu on the Yandex Market page")
    public void iOpenSubCategoryInCategoryInTopLevelMenuOnYandexMarketPage(String subCategory, String category) {
        yandexMarketIndexPage.selectCategory(category);
        yandexMarketCategoryPage.selectCatalogItemPage(subCategory);
    }

    @When("I add {word} products to compare list on Yandex Market Catalog page")
    public void addProductToCompareList(String productIndexesString) {
        List<Integer> productIndexes = Arrays
                .stream(productIndexesString.split(","))
                .map(Integer::new)
                .collect(Collectors.toList());
        List<String> products = new ArrayList<>();

        for (int productIndex : productIndexes) {
            products.add(yandexMarketCatalogItemPage.addProductToCompare(productIndex));
        }

        TextContext.getInstance().setTestObject("compare-list", products);

        yandexMarketCatalogItemPage.clickCompareButton();
    }
}
