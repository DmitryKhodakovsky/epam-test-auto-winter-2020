package com.epam.training.center.qa.at.lesson_jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.training.center.qa.at.lesson_jdi.pages.JdiHomePage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    public static JdiHomePage homePage;

    public static void open() {
        homePage.open();
    }
}
