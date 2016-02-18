package com.agilefusion.selenium.tests.TestAndDebugTests;

import com.agilefusion.selenium.DriverFactory;
import com.agilefusion.selenium.page_objects.LandingPage;
import com.agilefusion.selenium.page_objects.PersonalPage;
import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by dmitrykovpak on 16/02/16.
 */
public class ClassToDebugAndTestInFF extends DriverFactory {
    @Test
    public void testInFF() throws Exception {
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        LandingPage landingPage = new LandingPage();
        landingPage.clickNextbutton();
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        PersonalPage personalPage = new PersonalPage();
        personalPage.clickPrimaryStateDropDownMenu();
        Dimension options = getDriver().findElement(By.cssSelector("md-content")).getSize();
        System.out.print(options);
    }
}
