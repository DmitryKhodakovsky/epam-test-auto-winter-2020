package com.epam.training.center.qa.at.lesson01;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @Test
    public void simpleSumTest() {
        double actual = calculator.sum(2.0, 2.0);
        assertEquals(actual, 4.0, 0.000001);
    }

    @DataProvider
    public Object[][] sumDataSet() {
        return new Object[][] {
                {2, 2, 4.0},
                {3.5, 4.4, 7.9},
                {-6, -0.9, 6.9},
                {-6, -0.9, "6.9"}
        };
    }

    @Test(dataProvider = "sumDataSet")
    public void dataProviderSumTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(dataProvider = "sumDataSet")
    public void dataProviderSum1Test(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
