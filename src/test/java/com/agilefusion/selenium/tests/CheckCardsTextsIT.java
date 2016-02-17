package com.agilefusion.selenium.tests;

import com.agilefusion.selenium.page_objects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.agilefusion.selenium.utils.AdditionalConditions;
import com.agilefusion.selenium.DriverFactory;

/**
 * Created by dmitrykovpak on 20/01/16.
 */
public class CheckCardsTextsIT extends DriverFactory {
    @Test
    public void checkVisaClassicText() throws Exception{
        //getDriver().get("http://staging.kpcu.agilefusion.work/");
        loadLandingPage();
        LandingPage landingPage = new LandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        Assert.assertEquals(landingPage.getVisaClassicText(),"VISA CLASSIC\n" +
                "Annual Fee: $0\n" +
                "As low as 14.99% APR\n" +
                "First 6 months 0% APR for balance transfers\n" +
                "Credit Card Disclosures");
    }

    @Test
    public void checkVisaPlatinumRewardsText() throws Exception {
        //getDriver().get("http://staging.kpcu.agilefusion.work/");
        loadLandingPage();
        LandingPage landingPage = new LandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        Assert.assertEquals(landingPage.getVisaPlatinumRewardsText(), "VISA PLATINUM REWARDS\n" +
                "Annual Fee: $0\n" +
                "As low as 8.99% APR\n" +
                "2,500 Welcome bonus reward points\n" +
                "Credit Card Disclosures");
    }

    @Test
    public void testVisaPlatinumRewards() throws Exception {
        //getDriver().get("http://staging.kpcu.agilefusion.work/");
        loadLandingPage();
        LandingPage landingPage = new LandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        Assert.assertEquals(landingPage.getVisaPlatinumText(), "VISA PLATINUM\n" +
                "Annual Fee: $0\n" +
                "As low as 6.99% APR\n" +
                "First 6 months 0% APR for balance transfers\n" +
                "Credit Card Disclosures");

    }
}
