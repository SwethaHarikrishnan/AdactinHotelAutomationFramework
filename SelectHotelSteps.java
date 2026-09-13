package com.step;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.base.BaseTest;
import com.pages.SelectHotelPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectHotelSteps extends BaseTest {

    SelectHotelPage selectHotelPage;

    @When("User clicks continue without selecting hotel")
    public void clickWithoutSelection() {

        selectHotelPage = new SelectHotelPage(driver);

        selectHotelPage.withoutSelection();
    }

    @When("User selects a hotel and clicks continue")
    public void selectHotel() {

        selectHotelPage = new SelectHotelPage(driver);

        selectHotelPage.selectHotel();
    }

    @Then("Select hotel validation message should be displayed")
    public void validationMessage() {

        Assert.assertTrue(
                driver.getCurrentUrl().contains("SelectHotel"));

        System.out.println("Select Hotel Validation Passed");
    }
   
    @Then("User should navigate to Book Hotel page")
    public void navigateToBookHotel() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.urlContains(
                        "BookHotel"));

        String url = driver.getCurrentUrl();

        Assert.assertTrue(
                url.contains("BookHotel"));

        System.out.println(
                "Book Hotel Page Opened");
    }
}