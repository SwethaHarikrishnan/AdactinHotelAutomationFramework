package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utility.ConfigReader;

public class BookHotelPage {

    WebDriver driver;
    ConfigReader config = new ConfigReader();

    public BookHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "cc_num")
    WebElement creditCardNo;

    @FindBy(id = "cc_type")
    WebElement creditCardType;

    @FindBy(id = "cc_exp_month")
    WebElement expMonth;

    @FindBy(id = "cc_exp_year")
    WebElement expYear;

    @FindBy(id = "cc_cvv")
    WebElement cvv;

    @FindBy(id = "book_now")
    WebElement bookNow;

    private void selectCardDetails() {

        new Select(creditCardType)
                .selectByVisibleText(config.getCardType());

        new Select(expMonth)
        .selectByVisibleText(config.getCardExpMonth());

         new Select(expYear)
        .selectByVisibleText(config.getCardExpYear());
    }

    public void blankFirstName() {

        lastName.sendKeys(config.getLastName());
        address.sendKeys(config.getAddress());
        creditCardNo.sendKeys(config.getCardNumber());

        selectCardDetails();

        cvv.sendKeys(config.getCVV());

        bookNow.click();
    }

    public void blankLastName() {

        firstName.sendKeys(config.getFirstName());
        address.sendKeys(config.getAddress());
        creditCardNo.sendKeys(config.getCardNumber());

        selectCardDetails();

        cvv.sendKeys(config.getCVV());

        bookNow.click();
    }

    public void blankAddress() {

        firstName.sendKeys(config.getFirstName());
        lastName.sendKeys(config.getLastName());
        creditCardNo.sendKeys(config.getCardNumber());

        selectCardDetails();

        cvv.sendKeys(config.getCVV());

        bookNow.click();
    }

    public void blankCreditCard() {

        firstName.sendKeys(config.getFirstName());
        lastName.sendKeys(config.getLastName());
        address.sendKeys(config.getAddress());

        selectCardDetails();

        cvv.sendKeys(config.getCVV());

        bookNow.click();
    }

    public void blankCreditCardType() {

        firstName.sendKeys(config.getFirstName());
        lastName.sendKeys(config.getLastName());
        address.sendKeys(config.getAddress());

        creditCardNo.sendKeys(config.getCardNumber());

        new Select(expMonth)
        .selectByVisibleText(config.getCardExpMonth());

        new Select(expYear)
        .selectByVisibleText(config.getCardExpYear());

        cvv.sendKeys(config.getCVV());

        bookNow.click();
    }

    public void blankExpiryDate() {

        firstName.sendKeys(config.getFirstName());
        lastName.sendKeys(config.getLastName());
        address.sendKeys(config.getAddress());

        creditCardNo.sendKeys(config.getCardNumber());

        new Select(creditCardType)
                .selectByVisibleText(config.getCardType());

        cvv.sendKeys(config.getCVV());

        bookNow.click();
    }

    public void blankCVV() {

        firstName.sendKeys(config.getFirstName());
        lastName.sendKeys(config.getLastName());
        address.sendKeys(config.getAddress());

        creditCardNo.sendKeys(config.getCardNumber());

        selectCardDetails();

        bookNow.click();
    }

    public void invalidCreditCard() {

        firstName.sendKeys(config.getFirstName());
        lastName.sendKeys(config.getLastName());
        address.sendKeys(config.getAddress());

        creditCardNo.sendKeys(config.getInvalidCardNumber());

        selectCardDetails();

        cvv.sendKeys(config.getCVV());

        bookNow.click();
    }

    public void invalidCVV() {

        firstName.sendKeys(config.getFirstName());
        lastName.sendKeys(config.getLastName());
        address.sendKeys(config.getAddress());

        creditCardNo.sendKeys(config.getCardNumber());

        selectCardDetails();

        cvv.sendKeys(config.getInvalidCVV());

        bookNow.click();
    }

    public void validBooking() {

        firstName.clear();
        firstName.sendKeys(config.getFirstName());

        lastName.clear();
        lastName.sendKeys(config.getLastName());

        address.clear();
        address.sendKeys(config.getAddress());

        creditCardNo.clear();
        creditCardNo.sendKeys(config.getCardNumber());

        selectCardDetails();

        cvv.clear();
        cvv.sendKeys(config.getCVV());

        bookNow.click();
    }
}