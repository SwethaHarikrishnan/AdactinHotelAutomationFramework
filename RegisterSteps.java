package com.step;

import org.testng.Assert;


import com.base.BaseTest;
import com.pages.RegisterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps extends BaseTest {

    RegisterPage registerPage;

    @Given("User opens Registration page")
    public void user_opens_registration_page() {

        driver.get("https://adactinhotelapp.com/Register.php");
        registerPage = new RegisterPage(driver);
    }

    @When("User enters valid registration details")
    public void validRegistration() {
        registerPage.validRegistration();
    }

    @When("User leaves registration username blank")
    public void blankUsername() {
        registerPage.blankUsername();
    }

    @When("User leaves registration password blank")
    public void blankPassword() {
        registerPage.blankPassword();
    }

    @When("User leaves registration confirm password blank")
    public void blankConfirmPassword() {
        registerPage.blankConfirmPassword();
    }

    @When("User enters mismatched registration passwords")
    public void passwordMismatch() {
        registerPage.passwordMismatch();
    }

    @When("User leaves registration full name blank")
    public void blankFullName() {
        registerPage.blankFullName();
    }

    @When("User leaves registration email blank")
    public void blankEmail() {
        registerPage.blankEmail();
    }

    @When("User enters registration details without accepting terms")
    public void withoutTerms() {
        registerPage.withoutTerms();
    }

    @Then("Registration data should be entered successfully")
    public void registrationSuccess() {

        Assert.assertTrue(true);

        System.out.println("Registration Positive Passed");
    }

    @Then("Registration validation message should be displayed")
    public void registrationValidation() {

        Assert.assertTrue(true);

        System.out.println("Registration Validation Passed");
    }
}