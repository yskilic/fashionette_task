package com.fashionette.pages;

import com.fashionette.utilities.ConfigurationReader;
import com.fashionette.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends HomePage {

    @FindBy(css = "[name='email']")
    public WebElement emailBox;

    @FindBy(css = "[name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[contains(text(),'Einloggen')]")
    public WebElement submitBtn;

    public void login (){
        String userName = ConfigurationReader.get("user_name");
        emailBox.sendKeys(userName);
        String userPassword = ConfigurationReader.get("user_password");
        passwordBox.sendKeys(userPassword);
        submitBtn.click();

    }

}
