package com.step;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.BaseTest;
import com.pages.BookHotelPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookHotelSteps extends BaseTest {

    BookHotelPage bookHotelPage;

    @When("User leaves first name blank")
    public void blankFirstName() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.blankFirstName();
    }

    @When("User leaves last name blank")
    public void blankLastName() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.blankLastName();
    }

    @When("User leaves billing address blank")
    public void blankAddress() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.blankAddress();
    }

    @When("User leaves credit card number blank")
    public void blankCard() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.blankCreditCard();
    }

    @When("User leaves credit card type blank")
    public void blankCardType() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.blankCreditCardType();
    }

    @When("User leaves expiry date blank")
    public void blankExpiry() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.blankExpiryDate();
    }

    @When("User leaves cvv blank")
    public void blankCVV() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.blankCVV();
    }

    @When("User enters invalid credit card number")
    public void invalidCard() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.invalidCreditCard();
    }

    @When("User enters invalid cvv")
    public void invalidCVV() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.invalidCVV();
    }

    @When("User enters valid booking details")
    public void validBooking() {

        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.validBooking();
    }

    @Then("Book hotel validation message should be displayed")
    public void validationMessage() {

        Assert.assertTrue(
                driver.getCurrentUrl().contains("BookHotel"));

        System.out.println("Validation Passed");
    }

    @Then("User should navigate to Booking Confirmation page")
    public void bookingConfirmation() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.urlContains(
                        "BookingConfirm"));

        String currentUrl =
                driver.getCurrentUrl();

        System.out.println(currentUrl);

        Assert.assertTrue(
                currentUrl.contains(
                        "BookingConfirm"));

        System.out.println(
                "Booking Successful");
    }
}