package com.fashionette.step_definitions;

import com.fashionette.pages.*;
import com.fashionette.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Scenario_3_StepDef {
    @When("the user can select one product as {string}")
    public void the_user_can_select_one_product_as(String selectTascheBrand) {
        TaschenPage taschenPage = new TaschenPage();
        taschenPage.selectTashenByName(selectTascheBrand);

    }

    @When("the user verify product and add to the cart")
    public void the_user_verify_product_and_add_to_the_cart() {
        TaschenProductPage taschenProductPage = new TaschenProductPage();

        taschenProductPage.tascheInfoEntry();

        Assert.assertEquals("Verify Brand", TaschenPage.selectedTaschenInfo.get("Tasche Brand"),TaschenProductPage.productPageTascheInfo.get("Tasche Brand"));
        Assert.assertTrue("Verify Name", TaschenProductPage.productPageTascheInfo.get("Tasche Name").contains(TaschenPage.selectedTaschenInfo.get("Tasche Name")));
        Assert.assertEquals("Verify Brand", TaschenPage.selectedTaschenInfo.get("Tasche Type"),TaschenProductPage.productPageTascheInfo.get("Tasche Type"));
//        Assert.assertEquals("Verify Price", TaschenPage.selectedTaschenInfo.get("Tasche Price"),TaschenProductPage.productPageTascheInfo.get("Tasche Price"));

        taschenProductPage.addCartBtn.click();

    }

    @When("the selected_tasche on cart page")
    public void the_selected_tasche_on_cart_page() {
        CartPage cartPage = new CartPage();
        cartPage.tascheInfoEntryInCart();

//        String expectedBrand = TaschenProductPage.productPageTascheInfo.get("Tasche Brand");
//        String actualBrand = CartPage.productInCart.get("Tashe Brand");
//        Assert.assertEquals("Verify Names", expectedBrand,actualBrand);
//
//        String expectedName = TaschenProductPage.productPageTascheInfo.get("Tasche Name");
//        String actualName = CartPage.productInCart.get("Tasche Name");
//        Assert.assertEquals("Verify Type", expectedName, actualName);
//
//        String expectedType = TaschenProductPage.productPageTascheInfo.get("Tasche Type");
//        String actualType = CartPage.productInCart.get("Tasche Type");
//        Assert.assertEquals("Verify Color", expectedType,actualType);
//
//        String expectedPrice = TaschenPage.selectedTaschenInfo.get("Tasche Price");
//        String actualPrice = CartPage.productInCart.get("Tasche Price");
//        Assert.assertEquals("Verify Price", expectedPrice,actualPrice);


    }

    @When("the user can apply {string}")
    public void the_user_can_apply(String voucherCode) {
        CartPage cartPage = new CartPage();
        cartPage.executeVoucherCode(voucherCode);

    }

    @Then("voucher should be properly applied")
    public void voucher_should_be_properly_applied() {
        System.out.println("EVERYTHING CLEAR????");
    }

}
