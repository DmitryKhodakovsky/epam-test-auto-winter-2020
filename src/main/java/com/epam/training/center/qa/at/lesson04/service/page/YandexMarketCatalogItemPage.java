package com.epam.training.center.qa.at.lesson04.service.page;

import com.epam.training.center.qa.at.lesson04.service.page.component.ProductCardComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class YandexMarketCatalogItemPage extends AbstractBasePage {

    @FindBy(css = "[data-autotest-id='product-snippet']")
    private List<WebElement> products;

    @FindBy(xpath = "//a/span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketCatalogItemPage(WebDriver driver) {
        super(driver);
    }

    public String addProductToCompare(int index) {
        return addProductToCompare(new ProductCardComponent(driver, products.get(index - 1)));
    }

    public void clickCompareButton() {
        wait.until(elementToBeClickable(compareButton)).click();
    }

    public List<String> getProductNames() {
        return products
                .stream()
                .map(product -> new ProductCardComponent(driver, product))
                .collect(Collectors.toList())
                .stream()
                .map(ProductCardComponent::getProductName)
                .collect(Collectors.toList());
    }

    private String addProductToCompare(ProductCardComponent productCard) {
        productCard.clickToAddToCompareButton();
        return productCard.getProductName();
    }

}
