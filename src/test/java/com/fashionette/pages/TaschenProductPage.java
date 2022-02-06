package com.fashionette.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class TaschenProductPage extends TaschenPage{

    @FindBy(css = "[class='btn btn--bigger-icon preventspinner btn-default']")
    public WebElement addCartBtn;

    @FindBy(css = "[class='cart-amount']")
    public WebElement itemAmount;

    @FindBy(css = "[itemprop='brand']")
    public WebElement productPageTascheBrand;

    @FindBy(xpath = "//h1[@class='product-details__description__brand']//small")
    public WebElement productPageTascheName;

    @FindBy(xpath = "//h1[@class='product-details__description__brand']//small/span")
    public WebElement productPageTascheType;

    @FindBy(css = "[class='product-details__description__price--special font-size--h1 text__weight--semi-bold']")
    public WebElement productPageTaschePrice;

    public static Map<String, String> productPageTascheInfo = new HashMap<>();

    public void tascheInfoEntry(){

        productPageTascheInfo.put("Tasche Brand",productPageTascheBrand.getText());
        productPageTascheInfo.put("Tasche Name",productPageTascheName.getText());
        productPageTascheInfo.put("Tasche Type",productPageTascheType.getText());
        productPageTascheInfo.put("Tasche Price",productPageTaschePrice.getText());

//        System.out.println("TASCHEN PRODUCT PAGE INFO :");
//        System.out.println(productPageTascheBrand.getText());
//        System.out.println(productPageTascheName.getText());
//        System.out.println(productPageTascheType.getText());
//        System.out.println(productPageTaschePrice.getText());

    }


}
