package com.agilefusion.selenium.tests.TestAndDebugTests;

import com.agilefusion.selenium.DriverFactory;
import com.agilefusion.selenium.page_objects.FinancialPage;
import com.agilefusion.selenium.page_objects.LandingPage;
import com.agilefusion.selenium.page_objects.PersonalPage;
import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Objects;

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
        getDriver().manage().window().maximize();
        personalPage.fillPersonalInfo();
        personalPage.clickNextButton();
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        FinancialPage financialPage = new FinancialPage();
        financialPage.openSourceOfIncomeMenu();
        getDriver().findElement
                (By.cssSelector("md-select-menu md-option[value='retired']")).click();
        getDriver().findElement(By.cssSelector("#primaryGrossMonthlyIncome")).sendKeys("6555");
        Thread.sleep(10000);




    }
}
       // Dimension options = getDriver().findElement(By.cssSelector("md-content")).getSize();
        //System.out.print(options);
       /* WebElement backButton = getDriver().findElement(By.cssSelector("[data-test='desktop-button-back']"));
        String currentPage = backButton.getText();
        if (Objects.equals(currentPage, "BACK TO PRODUCT")) {
            System.out.println("I am on Personal Page. Going back to Product Page");
        }
        backButton.click();  */
        //presonal page text "(0, 0)2. PERSONAL"


