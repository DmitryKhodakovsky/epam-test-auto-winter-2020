package com.epam.training.center.qa.at.lesson04.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test checks that all selected products was added to compare list correctly
 */
public class AddProductToCompareYandexMarketTest extends AbstractBaseSeleniumTest {

    @DataProvider
    public Object[][] categoriesSubCategoriesDataSet() {
        return new Object[][]{
                {"Компьютеры", "Ноутбуки"},
                {"Бытовая техника", "Холодильники"},
                {"Электроника", "Смартфоны"}
        };
    }

    @Test(dataProvider = "categoriesSubCategoriesDataSet")
    public void addProductToCompareTest(String categoryName, String subCategoryName) {
        // 1. Открыть Яндекс маркет
        yandexMarketIndexPage.open();

        // 2. Выбрать категорию "Компьютеры"
        yandexMarketIndexPage.selectCategory(categoryName);

        // 3. Выбрать подкатегорию "Ноутбуки"
        yandexMarketCategoryPage.selectCatalogItemPage(subCategoryName);

        List<String> selectedProductNames = new ArrayList<>();
        // 4. Добавить первый товар к сравнению
        String firstProduct = yandexMarketCatalogItemPage.addProductToCompare(1);
        selectedProductNames.add(firstProduct);

        // 5. добавить второй товар к сравнению
        String secondProduct = yandexMarketCatalogItemPage.addProductToCompare(2);
        selectedProductNames.add(secondProduct);

        // 6. Нажать на кнопку сравнить товары
        yandexMarketCatalogItemPage.clickCompareButton();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        List<String> comparedProductNames = yandexMarketCompareProductPage.getProductNames();

        assertThat(comparedProductNames)
                .as("Проверка что выбранные товары добавлены в список сравнения")
                .containsExactlyInAnyOrderElementsOf(selectedProductNames);
    }

}
