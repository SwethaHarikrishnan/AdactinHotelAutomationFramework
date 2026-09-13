package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/config.properties");

            prop = new Properties();

            prop.load(fis);

        } catch (FileNotFoundException e) {

            System.out.println("Config file not found");
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Error reading config file");
            e.printStackTrace();
        }
    }   

    public String getBrowser() {

        return prop.getProperty("browser");
    }

    public String getUrl() {

        return prop.getProperty("url");
    }
    public String getUsername() {

        return prop.getProperty("username");
    }

    public String getPassword() {

        return prop.getProperty("password");
    }

    public String getFullName() {

        return prop.getProperty("fullname");
    }

    public String getEmail() {

        return prop.getProperty("email");
    }
    
    public String getValidUsername() {
        return prop.getProperty("valid.username");
    }

    public String getValidPassword() {
        return prop.getProperty("valid.password");
    }

    public String getInvalidUsername() {
        return prop.getProperty("invalid.username");
    }

    public String getInvalidPassword() {
        return prop.getProperty("invalid.password");
    }
    public String getFirstName() {
        return prop.getProperty("first.name");
    }

    public String getLastName() {
        return prop.getProperty("last.name");
    }

    public String getAddress() {
        return prop.getProperty("address");
    }

    public String getCardNumber() {
        return prop.getProperty("card.number");
    }

    public String getInvalidCardNumber() {
        return prop.getProperty("invalid.card.number");
    }

    public String getCardType() {
        return prop.getProperty("card.type");
    }

    public String getCVV() {
        return prop.getProperty("cvv");
    }

    public String getInvalidCVV() {
        return prop.getProperty("invalid.cvv");
    }

    public String getLocation() {
        return prop.getProperty("location");
    }

    public String getRoomType() {
        return prop.getProperty("room.type");
    }

    public String getRoomCount() {
        return prop.getProperty("room.count");
    }

    public String getAdults() {
        return prop.getProperty("adults");
    }

    public String getChildren() {
        return prop.getProperty("children");
    }
    public String getCardExpMonth() {
        return prop.getProperty("card.exp.month");
    }

    public String getCardExpYear() {
        return prop.getProperty("card.exp.year");
    }
    
}