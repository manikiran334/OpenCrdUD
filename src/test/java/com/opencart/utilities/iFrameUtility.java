package com.opencart.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class iFrameUtility {

    /**
     * Switches to an iframe using its index.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param index The index of the iframe to switch to.
     */
    public void selectIFrameByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    /**
     * Switches to an iframe using its name or ID.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param name The name or ID of the iframe to switch to.
     */
    public void selectIFrameByName(WebDriver driver, String name) {
        driver.switchTo().frame(name);
    }

    /**
     * Switches to an iframe using a WebElement reference.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param element The WebElement of the iframe to switch to.
     */
    public void selectIFrameByElement(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }
}
