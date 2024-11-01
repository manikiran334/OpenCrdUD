package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextValidationUtility {

    /**
     * Checks if an element contains the expected text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for finding the element.
     * @param expectedText The text expected within the element.
     * @return true if the element contains the expected text; false otherwise.
     */
    public boolean elementContainsText(WebDriver driver, By locator, String expectedText) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getText().contains(expectedText);
        } catch (Exception e) {
            System.out.println("Exception while validating text: " + e.getMessage());
            return false;
        }
    }
}
