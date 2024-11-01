package com.opencart.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WindowSizeUtility {

    /**
     * Sets the browser window size.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param width The desired width of the browser window.
     * @param height The desired height of the browser window.
     */
    public void setWindowSize(WebDriver driver, int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }
}
