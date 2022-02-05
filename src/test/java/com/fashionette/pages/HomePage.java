package com.fashionette.pages;

import com.fashionette.utilities.BrowserUtils;
import com.fashionette.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(css = "a[href='https://www.fashionette.de/login']")
    public WebElement logInBtn;

    @FindBy(css = "a[href='https://www.fashionette.de/wishlist']")
    public WebElement wishListBtn;

    @FindBy(css = "a[href='https://www.fashionette.de/cart']")
    public WebElement cartBtn;

    @FindBy(xpath = "//*[@class='header__navigation']//li")
    public List<WebElement> headerMenu;

    @FindBy(css = "[title='Suche']")
    public WebElement searchBtn;

    public void selectedMainCategory (String selectedMainCategory){

        for (int i = 0; i < headerMenu.size(); i++) {
            String currentCategory = headerMenu.get(i).getText();
            if (selectedMainCategory.equalsIgnoreCase(currentCategory)){
                headerMenu.get(i).click();

            }
        }
    }

}
