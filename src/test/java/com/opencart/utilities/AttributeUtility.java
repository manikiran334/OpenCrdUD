package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AttributeUtility {

    /**
     * Gets the value of an attribute from an element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for finding the element.
     * @param attribute The name of the attribute to retrieve.
     * @return The value of the attribute, or null if not found.
     */
    public String getAttributeValue(WebDriver driver, By locator, String attribute) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getAttribute(attribute);
        } catch (Exception e) {
            System.out.println("Exception while getting attribute: " + e.getMessage());
            return null;
        }
    }
}
