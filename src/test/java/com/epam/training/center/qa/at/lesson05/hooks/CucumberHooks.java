package com.epam.training.center.qa.at.lesson05.hooks;

import com.epam.training.center.qa.at.lesson05.services.driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
