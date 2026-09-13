package com.step;

import org.testng.Assert;

import com.base.BaseTest;
import com.pages.LogoutPage;

import io.cucumber.java.en.Then;

public class LogoutSteps extends BaseTest {

    @Then("User logs out successfully")
    public void userLogsOutSuccessfully() {

        LogoutPage logoutPage =
                new LogoutPage(driver);

        logoutPage.logout();

        Assert.assertTrue(
                driver.getPageSource()
                      .contains("You have successfully logged out"));

        System.out.println("Logout Successful");
    }
}