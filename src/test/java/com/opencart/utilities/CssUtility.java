package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssUtility {

    /**
     * Retrieves a CSS property value from an element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for finding the element.
     * @param property The CSS property to retrieve.
     * @return The value of the CSS property, or null if not found.
     */
    public String getCssProperty(WebDriver driver, By locator, String property) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getCssValue(property);
        } catch (Exception e) {
            System.out.println("Exception while getting CSS property: " + e.getMessage());
            return null;
        }
    }
}
