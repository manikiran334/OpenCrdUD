package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TooltipUtility {

    /**
     * Retrieves the tooltip text from an element specified by the locator.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to find the element with the tooltip.
     * @return The tooltip text (title attribute) of the element, or null if not found.
     */
    public static String tooltipText(WebDriver driver, By locator) {
        // Get the title attribute of the specified element
        String tooltip = driver.findElement(locator).getAttribute("title");
        return tooltip;  // Return the tooltip text
    }
    /**
     * Gets the tooltip text (title attribute) of a specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @return The tooltip text of the element.
     */
    public String getTooltipText(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute("title");
    }
}
