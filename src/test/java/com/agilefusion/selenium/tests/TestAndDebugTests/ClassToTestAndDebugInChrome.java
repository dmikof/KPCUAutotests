package com.agilefusion.selenium.tests.TestAndDebugTests;

import com.agilefusion.selenium.page_objects.LandingPage;
import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dmitrykovpak on 15/02/16.
 */
public class ClassToTestAndDebugInChrome {
    @Test
    public void methodToTestAndDebug() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/dmitrykovpak/IdeaProjects/Selenium-Maven-Template/selenium_standalone/osx/googlechrome/64bit/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://staging.kpcu.agilefusion.work/");
        LandingPage landingPage = new LandingPage();
        WebDriverWait wait = new WebDriverWait(driver, 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        landingPage.selectVisaPlatinum();
        Assert.assertEquals(landingPage.getCardLableText(), "Visa Platinum");}

}


