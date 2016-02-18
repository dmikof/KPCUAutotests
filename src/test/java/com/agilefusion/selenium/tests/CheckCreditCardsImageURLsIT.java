package com.agilefusion.selenium.tests;

import com.agilefusion.selenium.DriverFactory;
import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by dmitrykovpak on 18/02/16.
 */
public class CheckCreditCardsImageURLsIT extends DriverFactory{

    @Test
    public void CheckVisaPlatinumRewardsImageURL() throws Exception{
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String  visaPlatinumRewardsImageUrl = (String) js.executeScript
                ("var result = window.getComputedStyle(document.querySelector('.card.platinum-rewards'), ':before').getPropertyValue('background-image'); return result");
        assertThat(visaPlatinumRewardsImageUrl, is("url(\"http://staging.kpcu.agilefusion.work/dist/images/steps/cardType/viza_platinum_rewards.png\")"));
    }

    @Test
    public void CheckVisaPlatinumImageURL() throws Exception{
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String  visaPlatinumImageURL = (String) js.executeScript
                ("var result = window.getComputedStyle(document.querySelector('.card.platinum'), ':before').getPropertyValue('background-image'); return result");
        assertThat(visaPlatinumImageURL, is("url(\"http://staging.kpcu.agilefusion.work/dist/images/steps/cardType/viza_platinum.png\")"));
    }
    @Test
    public void CheckClassicImageURL() throws Exception{
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String  visaClassicImageURL = (String) js.executeScript
                ("var result = window.getComputedStyle(document.querySelector('.card.classic'), ':before').getPropertyValue('background-image'); return result");
        assertThat(visaClassicImageURL, is("url(\"http://staging.kpcu.agilefusion.work/dist/images/steps/cardType/viza_classic.png\")"));
    }

}
