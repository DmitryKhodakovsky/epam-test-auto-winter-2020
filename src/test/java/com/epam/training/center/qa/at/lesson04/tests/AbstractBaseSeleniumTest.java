package com.epam.training.center.qa.at.lesson04.tests;

import com.epam.training.center.qa.at.lesson04.steps.ActionStep;
import com.epam.training.center.qa.at.lesson04.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractBaseSeleniumTest {

    private WebDriver driver;

    ActionStep actionStep;
    AssertionStep assertionStep;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        driver.manage().window().maximize();

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        testContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
