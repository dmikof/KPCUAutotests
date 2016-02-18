package com.agilefusion.selenium.page_objects;

import com.agilefusion.selenium.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
    private WebElement primaryCSSField;
    @FindBy(how = How.CSS, using = "#fl-input-7")
    private WebElement primaryAddressField;
    @FindBy(how = How.CSS, using = "#primaryAddressCity")
    private WebElement primaryCityField;
    @FindBy(how = How.CSS, using = "#select_value_label_3>span")
    private WebElement primaryStateDropDownMenu;

    public PersonalPage() throws Exception {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void clickPrimaryStateDropDownMenu(){
        primaryStateDropDownMenu.click();
    }
}
