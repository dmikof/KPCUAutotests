package com.agilefusion.selenium.tests.TestAndDebugTests;

import com.agilefusion.selenium.DriverFactory;
import com.agilefusion.selenium.page_objects.LandingPage;
import com.agilefusion.selenium.utils.AdditionalConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by dmitrykovpak on 16/02/16.
 */
public class ClassToDebugAndTestInFF extends DriverFactory {
    @Test
    public void testInFF() throws Exception {
        loadLandingPage();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        //LandingPage landingPage = new LandingPage();
       // WebElement button1 = getDriver().findElement(By.cssSelector(".card-type md-radio-button.card.platinum-rewards"));
        //String image = button1.getCssValue("background-image");
        //System.out.println(button1.getCssValue("background-image"));
        //WebElement linkProduct = getDriver().findElement(By.cssSelector(".ng-binding.ng-scope.current"));
        //linkProduct.click();
        //WebDriverWait wait = new WebDriverWait(getDriver(), 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
       String  imageurl = (String) js.executeScript
               ("var result = window.getComputedStyle(document.querySelector('.card.platinum'), ':before').getPropertyValue('background-image'); return result");
              // ("window.getComputedStyle(document.querySelector('.card.platinum'), ':before').getPropertyValue('background-image').toString()");
        System.out.print(imageurl);
        assertThat(imageurl, is("url(\"http://staging.kpcu.agilefusion.work/dist/images/steps/cardType/viza_platinum.png\")"));
    }
}
