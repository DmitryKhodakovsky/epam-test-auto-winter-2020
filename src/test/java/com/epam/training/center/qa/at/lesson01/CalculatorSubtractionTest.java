package com.epam.training.center.qa.at.lesson01;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractionTest extends AbstractCalculatorTest {

    @Test
    public void simpleSubtractionTest() {
        double actual = calculator.subtraction(2.0, 2.0);
        assertEquals(actual, 4.0, 0.000001);
    }

    @Test(dataProvider = "Subtraction Data Provider", dataProviderClass = SubtractionDataProvider.class)
    public void dataProviderSubtractionTest(double a, double b, double expected) {
        double actual = calculator.subtraction(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
