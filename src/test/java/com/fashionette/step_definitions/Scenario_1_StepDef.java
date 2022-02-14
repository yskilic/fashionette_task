package com.fashionette.step_definitions;

import com.fashionette.pages.*;
import com.fashionette.utilities.BrowserUtils;
import com.fashionette.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.*;

public class Scenario_1_StepDef {

    @Given("the user should be on the home page")
    public void the_user_should_be_on_the_home_page() {

        String currentlUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "https://www.fashionette.de/";

        Assert.assertEquals("Verify Url",expectedUrl,currentlUrl);

    }

    @When("the user navigates to {string} page")
    public void the_user_navigates_pages(String pageName) {
        HomePage homePage = new HomePage();
        homePage.selectedMainCategory(pageName);
        String expectedUrl = "https://www.fashionette.de/" + pageName.toLowerCase();

        Assert.assertEquals("Verify Url", expectedUrl,Driver.get().getCurrentUrl());

    }


    @When("the user can select category as a {string}")
    public void the_user_can_select_category_as_a(String selectedCategory) {
        SchuhePage schuhePage = new SchuhePage();
        schuhePage.selectSchuheCategory(selectedCategory);
        String expectedUrl = "https://www.fashionette.de/" + selectedCategory.toLowerCase();

        Assert.assertEquals("Verify Url", expectedUrl, Driver.get().getCurrentUrl());

        String actualSchuheCategory = schuhePage.shuheCategoryName.getText();
        Assert.assertEquals("Verify Category", selectedCategory, actualSchuheCategory);

    }

    @When("the user can select one product in current category as {string}")
    public void the_user_can_select_one_product_in_current_category_as(String selectSchuheName) {

        SchuheCategoryPage schuheCategoryPage = new SchuheCategoryPage();
        schuheCategoryPage.selectedProduct(selectSchuheName);

        String schuheName = schuheCategoryPage.getSelectedProductInfo().get("Schuhe Name");

        Assert.assertTrue("Schuhe Name", schuheName.equalsIgnoreCase(selectSchuheName) );

    }

    @When("the user can select product specifications as size {string}")
    public void the_user_can_select_product_specifications_as_size_and_color(String selectSize) {

        SchuheProductPage schuheProductPage = new SchuheProductPage();
        schuheProductPage.chooseDetailsProduct(selectSize);

        Assert.assertEquals("Verify Name", SchuheCategoryPage.selectedProductInfo.get("Schuhe Name"), schuheProductPage.getProductPageInfo().get("Schuhe Name"));
        Assert.assertEquals("Verify Price", SchuheCategoryPage.selectedProductInfo.get("Schuhe Price"), schuheProductPage.getProductPageInfo().get("Schuhe Price"));

    }
    @When("the user add can a product to the cart")
    public void the_user_add_can_a_product_to_the_cart() {
        SchuheProductPage schuheProductPage = new SchuheProductPage();

        schuheProductPage.addCartBtn.click();
        Assert.assertFalse(schuheProductPage.itemAmount.getText().contentEquals("0"));

    }

    @When("the user navigates login page")
    public void the_user_navigates_page() {
        SchuheProductPage schuheProductPage = new SchuheProductPage();
        schuheProductPage.logInBtn.click();
        BrowserUtils.waitFor(1);

        String expectedUrl = "https://www.fashionette.de/login";
        String actualUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals("Verify Url", expectedUrl,actualUrl );

    }

    @When("the user should be able to login with valid credentials")
    public void the_user_should_be_able_to_login_with_valid_credentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        String expectedUrl = "https://www.fashionette.de/account/customer";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals("Verify Url", expectedUrl,actualUrl);

    }

    @When("the user navigates cart page")
    public void the_user_navigates() {
       AccountPage accountPage = new AccountPage();

       accountPage.cartBtn.click();
       BrowserUtils.waitFor(1);

       String expectedUrl = "https://www.fashionette.de/cart";
       String actualUrl = Driver.get().getCurrentUrl();
       Assert.assertEquals("Verify Url", expectedUrl,actualUrl);

    }

    @Then("the added_product should be correctly on page")
    public void the_added_product_should_be_in_list() {
        SchuheProductPage schuheProductPage = new SchuheProductPage();
        CartPage cartPage = new CartPage();
        cartPage.infoSchuheInCartEntry();

        String expectedName = schuheProductPage.getProductPageInfo().get("Schuhe Name");
        String actualName = cartPage.getProductInCart().get("Name");
        Assert.assertTrue("Verify Names", expectedName.equalsIgnoreCase(actualName));

        String expectedType = schuheProductPage.getProductPageInfo().get("Product Type");
        String actualType = cartPage.getProductInCart().get("Product Type");
        Assert.assertTrue("Verify Type", expectedType.equalsIgnoreCase(actualType));

        String expectedSize = schuheProductPage.getProductPageInfo().get("Size");
        String actualSize = cartPage.getProductInCart().get("Size");
        Assert.assertTrue("Verify Size", actualSize.contains(expectedSize));

        String expectedPrice = schuheProductPage.getProductPageInfo().get("Schuhe Price").toString();
        String actualPrice = cartPage.getProductInCart().get("Price").toString();
        Assert.assertEquals("Verify Price", expectedPrice, actualPrice);


    }
}
