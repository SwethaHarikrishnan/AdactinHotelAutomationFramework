package com.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utility.ConfigReader;

public class SearchHotelPage {

    WebDriver driver;
    ConfigReader config = new ConfigReader();

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "location")
    WebElement location;

    @FindBy(id = "hotels")
    WebElement hotels;

    @FindBy(id = "room_type")
    WebElement roomType;

    @FindBy(id = "room_nos")
    WebElement roomNos;

    @FindBy(id = "datepick_in")
    WebElement checkInDate;

    @FindBy(id = "datepick_out")
    WebElement checkOutDate;

    @FindBy(id = "adult_room")
    WebElement adultsPerRoom;

    @FindBy(id = "child_room")
    WebElement childrenPerRoom;

    @FindBy(id = "Submit")
    WebElement searchBtn;

    public void blankMandatoryField() {
        searchBtn.click();
    }

    public void invalidDates() {

        new Select(location)
                .selectByVisibleText(config.getLocation());

        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        checkInDate.clear();
        checkInDate.sendKeys(
                today.plusDays(5).format(formatter));

        checkOutDate.clear();
        checkOutDate.sendKeys(
                today.minusDays(1).format(formatter));

        searchBtn.click();
    }

    public void checkOutLessThanCheckIn() {

        new Select(location)
                .selectByVisibleText(config.getLocation());

        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        checkInDate.clear();
        checkInDate.sendKeys(
                today.plusDays(5).format(formatter));

        checkOutDate.clear();
        checkOutDate.sendKeys(
                today.plusDays(4).format(formatter));

        searchBtn.click();
    }

    public void successfulSearch() {

        new Select(location)
                .selectByVisibleText(config.getLocation());

        new Select(hotels).selectByIndex(1);

        new Select(roomType)
                .selectByVisibleText(config.getRoomType());

        new Select(roomNos)
                .selectByVisibleText(config.getRoomCount());

        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        checkInDate.clear();
        checkInDate.sendKeys(today.format(formatter));

        checkOutDate.clear();
        checkOutDate.sendKeys(
                today.plusDays(1).format(formatter));

        new Select(adultsPerRoom) 
                .selectByVisibleText(config.getAdults());

        new Select(childrenPerRoom)
                .selectByVisibleText(config.getChildren());

        searchBtn.click();
    }
}