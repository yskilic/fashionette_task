package com.fashionette.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class CartPage extends HomePage{

    @FindBy(css = "[class='cart-item--brand']")
    public WebElement nameInCart;

    @FindBy(css = "[class='cart-item--name']")
    public WebElement productNameInCart;

    @FindBy(css = "[class='cart-item--product-type']")
    public WebElement productTypeInCart;

    @FindBy(css = "[class='cart-item--size']")
    public WebElement productSizeInCart;

    @FindBy (xpath = "//div[@class='cart-item--price']/span")
    public WebElement productPriceInCart;


    public static Map<String, String> productInCart = new HashMap<String, String>();

    public Map<String, String> getProductInCart() {
        return productInCart;
    }

    public void infoInCartEntry(){
        productInCart.put("Name", nameInCart.getText());
        productInCart.put("Product Name", productNameInCart.getText());
        productInCart.put("Product Type", productTypeInCart.getText());
        productInCart.put("Size", productSizeInCart.getText());
        productInCart.put("Price",productPriceInCart.getText() );
    }

}


