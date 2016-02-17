package com.agilefusion.selenium.tests;

import com.agilefusion.selenium.DriverFactory;
import com.agilefusion.selenium.page_objects.LandingPage;
import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by dmitrykovpak on 16/02/16.
 */
public class CheckURLsLeadToKPCUTermsPageIT extends DriverFactory {
    @Test
    public void checkVisaPlatinumRewardsURL() throws Exception {
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        LandingPage landingPage = new LandingPage();
        assertThat(landingPage.getPlatinumRewardsURLToKPCUTermsPage(),
                is("https://kpcu.com/resources/privacy-legal/credit-card-terms-and-disclosure"));
        System.out.println(landingPage.getPlatinumRewardsURLToKPCUTermsPage());

    }

    @Test
    public void checkVisaPlatinumURL() throws Exception {
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        LandingPage landingPage = new LandingPage();
        assertThat(landingPage.getPlatinumURLToKPCUTermsPage(), is("https://kpcu.com/resources/privacy-legal/credit-card-terms-and-disclosure"));
    }
    @Test
    public void checkVisaClassicURL() throws Exception {
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        LandingPage landingPage = new LandingPage();
        assertThat(landingPage.getClassicURLToKPCUTermsPage(), is("https://kpcu.com/resources/privacy-legal/credit-card-terms-and-disclosure"));
    }
}
