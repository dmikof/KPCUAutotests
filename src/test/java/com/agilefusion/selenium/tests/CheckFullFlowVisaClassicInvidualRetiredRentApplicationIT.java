package com.agilefusion.selenium.tests;

import com.agilefusion.selenium.DriverFactory;
import com.agilefusion.selenium.page_objects.FinancialPage;
import com.agilefusion.selenium.page_objects.LandingPage;
import com.agilefusion.selenium.page_objects.PersonalPage;
import com.agilefusion.selenium.page_objects.ReviewPage;
import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dmitrykovpak on 23/02/16.
 */
public class CheckFullFlowVisaClassicInvidualRetiredRentApplicationIT extends DriverFactory {
    @Test
    public void checkFullFlowVisaClassicInvidualRetiredRentApplication() throws Exception {
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        LandingPage landingPage = new LandingPage();
        landingPage.clickNextbutton();
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        PersonalPage personalPage = new PersonalPage();
       // getDriver().manage().window().maximize();
        personalPage.fillPersonalInfo();
        personalPage.clickNextButton();
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        FinancialPage financialPage = new FinancialPage();
        financialPage.selectPrimaryRetiredOption();
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        financialPage.setPrimaryGrossMonthlyIncome();
        financialPage.selectPrimaryRentOption();
        financialPage.setPrimaryResidenceMonthlyPayment();
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        financialPage.clickOnNextToReviewButton();
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        ReviewPage reviewPage = new ReviewPage();
        reviewPage.checkAccountAgreementCheckBox();
        reviewPage.checkPrivacyPolicyCheckBox();
        reviewPage.checkCreditCardSolicitationDisclosuresCheckBox();
        reviewPage.checkIAgreeCheckBox();
        reviewPage.setVerificationCode();
        reviewPage.setEnterNameField();
        reviewPage.clickSubmitButton();
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".md-raised.md-primary.md-button.md-ink-ripple.flex-sm-50.flex")).isDisplayed(), true);
    }

}
