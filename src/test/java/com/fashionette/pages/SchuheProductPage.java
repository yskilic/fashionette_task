package com.fashionette.pages;

import com.fashionette.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchuheProductPage extends SchuhePage{

    @FindBy(css = "[itemprop= 'brand']")
    public WebElement productPageSchuheName;

    @FindBy(css = "[class='product-details__description__name text__weight--normal']")
    public WebElement productPageProductName;

    @FindBy(css = "[class='product-details__description__price--special font-size--h1 text__weight--semi-bold']")
    public WebElement productPagePrice;

    @FindBy(xpath = "//small[@itemprop='name']/span")
    public WebElement productPageProductType;

    @FindBy(xpath = "//div[@class='color_picker__links']/a")
    public List<WebElement> productColor;

    @FindBy(xpath = "//div[@class='size-selector__item-table text__line-height--small']/span")
    public List<WebElement> productSize;

    @FindBy(xpath = "//*[@class='btn btn--bigger-icon preventspinner btn-default']//span")
    public WebElement addCartBtn;

    @FindBy(xpath = "//div[@class='minicart-dialog']")
    public WebElement miniInfoBox;

    @FindBy(css = "[class='cart-amount']")
    public WebElement itemAmount;


    public static Map<String, String> productPageInfo = new HashMap<String, String>();

    public Map<String, String> getProductPageInfo() {
        return productPageInfo;
    }

    public void chooseDetailsProduct(String size, String color){

        productPageInfo.put("Schuhe Name", productPageSchuheName.getText());
        productPageInfo.put("Product Name", productPageProductName.getText());
        productPageInfo.put("Product Type", productPageProductType.getText());
        productPageInfo.put("Schuhe Price", productPagePrice.getText());

        for (int i = 0; i < productColor.size(); i++) {
            String colorLink = productColor.get(i).getAttribute("title").toString();
            if (colorLink.contains(color)){
                productColor.get(i).click();
                productPageInfo.put("Color" , colorLink);

            }
        }

        BrowserUtils.waitFor(1);

        for (int i = 0; i < productSize.size(); i++) {
            String sizeLink = productSize.get(i).getText();
            if (sizeLink.contains(size)){
                productSize.get(i).click();
                productPageInfo.put("Size", size);
            }
        }

    }

}
