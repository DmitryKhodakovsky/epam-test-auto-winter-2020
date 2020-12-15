package com.epam.training.center.qa.at.lesson04.tests;

import com.epam.training.center.qa.at.lesson04.listeners.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class ProductSearchYandexMarketTest extends AbstractBaseSeleniumTest {

    @Test(description = "Тестирование поиска товара")
    public void testProductSearch() {
        // 1. Открыть Яндекс маркет
        actionStep.openYandexMarketIndexPage();

        // 2. Найти заданный товар
        actionStep.searchProduct("iPhone");

        // 3. Проверить что текст присутствует в названии продукта
        assertionStep.searchTextShouldBeExistInResults("iPhone1");
    }
}
