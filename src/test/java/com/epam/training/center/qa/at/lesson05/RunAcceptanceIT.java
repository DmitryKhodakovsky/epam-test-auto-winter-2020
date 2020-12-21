package com.epam.training.center.qa.at.lesson05;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:lesson05"},
        plugin = {
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
})
public class RunAcceptanceIT extends AbstractTestNGCucumberTests {
}
