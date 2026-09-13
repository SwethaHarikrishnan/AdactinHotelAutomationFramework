package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.ConfigReader;

public class LoginPage {

    WebDriver driver;

    ConfigReader config = new ConfigReader();

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBtn;

    public void validLogin() {

        username.clear();
        password.clear();

        username.sendKeys(
                config.getValidUsername());

        password.sendKeys(
                config.getValidPassword());

        loginBtn.click();
    }

    public void invalidUsername() {

        username.clear();
        password.clear();

        username.sendKeys(
                config.getInvalidUsername());

        password.sendKeys(
                config.getValidPassword());

        loginBtn.click();
    }

    public void invalidPassword() {

        username.clear();
        password.clear();

        username.sendKeys(
                config.getValidUsername());

        password.sendKeys(
                config.getInvalidPassword());

        loginBtn.click();
    }

    public void invalidCredentials() {

        username.clear();
        password.clear();

        username.sendKeys(
                config.getInvalidUsername());

        password.sendKeys(
                config.getInvalidPassword());

        loginBtn.click();
    }

    public void blankUsername() {

        username.clear();
        password.clear();

        password.sendKeys(
                config.getValidPassword());

        loginBtn.click();
    }

    public void blankPassword() {

        username.clear();
        password.clear();

        username.sendKeys(
                config.getValidUsername());

        loginBtn.click();
    }

    public void blankCredentials() {

        username.clear();
        password.clear();

        loginBtn.click();
    }
}