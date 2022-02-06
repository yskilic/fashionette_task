package com.fashionette.pages;

import com.fashionette.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class CartPage extends HomePage{

    @FindBy(css = "[class='cart-item--brand']")
    public WebElement nameInCart;

    @FindBy(xpath = "//div[contains(text(),'Saint Laurent')]")
    public WebElement tascheBrandInCart;

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

    @FindBy(xpath = "//div[@class='cart__shopping-bag']//tbody/tr[2]/td")
    public WebElement firstSum;

    @FindBy(xpath = "//div[@class='cart__shopping-bag']//tbody/tr[3]/td/span")
    public WebElement voucherValue;

    @FindBy(xpath = "//div[@class='cart__shopping-bag']//tbody/tr[7]/td")
    public WebElement finalSum;


    public static Map<String, String> productInCart = new HashMap<String, String>();

    public Map<String, String> getProductInCart() {
        return productInCart;
    }

    public void infoSchuheInCartEntry(){
        productInCart.put("Name", nameInCart.getText());
        productInCart.put("Product Name", productNameInCart.getText());
        productInCart.put("Product Type", productTypeInCart.getText());
        productInCart.put("Size", productSizeInCart.getText());
        productInCart.put("Price",productPriceInCart.getText());
    }


    public void executeVoucherCode(String vCode){
        voucherBtn.click();
        codeEntryBox.clear();
        codeEntryBox.sendKeys(vCode);
        codeExecuteBox.click();
    }

    public void voucherCheck(){

        int firstValue = Integer.parseInt(firstSum.getText());
        int voucherVal = Integer.parseInt(voucherValue.getText());
        int finalValue = Integer.parseInt(finalSum.getText());

        if (firstValue>finalValue) {
            System.out.println("Your Voucher Code is Valid and " + voucherVal + " Euro discount applied");
        }else {
            System.out.println("Your Voucher Code is NOT Valid. Try another code");
        }
    }
}


