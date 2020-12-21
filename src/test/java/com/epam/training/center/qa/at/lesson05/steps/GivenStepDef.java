package com.epam.training.center.qa.at.lesson05.steps;

import io.cucumber.java.en.Given;

public class GivenStepDef extends AbstractBaseStepDef {

    @Given("I am on Yandex Market page")
    public void iAmOnYandexMarketPage() {
        yandexMarketIndexPage.open();
    }
}
