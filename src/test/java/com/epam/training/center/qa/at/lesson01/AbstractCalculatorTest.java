package com.epam.training.center.qa.at.lesson01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class AbstractCalculatorTest {

    protected Calculator calculator;

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test annotation");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("before method annotation");
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("after method annotation");
        calculator = null;
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test annotation");
    }
}
