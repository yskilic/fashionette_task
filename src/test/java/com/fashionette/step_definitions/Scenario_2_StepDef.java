package com.fashionette.step_definitions;

import com.fashionette.pages.AccountPage;
import com.fashionette.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Scenario_2_StepDef {

    @When("the user modify name {string} and lastname {string}")
    public void the_user_modify_name_and_lastname(String firstName, String lastName) {

        AccountPage accountPage = new AccountPage();
        accountPage.personelInfoUpdate(firstName, lastName);
        accountPage.firstMessage();
        BrowserUtils.waitFor(3);

    }

    @Then("Changes should be correctly saved")
    public void changes_should_be_correctly_saved() {
        AccountPage accountPage = new AccountPage();
        String [] arrInfo = accountPage.personelInfoCheck();

        String expectedFirstName = "John";
        String actualFirstName = arrInfo[1].toString();
        Assert.assertEquals("Verify First Name", expectedFirstName,actualFirstName);

        String expectedLastName = "Smith";
        String actualLastName = arrInfo[2].toString();
        Assert.assertEquals("Verify Last Name", expectedLastName,actualLastName);


    }
}
