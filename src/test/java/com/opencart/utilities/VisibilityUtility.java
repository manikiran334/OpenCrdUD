package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class VisibilityUtility {

    /**
     * Waits until an element is no longer visible on the page.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for finding the element.
     * @param timeoutSeconds The maximum time to wait for the element to become invisible (in seconds).
     * @return true if the element becomes invisible; false if the timeout is reached first.
     */
    public boolean waitUntilElementIsInvisible(WebDriver driver, By locator, int timeoutSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
