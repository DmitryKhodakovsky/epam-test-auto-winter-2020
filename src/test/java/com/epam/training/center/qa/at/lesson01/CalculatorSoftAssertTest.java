package com.epam.training.center.qa.at.lesson01;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CalculatorSoftAssertTest extends AbstractCalculatorTest {

    @Test
    public void softAssertTest() {
        SoftAssert softAssert = new SoftAssert();
        double res1 = calculator.sum(2, 3);
        softAssert.assertEquals(res1, 5.0, 0.0001);
        double res2 = calculator.multiply(res1, 5);
        softAssert.assertEquals(res2, 20.0, 0.0001);
        double res3 = calculator.sum(res2, 10);
        softAssert.assertEquals(res3, 30.0, 0.0001);
        softAssert.assertAll();
    }
}
