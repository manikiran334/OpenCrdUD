package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementTextUtility {

    /**
     * Checks if an element's text contains the specified text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param expectedText The text to check within the element's text.
     * @return true if the text is found within the element's text; false otherwise.
     */
    public boolean doesElementContainText(WebDriver driver, By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        return element.getText().contains(expectedText);
    }
    /**
     * Retrieves the value of a specified CSS property from an element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param cssProperty The CSS property name.
     * @return The value of the specified CSS property.
     */
    public String getElementCssProperty(WebDriver driver, By locator, String cssProperty) {
        WebElement element = driver.findElement(locator);
        return element.getCssValue(cssProperty);
    }
}
