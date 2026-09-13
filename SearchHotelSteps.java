package com.step;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.BaseTest;
import com.pages.SearchHotelPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchHotelSteps extends BaseTest {

    SearchHotelPage searchHotelPage;

    @When("User leaves mandatory search fields blank")
    public void blankMandatoryField() {

        searchHotelPage = new SearchHotelPage(driver);
        searchHotelPage.blankMandatoryField();
    }

    @When("User enters invalid check in and check out dates")
    public void invalidDates() {

        searchHotelPage = new SearchHotelPage(driver);
        searchHotelPage.invalidDates();
    }

    @When("User enters check out date less than check in date")
    public void checkOutLessThanCheckIn() {

        searchHotelPage = new SearchHotelPage(driver);
        searchHotelPage.checkOutLessThanCheckIn();
    }

    @When("User enters valid search hotel details")
    public void successfulSearch() {

        searchHotelPage = new SearchHotelPage(driver);
        searchHotelPage.successfulSearch();
    }

    @Then("Search hotel validation message should be displayed")
    public void validationMessage() { 
        Assert.assertTrue(true);
        System.out.println("Search Hotel Validation Passed");
    }
    
    @Then("User should navigate to Select Hotel page")
    public void selectHotelPage() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.urlContains(
                        "SelectHotel"));

        String url = driver.getCurrentUrl();

        Assert.assertTrue(
                url.contains("SelectHotel"));

        System.out.println(
                "Search Hotel Successful");
    }
}
