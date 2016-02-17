package com.agilefusion.selenium.tests;
import com.agilefusion.selenium.page_objects.LandingPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.agilefusion.selenium.utils.AdditionalConditions;
import com.agilefusion.selenium.DriverFactory;

/**
 * Created by dmitrykovpak on 15/02/16.
 */
public class CheckCardTypeChangesInHeaderIT extends DriverFactory {

    @Test
    public void selectVisaPlatinumRewardsCheckHeader() throws Exception {
        loadLandingPage();
        LandingPage landingPage = new LandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        landingPage.selectVisaPlatinumRewards();
        Assert.assertEquals(landingPage.getCardLableText(), "Visa Platinum Rewards");
    }
    @Test
    public void selectVisaPlatinumCheckHeader() throws Exception {
        loadLandingPage();
        LandingPage landingPage = new LandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        landingPage.selectVisaPlatinum();
        Assert.assertEquals(landingPage.getCardLableText(), "Visa Platinum");}

    @Test
    public void selectVisaClassicCheckHeader() throws Exception {
        loadLandingPage();
        LandingPage landingPage = new LandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        //landingPage.selectVisaPlatinum();
        landingPage.selectVisaClassic();
        Assert.assertEquals(landingPage.getCardLableText(), "Visa Classic");
    }
}
