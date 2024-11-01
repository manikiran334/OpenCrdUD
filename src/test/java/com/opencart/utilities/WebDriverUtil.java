package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;
import java.time.Duration;

/**
 * Utility class for performing common WebDriver actions.
 */
public class WebDriverUtil {

    private WebDriver driver; // WebDriver instance

    // Constructor to initialize the WebDriver
    public WebDriverUtil(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on an element specified by the given locator.
     *
     * @param locator The By locator used to find the element.
     */
    public void clickElement(By locator) {
        try {
            // Wait until the element is clickable
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(locator));

            // Click the element
            driver.findElement(locator).click();
        } catch (StaleElementReferenceException ex) {
            System.out.println("Stale Element Reference Exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An unexpected exception occurred while clicking: " + ex.getMessage());
        }
    }

    /**
     * Sets the text in an input field specified by the given locator.
     *
     * @param locator The By locator used to find the input field.
     * @param text    The text to set in the input field.
     */
    public void setText(By locator, String text) {
        try {
            // Wait until the element is visible and can be interacted with
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            // Find the input field and clear it before setting new text
            WebElement element = driver.findElement(locator);
            element.clear(); // Clear existing text
            element.sendKeys(text); // Set the new text
        } catch (StaleElementReferenceException ex) {
            System.out.println("Stale Element Reference Exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An unexpected exception occurred while setting text: " + ex.getMessage());
        }
    }
}
