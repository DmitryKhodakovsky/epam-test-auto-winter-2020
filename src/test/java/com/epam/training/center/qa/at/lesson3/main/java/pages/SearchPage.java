package com.epam.training.center.qa.at.lesson3.main.java.pages;


import com.epam.training.center.qa.at.lesson3.main.java.driverutils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchPage {

    WaitActions waitActions;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;
    @FindBy(xpath = "//li[@class='sbct']")
    private List<WebElement> suggestionList;

    @Inject
    public SearchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

//    public void openGooglePage() {
//        webDriver.get("https://www.google.com/");
//    }

    public void searchText(String textToSearch) {
        searchInput.sendKeys(textToSearch);
    }

    public void verifyFirstSuggestion(String correctText) {
        waitForSuggestionsToAppear();
        assertEquals(correctText, suggestionList.get(0).getText());
    }

    private void waitForSuggestionsToAppear() {
        waitActions.waitUntilCondition(ex -> suggestionList.size() != 1);
    }

}
