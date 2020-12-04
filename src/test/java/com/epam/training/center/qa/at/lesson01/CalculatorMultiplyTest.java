package com.epam.training.center.qa.at.lesson01;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest extends AbstractCalculatorTest {

    @Test
    public void simpleMultiplyTest() {
        double actual = calculator.multiply(2.0, 2.0);
        assertEquals(actual, 4.0, 0.000001);
    }
}
