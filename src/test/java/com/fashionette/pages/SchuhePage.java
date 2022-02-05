package com.fashionette.pages;

import com.fashionette.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SchuhePage extends HomePage{


    @FindBy(xpath = "//*[@data-carousel='category']/div")
    public List<WebElement> caruselCategory;

    @FindBy(css = "[itemscope='itemscope']")
    public List<WebElement> itemScopeList;

    @FindBy(css = "[class='category__name']")
    public WebElement shuheCategoryName;

    public void selectSchuheCategory(String selectedSchuheCategory){

        for (int i = 0; i < caruselCategory.size(); i++) {
            if(selectedSchuheCategory.equalsIgnoreCase(caruselCategory.get(i).getText())){
                caruselCategory.get(i).click();
            }
        }
    }
}
