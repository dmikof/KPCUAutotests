package com.agilefusion.selenium.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(how = How.CSS, using = "#primaryResidenceMonthlyPayment");
    private WebElement primaryResidenceMonthlyPayment;

    public FinancialPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void openSourceOfIncomeMenu() {
        sourceOfIncomeMenu.click();
    }
}
