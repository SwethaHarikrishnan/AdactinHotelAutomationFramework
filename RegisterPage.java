package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.ConfigReader;

public class RegisterPage {

    WebDriver driver;
    ConfigReader config = new ConfigReader();

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "re_password")
    WebElement confirmPassword;

    @FindBy(id = "full_name")
    WebElement fullName;

    @FindBy(id = "email_add")
    WebElement email;

    @FindBy(id = "tnc_box")
    WebElement terms;

    public void validRegistration() {

        username.sendKeys(config.getValidUsername());
        password.sendKeys(config.getValidPassword());
        confirmPassword.sendKeys(config.getValidPassword());
        fullName.sendKeys(config.getFullName());
        email.sendKeys(config.getEmail());

        terms.click();
    }

    public void blankUsername() {

        password.sendKeys(config.getValidPassword());
        confirmPassword.sendKeys(config.getValidPassword());
        fullName.sendKeys(config.getFullName());
        email.sendKeys(config.getEmail());

        terms.click();
    }

    public void blankPassword() {

        username.sendKeys(config.getValidUsername());
        fullName.sendKeys(config.getFullName());
        email.sendKeys(config.getEmail());

        terms.click();
    }

    public void blankConfirmPassword() {

        username.sendKeys(config.getValidUsername());
        password.sendKeys(config.getValidPassword());
        fullName.sendKeys(config.getFullName());
        email.sendKeys(config.getEmail());

        terms.click();
    }

    public void passwordMismatch() {

        username.sendKeys(config.getValidUsername());
        password.sendKeys(config.getValidPassword());
        confirmPassword.sendKeys(config.getInvalidPassword());
        fullName.sendKeys(config.getFullName());
        email.sendKeys(config.getEmail());

        terms.click();
    }

    public void blankFullName() {

        username.sendKeys(config.getValidUsername());
        password.sendKeys(config.getValidPassword());
        confirmPassword.sendKeys(config.getValidPassword());
        email.sendKeys(config.getEmail());

        terms.click();
    }

    public void blankEmail() {

        username.sendKeys(config.getValidUsername());
        password.sendKeys(config.getValidPassword());
        confirmPassword.sendKeys(config.getValidPassword());
        fullName.sendKeys(config.getFullName());

        terms.click();
    }

    public void withoutTerms() {

        username.sendKeys(config.getValidUsername());
        password.sendKeys(config.getValidPassword());
        confirmPassword.sendKeys(config.getValidPassword());
        fullName.sendKeys(config.getFullName());
        email.sendKeys(config.getEmail());
    }
}