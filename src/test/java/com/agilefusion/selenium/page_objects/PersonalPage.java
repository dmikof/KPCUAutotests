package com.agilefusion.selenium.page_objects;

import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.agilefusion.selenium.DriverFactory.getDriver;

/**
 * Created by dmitrykovpak on 20/01/16.
 */
public class PersonalPage {

    @FindBy(how = How.CSS, using = "#primaryFirstName")
    private WebElement primaryFirstNameField;

    @FindBy(how = How.CSS, using = "#primaryMiddleName")
    private WebElement primaryMiddleNameField;

    @FindBy(how = How.CSS, using = "#primaryLastName")
    private WebElement primaryLastNameField;

    @FindBy(how = How.CSS, using = ".md-datepicker-input")
    private WebElement primaryBirthDateField;

    @FindBy(how = How.CSS, using = "#primarySsn")
    private WebElement primarySSNField;

    @FindBy(how = How.CSS, using = "#fl-input-7")
    private WebElement primaryAddressField;

    @FindBy(how = How.CSS, using = "#primaryAddressCity")
    private WebElement primaryCityField;

    @FindBy(how = How.XPATH, using = "md-select#primaryAddressState") //will not click on
    private WebElement primaryStateDropDownMenu;

    @FindBy(how = How.CSS, using = "#primaryAddressZipCode")
    private WebElement primaryZipCode;

    @FindBy(how = How.CSS, using = "md-select#primaryDocumentType")
    private WebElement primaryDocumentType;

    @FindBy(how = How.CSS, using = "#primaryDocumentNumber")
    private WebElement primaryDocumentNumber;

    @FindBy(how = How.CSS, using = "#primaryMobile")
    private WebElement primaryPhoneNumber;

    @FindBy(how = How.CSS, using = "#primaryEmail")
    private WebElement primaryEmail;

    @FindBy(how = How.XPATH, using =
            "html/body/ui-view/div/wizard/div[1]/section[2]/form/md-content/div/div[3]/div[1]/div/div[1]/md-datepicker/div[1]/input")
    private WebElement primaryDocumentIssueDate;

    @FindBy(how = How.XPATH, using =
            "html/body/ui-view/div/wizard/div[1]/section[2]/form/md-content/div/div[3]/div[2]/div[1]/div[1]/md-datepicker/div[1]/input")
    private WebElement primaryDocumentExpirationDate;

    @FindBy(how = How.CSS, using = "[data-test='desktop-button-next']")
    private WebElement nextButton;

    //@FindBy(how = How.CSS, using = "md-select-menu md-option[value='driving_license']")
    //private WebElement primaryDrivingLicenseOption;


    public PersonalPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickPrimaryStateDropDownMenu() throws Exception {
        /*((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView();", primaryStateDropDownMenu); */
        primaryStateDropDownMenu.click();
    }

    public void selectPrimaryDrivingLicenseOption() throws Exception {
        getDriver().manage().window().maximize();
        primaryDocumentType.click();
        WebElement primaryDrivingLicenseOption = getDriver().findElement
                (By.cssSelector("md-select-menu md-option[value='driving_license']"));
        primaryDrivingLicenseOption.click();
    }

    public void fillPersonalInfo() throws Exception {
        primaryFirstNameField.sendKeys("Selenium");
        primaryMiddleNameField.sendKeys("Java");
        primaryLastNameField.sendKeys("Webdriver");
        primaryBirthDateField.sendKeys("07/09/1980");
        primarySSNField.sendKeys("123-45-6789");
        primaryAddressField.sendKeys("1783 Spumante Place");
        primaryCityField.sendKeys("Pleasanton");
        primaryZipCode.sendKeys("94566");
        selectPrimaryDrivingLicenseOption();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        primaryDocumentNumber.click();
        primaryDocumentNumber.sendKeys("1234567");
        primaryDocumentIssueDate.sendKeys("07/01/2010");
        primaryDocumentExpirationDate.sendKeys("12/31/2018");
        primaryPhoneNumber.sendKeys("2222222233");
        primaryEmail.sendKeys("test@agilefusion.selenium.com");
    }

    public FinancialPage clickNextButton() throws Exception {
        nextButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        getDriver().manage().window().setSize(new Dimension(900, 800));
        return new FinancialPage();
    }
}
