package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utility.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;

    public void setup() {

        ConfigReader config = new ConfigReader();

        String browser = config.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            System.out.println("Launching Edge Browser");

            System.setProperty(
                "webdriver.edge.driver",
                "driver/msedgedriver.exe"
            );

            driver = new EdgeDriver();
        }else {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
        .implicitlyWait(
        Duration.ofSeconds(2));
        
        driver.manage().deleteAllCookies();

       

        driver.get(config.getUrl());
    }

    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}