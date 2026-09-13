package com.utility;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    public static void waitForElement(WebDriver driver,
                                      WebElement element) {

        try {
            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(5));

            wait.until(
                    ExpectedConditions.visibilityOf(element));

        } catch (TimeoutException e) {
            System.out.println("Timeout: Element not visible");
        } catch (ElementNotInteractableException e) {
            System.out.println("Element is not interactable");
        }
    }

    public static void waitForUrl(WebDriver driver,
                                  String urlPart) {

        try {
            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(5));

            wait.until(
                    ExpectedConditions.urlContains(urlPart));

        } catch (TimeoutException e) {
            System.out.println("Timeout: URL not loaded");
        }
    }
}