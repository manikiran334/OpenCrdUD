package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputUtility {

    /**
     * Clears any existing text in the input field and types the provided text.
     * Waits for the element to be visible before performing the actions.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The locator to identify the input field.
     * @param text The text to enter in the input field.
     */
    public void clearAndType(WebDriver driver, By locator, String text) {
        try {
            // Wait for the element to be visible with a 5-second timeout
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            // Clear any existing text and enter the new text
            element.clear();
            element.sendKeys(text);

            System.out.println("Text entered successfully: " + text);
        } catch (Exception ex) {
            System.out.println("Exception while typing text: " + ex.getMessage());
        }
    }
    /**
     * Clears the input field and sets new text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the input field.
     * @param text The text to set in the input field.
     */
    public void clearAndSetText(WebDriver driver, By locator, String text) {
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }
}
