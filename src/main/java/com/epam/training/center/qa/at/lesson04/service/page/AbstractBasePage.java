package com.epam.training.center.qa.at.lesson04.service.page;

import com.epam.training.center.qa.at.lesson04.service.page.component.AbstractComponent;
import com.epam.training.center.qa.at.lesson04.service.page.component.HeaderComponent;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBasePage extends AbstractComponent {

    private static final String BASE_URL = "https://market.yandex.ru";

    protected HeaderComponent header;

    protected AbstractBasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public void selectCategory(String categoryName) {
        header.selectCategory(categoryName);
    }

    public void sendKeysToSearchInputField(String searchText) {
        header.sendKeysToSearchInputField(searchText);
    }

    public void clickToSearchButton() {
        header.clickToSearchButton();
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }
}
