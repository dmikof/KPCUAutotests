package com.agilefusion.selenium.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.agilefusion.selenium.DriverFactory.getDriver;

/**
 * Created by dmitrykovpak on 23/02/16.
 */
public class ReviewPage {

    @FindBy(how = How.XPATH, using = "html/body/ui-view/div/wizard/div[1]/section[4]/form/md-content/div/div[1]/div[2]/md-checkbox/div[1]")
    private WebElement accountAgreementCheckBox;

    @FindBy(how = How.XPATH, using = "html/body/ui-view/div/wizard/div[1]/section[4]/form/md-content/div/div[1]/div[3]/md-checkbox/div[1]")
    private WebElement privacyPolicyCheckBox;

    @FindBy(how = How.XPATH, using = "html/body/ui-view/div/wizard/div[1]/section[4]/form/md-content/div/div[1]/div[4]/md-checkbox/div[1]")
    private WebElement creditCardSolicitationDisclosuresCheckBox;

    @FindBy(how = How.XPATH, using = "html/body/ui-view/div/wizard/div[1]/section[4]/form/md-content/div/div[2]/div/md-checkbox/div[1]")
    private WebElement iAgreeCheckBox;

    @FindBy(how = How.CSS, using = "#verificationCode")
    private WebElement verificationCodeField;

    @FindBy(how = How.CSS, using = "#enterName")
    private WebElement enterNameField;

    @FindBy(how = How.CSS, using = "[data-test='desktop-button-next']")
    private WebElement submitButton;

    public ReviewPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void checkAccountAgreementCheckBox() {
        if (!accountAgreementCheckBox.isSelected()) {
            accountAgreementCheckBox.click();}
    }

    public void checkPrivacyPolicyCheckBox() {
        if (!privacyPolicyCheckBox.isSelected()) {
            privacyPolicyCheckBox.click();}
    }

    public void checkCreditCardSolicitationDisclosuresCheckBox() {
        if (!creditCardSolicitationDisclosuresCheckBox.isSelected()) {
            creditCardSolicitationDisclosuresCheckBox.click();
        }
    }

    public void checkIAgreeCheckBox() {
        if (!iAgreeCheckBox.isSelected()) {
            iAgreeCheckBox.click();
        }
    }

    public void setVerificationCode() {
        verificationCodeField.sendKeys("1234567890");
    }

    public void setEnterNameField() {
        enterNameField.sendKeys("Selenium Webdriver");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}

