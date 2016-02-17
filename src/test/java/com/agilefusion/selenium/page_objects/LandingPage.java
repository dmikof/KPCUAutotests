package com.agilefusion.selenium.page_objects;

/**
 * Created by dmitrykovpak on 20/01/16.
 */

    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.How;
    import org.openqa.selenium.support.PageFactory;
    import com.agilefusion.selenium.DriverFactory;

    /**    .md-button.md-ink-ripple >
     * Created by dmitrykovpak on 23/12/15.
     */
    public class LandingPage {

        @FindBy(how = How.CSS, using = "#radio_0")
        private WebElement visaPlatinumRewards;

        @FindBy(how = How.CSS, using = "#radio_1")
        private WebElement visaPlatinum;

        @FindBy(how = How.CSS, using = "#radio_2")
        private WebElement visaClassic;

        @FindBy(how = How.CSS, using = "[data-test='button-next']")
        private WebElement nextButton;

        //@FindBy(how = How.CSS, using = "[data-test='button-back']")
        //private WebElement backButton;

        //@FindBy(how = How.CSS, using = "[wizard-title='']")
        //public WebElement wizardTitle;

        @FindBy(how = How.CSS, using = ".card-label")
        private WebElement cardLabel;

        @FindBy(how = How.CSS, using = ".summary-credit-terms.platinum-rewards.ng-scope")
        private WebElement platinumRewardsLinkToKPCUTermsPage;

        @FindBy(how = How.CSS, using = ".summary-credit-terms.platinum.ng-scope")
        private WebElement platinumLinkToKPCUTermsPage;

        @FindBy(how = How.CSS, using = ".summary-credit-terms.classic.ng-scope")
        private WebElement classicLinkToKPCUTermsPage;

        @FindBy(how = How.CSS, using = ".logotype.flex")
        private WebElement logoImage;


        public LandingPage() throws Exception {
            PageFactory.initElements(DriverFactory.getDriver(), this);
        }

        public void selectVisaPlatinumRewards() {
            if (!visaPlatinumRewards.isSelected()) {
                visaPlatinumRewards.click();}
        }

        public void selectVisaPlatinum() {
            if (!visaPlatinum.isSelected()) {
                visaPlatinum.click();
            }
        }

        public void selectVisaClassic() {
            if (!visaClassic.isSelected()) {
                visaPlatinumRewards.click();
            }
            visaClassic.click();
        }

        public ApplicationTypePage clickNextbutton() throws Exception {
            nextButton.click();
            return new ApplicationTypePage();
        }

        public String getVisaPlatinumRewardsText() {
            String visaPlatinumRewardsText = visaPlatinumRewards.getText();
            return visaPlatinumRewardsText;
        }

        public String getVisaPlatinumText() {
            String visaPlatinumText = visaPlatinum.getText();
            return visaPlatinumText;
        }

        public String getVisaClassicText() {
            String visaClassicText = visaClassic.getText();
            return visaClassicText;
        }
       /*
        public  String getWizardTitleText() {
            String wizardTitleText = wizardTitle.getText();
            return wizardTitleText;
        }   */

        public String getCardLableText() {
            String cardLabelText = cardLabel.getText();
            return cardLabelText;
        }

        public String getPlatinumRewardsURLToKPCUTermsPage() {
            String platinumRewardsURLToKPCUTermsPage = platinumRewardsLinkToKPCUTermsPage.getAttribute("href");
            return platinumRewardsURLToKPCUTermsPage;
        }

        public String getPlatinumURLToKPCUTermsPage() {
            String platinumURLToKPCUTermsPage = platinumLinkToKPCUTermsPage.getAttribute("href");
            return platinumURLToKPCUTermsPage;
        }
        public String getClassicURLToKPCUTermsPage() {
            String classicURLToKPCUTermsPage = classicLinkToKPCUTermsPage.getAttribute("href");
            return classicURLToKPCUTermsPage;
        }
    }

