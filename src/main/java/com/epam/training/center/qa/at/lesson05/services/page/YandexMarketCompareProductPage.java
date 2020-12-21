package com.epam.training.center.qa.at.lesson05.services.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class YandexMarketCompareProductPage extends AbstractBasePage {

    @FindBy(css = "[data-tid='412661c'] a.cia-cs")
    private List<WebElement> comparedProducts;

    public YandexMarketCompareProductPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        return comparedProducts
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
