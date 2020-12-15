package com.epam.training.center.qa.at.lesson3.test.java.googletest;

import com.epam.training.center.qa.at.lesson3.main.java.pages.SearchPage;
import com.google.inject.Inject;
import org.junit.Test;


public class googleSearchTest extends BaseTest {

    @Inject
    SearchPage searchPage;// = new SearchPage(webDriver);

    @Test
    public void testGoogleSearch() {
        webDriver.get("https://www.google.com/");

        searchPage.searchText("yandex.ru");
        searchPage.verifyFirstSuggestion("yandex.ru");
    }

}
