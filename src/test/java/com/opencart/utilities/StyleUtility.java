package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StyleUtility {

    /**
     * Gets a specific CSS property value of an element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param cssProperty The CSS property to retrieve.
     * @return The value of the specified CSS property.
     */
    public String getElementCssValue(WebDriver driver, By locator, String cssProperty) {
        WebElement element = driver.findElement(locator);
        return element.getCssValue(cssProperty);
    }
}
