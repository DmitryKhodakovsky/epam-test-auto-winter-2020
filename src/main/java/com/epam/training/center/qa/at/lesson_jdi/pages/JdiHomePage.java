package com.epam.training.center.qa.at.lesson_jdi.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class JdiHomePage extends WebPage {
    @FindBy(css = ".benefit")
    public WebList benefits;

    public int getBenefitsCount() {
        return benefits.size();
    }
}
