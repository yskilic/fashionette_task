package com.fashionette.pages;

import com.fashionette.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SchuheCategoryPage extends SchuhePage{

    @FindBy(xpath = "//div[@class='product-list']/div[3]/div")
    public List<WebElement> productItemList;

    @FindBy(xpath = "//div[@itemtype='http://schema.org/ItemList']/div[1]/div/a/div/div[2]/div[1]")
    public WebElement schuheName;

    @FindBy(xpath = "//div[@itemtype='http://schema.org/ItemList']/div[1]/div/a/div/div[2]/div[2]")
    public WebElement schuheProductName;

    @FindBy(xpath = "//div[@itemtype='http://schema.org/ItemList']/div[1]/div/a/div/div[2]/div[3]")
    public WebElement schuheProductType;

    @FindBy(xpath = "//div[@itemtype='http://schema.org/ItemList']/div[1]/div/a/div//span/p")
    public WebElement schuhePrice;

    public static Map<String, String> selectedProductInfo = new HashMap<String, String>();

    public Map<String, String> getSelectedProductInfo() {
        return selectedProductInfo;
    }

    public void selectedProduct(String selectSchuheName){


        for (int i = 0; i < productItemList.size(); i++) {
            if (schuheName.getText().equalsIgnoreCase(selectSchuheName)){
                selectedProductInfo.put("Schuhe Name", schuheName.getText());
                selectedProductInfo.put("Product Name", schuheProductName.getText());
                selectedProductInfo.put("Product Type", schuheProductType.getText() );
                selectedProductInfo.put("Schuhe Price", schuhePrice.getText());
                productItemList.get(i).click();
            }
        }
    }



}

