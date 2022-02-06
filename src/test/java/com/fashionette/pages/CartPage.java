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

    @FindBy(css = "[class='cart__sum__voucher-link']")
    public WebElement voucherBtn;

    @FindBy(css = "[name='voucherCode']")
    public WebElement codeEntryBox;

    @FindBy (xpath = "//button[contains(text(),'eingeben')]")
    public WebElement codeExecuteBox;


    public static Map<String, String> productInCart = new HashMap<String, String>();

    public Map<String, String> getProductInCart() {
        return productInCart;
    }

    public void infoSchuheInCartEntry(){
        productInCart.put("Name", nameInCart.getText());
        productInCart.put("Product Name", productNameInCart.getText());
        productInCart.put("Product Type", productTypeInCart.getText());
        productInCart.put("Size", productSizeInCart.getText());
        productInCart.put("Price",productPriceInCart.getText() );
    }

    public void tascheInfoEntryInCart(){

        productInCart.put("Tasche Brand", nameInCart.getText());
        productInCart.put("Tashe Name", productNameInCart.getText());
        productInCart.put("Tashe Type", productTypeInCart.getText());
        productInCart.put("Tasche Price", productPriceInCart.getText());

        System.out.println(nameInCart.getText());
        System.out.println(productNameInCart.getText());
        System.out.println(productTypeInCart.getText());
        System.out.println(productPriceInCart.getText());

    }

    public void executeVoucherCode(String code){

        voucherBtn.click();
        codeEntryBox.clear();
        codeEntryBox.sendKeys(code);
        codeExecuteBox.click();

    }


}


