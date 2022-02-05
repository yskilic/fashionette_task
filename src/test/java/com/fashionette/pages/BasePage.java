package com.fashionette.pages;


import com.fashionette.utilities.Driver;
import junit.framework.Assert;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

}
