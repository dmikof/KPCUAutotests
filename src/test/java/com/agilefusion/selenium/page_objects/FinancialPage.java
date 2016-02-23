package com.agilefusion.selenium.page_objects;

import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.agilefusion.selenium.DriverFactory.getDriver;

/**
 * Created by dmitrykovpak on 22/02/16.
 */
public class FinancialPage {

    @FindBy(how = How.CSS, using = "md-select#primarySource")
    private WebElement sourceOfIncomeMenu;

    @FindBy(how = How.CSS, using = "#primaryGrossMonthlyIncome")
    private WebElement primaryGrossMonthlyIncomeField;

    @FindBy(how = How.CSS, using = "md-select#primaryResidenceType")
    private WebElement primaryResidenceTypeMenu;

    @FindBy(how = How.CSS, using = "#primaryResidenceMonthlyPayment")
    private WebElement primaryResidenceMonthlyPayment;

    @FindBy(how = How.CSS, using = "[data-test='desktop-button-next']")
    private WebElement nextToReviewButton;

    public FinancialPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void openSourceOfIncomeMenu() {
        sourceOfIncomeMenu.click();
    }

    public void selectPrimaryRetiredOption() throws Exception{
        sourceOfIncomeMenu.click();
        WebElement primaryRetiredSourceOption = getDriver().findElement
                (By.cssSelector("md-select-menu md-option[value='retired']"));
        primaryRetiredSourceOption.click();
    }

    public void setPrimaryGrossMonthlyIncome() {
        primaryGrossMonthlyIncomeField.sendKeys("5000");
    }

    public void selectPrimaryRentOption() throws Exception{
        primaryResidenceTypeMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        getDriver().findElement
                (By.cssSelector("md-select-menu md-option[value='rent']")).click();
    }

    public void setPrimaryResidenceMonthlyPayment() {
        primaryResidenceMonthlyPayment.sendKeys("344");
    }

    public ReviewPage clickOnNextToReviewButton() throws Exception{
        nextToReviewButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        return new ReviewPage();
    }
}

