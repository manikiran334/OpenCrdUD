package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectionUtility {

    /**
     * Checks if a checkbox or radio button is selected.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @return true if the element is selected; false otherwise.
     */
    public boolean isElementSelected(WebDriver driver, By locator) {
        return driver.findElement(locator).isSelected();
    }
}
