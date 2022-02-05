package com.fashionette.pages;

import com.fashionette.utilities.BrowserUtils;
import com.fashionette.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

public class AccountPage extends HomePage{

    @FindBy(xpath = "//div[contains(text(),'Hallo')]")
    public WebElement msgFirst;

    @FindBy(xpath = "//div[contains(text(),'Hallo')]/span")
    public WebElement firstName;

    @FindBy(css = "[class='account-personaldata']")
    public WebElement personalInfoBtn;

    @FindBy(xpath = "//div[@class='account--personaldata']//div[contains(text(),'Bearbeiten')]")
    public WebElement updateBtn;

    @FindBy(xpath = "//input[@value='Mr']")
    public List<WebElement> salutationRadioBtns;

    @FindBy(name = "first_name")
    public WebElement firstNameInputBox;

    @FindBy (name = "last_name")
    public WebElement lastNameInputBox;

    @FindBy(css = "[class='account--address__action account--address__action--save']")
    public WebElement saveBtn;

    @FindBy(css = "[class='account__content__column account__content__column--customer']")
    public WebElement personalNamesInfo;


    public void personelInfoUpdate(String firstName, String lastName){

        personalInfoBtn.click();
        updateBtn.click();
        salutationRadioBtns.get(0).click();
        BrowserUtils.waitFor(1);
        firstNameInputBox.clear();
        firstNameInputBox.sendKeys(firstName);
        lastNameInputBox.clear();
        lastNameInputBox.sendKeys(lastName);
        saveBtn.click();
    }

    public String [] personelInfoCheck(){
        String [] infoArr = new String[3];
        String tmp = personalNamesInfo.getText().trim();
        infoArr = tmp.trim().split("\\n");
        infoArr = infoArr[0].split(" ");
        return infoArr;
    }

    public String firstMessage(){
        String tmp = msgFirst.getText();
        tmp = tmp.split("Hallo John").toString();
        return msgFirst.getText();
    }

}
