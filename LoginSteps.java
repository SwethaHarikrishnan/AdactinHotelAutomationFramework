package com.step;

import org.testng.Assert;
import com.base.BaseTest;
import com.pages.LoginPage;
import com.utility.ConfigReader;
import com.utility.WaitUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    ConfigReader config = new ConfigReader();

    @Given("User launches Adactin application")
    public void user_launches_adactin_application() {

        driver.get(
                config.getUrl());

        loginPage = new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {

        loginPage.validLogin();
    }
    @When("User enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {

        loginPage.invalidUsername();
    }

    @When("User enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {

        loginPage.invalidPassword();
    }

    @When("User enters invalid username and invalid password")
    public void user_enters_invalid_username_and_invalid_password() {

        loginPage.invalidCredentials();
    }

    @When("User leaves username blank")
    public void user_leaves_username_blank() {

        loginPage.blankUsername();
    }

    @When("User leaves password blank")
    public void user_leaves_password_blank() {

        loginPage.blankPassword();
    }

    @When("User leaves username and password blank")
    public void user_leaves_username_and_password_blank() {

        loginPage.blankCredentials();
    }

    @Then("User should navigate to Search Hotel page")
    public void user_should_navigate_to_search_hotel_page() {

        WaitUtil.waitForUrl(
                driver,
                "SearchHotel");

        Assert.assertTrue(
                driver.getCurrentUrl()
                .contains("SearchHotel"));
    }

    @Then("Login error message should be displayed")
    public void login_error_message_should_be_displayed() {

        Assert.assertFalse(
                driver.getCurrentUrl()
                .contains("SearchHotel"));
    }
}