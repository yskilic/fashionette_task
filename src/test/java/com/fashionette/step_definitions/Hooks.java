package com.fashionette.step_definitions;

import com.fashionette.utilities.BrowserUtils;
import com.fashionette.utilities.ConfigurationReader;
import com.fashionette.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){

        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(2);
        BrowserUtils.closeShadow();
//        Shadow shadow = new Shadow(Driver.get());
//        WebElement elementShadow = shadow.findElement("[data-testid='uc-accept-all-button']");
//        elementShadow.click();

    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }


}
