package com.fashionette.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaschenPage extends HomePage {

    @FindBy(css = "[itemtype='http://schema.org/ItemList']")
    public List<WebElement> listTaschen;

    @FindBy(css = "[class='product-list__product-brand']")
    public List<WebElement> tascheBrandsOnList;

    @FindBy(css = "[class='product--list__item__name']")
    public List<WebElement> tascheNameOnList;

    @FindBy(css = "[class='product--list__item__product_type']")
    public List<WebElement> tascheTypeOnList;

    @FindBy(css = "[itemprop='price']")
    public List<WebElement> taschePriceOnList;




    public static Map<String, String> selectedTaschenInfo = new HashMap<>();


    public void selectTashenByName(String taschenBrand){

        for (int i = 0; i < tascheBrandsOnList.size(); i++) {

            if (tascheBrandsOnList.get(i).getText().equalsIgnoreCase(taschenBrand)){
                selectedTaschenInfo.put("Tasche Brand", tascheBrandsOnList.get(i).getText());
                selectedTaschenInfo.put("Tasche Name", tascheNameOnList.get(i).getText());
                selectedTaschenInfo.put("Tasche Type", tascheTypeOnList.get(i).getText());
                selectedTaschenInfo.put("Tasche Price", taschePriceOnList.get(i).getText());

                System.out.println("TASCHEN PAGE :");
                System.out.println(tascheBrandsOnList.get(i).getText());
                System.out.println(tascheNameOnList.get(i).getText());
                System.out.println(tascheTypeOnList.get(i).getText());
                System.out.println(taschePriceOnList.get(i).getText());
                System.out.println("-----------------------");
                tascheBrandsOnList.get(i).click();
            }
        }
    }


}
