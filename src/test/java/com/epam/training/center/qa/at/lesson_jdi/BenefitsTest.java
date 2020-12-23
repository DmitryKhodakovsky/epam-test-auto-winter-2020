package com.epam.training.center.qa.at.lesson_jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class BenefitsTest {

    public static final int EXPECTED_BENEFITS_COUNT = 3;

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void jdiBenefitsCountTest() {
        /*
        1. Open JDI site home page
        2. Check that EPAM has 4 benefits
         */
        JdiSite.open();
        JdiSite.homePage.benefits.is().size(EXPECTED_BENEFITS_COUNT);

//        int actualBenefitCount = JdiSite.homePage.getBenefitsCount();
//        assertEquals(actualBenefitCount, EXPECTED_BENEFITS_COUNT,
//                format("EPAM should have %s benefits but get %s", EXPECTED_BENEFITS_COUNT, actualBenefitCount));
    }
}
