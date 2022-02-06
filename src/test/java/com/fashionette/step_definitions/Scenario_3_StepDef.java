package com.fashionette.step_definitions;

import com.fashionette.pages.*;
import com.fashionette.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

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
        Assert.assertEquals("Verify Price", TaschenPage.selectedTaschenInfo.get("Tasche Price"),TaschenProductPage.productPageTascheInfo.get("Tasche Price"));

        taschenProductPage.addCartBtn.click();

    }

    @When("the selected_tasche on cart page")
    public void the_selected_tasche_on_cart_page() {
        CartPage cartPage = new CartPage();


        String expectedBrand = TaschenProductPage.productPageTascheInfo.get("Tasche Brand");
        String actualBrand = cartPage.tascheBrandInCart.getText();
        Assert.assertEquals("Verify Brand", expectedBrand,actualBrand);

        String expectedName = TaschenProductPage.productPageTascheInfo.get("Tasche Name");
        String actualName = cartPage.productNameInCart.getText();
        Assert.assertTrue("Verify Name", expectedName.contains(actualName));

        String expectedType = TaschenProductPage.productPageTascheInfo.get("Tasche Type");
        String actualType = cartPage.productTypeInCart.getText();
        Assert.assertEquals("Verify Type", expectedType,actualType);

        String expectedPrice = TaschenPage.selectedTaschenInfo.get("Tasche Price");
        String actualPrice = cartPage.productPriceInCart.getText();
        Assert.assertEquals("Verify Price", expectedPrice,actualPrice);


    }

    @When("the user can apply {string}")
    public void the_user_can_apply(String voucherCode) {
        CartPage cartPage = new CartPage();
        cartPage.executeVoucherCode(voucherCode);


    }

    @Then("voucher should be properly applied")
    public void voucher_should_be_properly_applied() {
       CartPage cartPage = new CartPage();
       cartPage.voucherCheck();

       Assert.assertFalse("Verify Vouche", cartPage.finalSum.getText().equals(cartPage.firstSum.getText()));

    }

}
