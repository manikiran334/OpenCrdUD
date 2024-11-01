package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountUtility {

    /**
     * Counts the number of elements matching the specified locator.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the elements.
     * @return The number of elements matching the locator.
     */
    public int countElements(WebDriver driver, By locator) {
        return driver.findElements(locator).size();
    }
}
