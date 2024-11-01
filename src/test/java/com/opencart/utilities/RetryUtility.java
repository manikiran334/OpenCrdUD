package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetryUtility {

    /**
     * Retries clicking an element up to a specified number of times.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for finding the element.
     * @param attempts The maximum number of click attempts.
     * @return true if clicked successfully; false otherwise.
     */
    public boolean retryClick(WebDriver driver, By locator, int attempts) {
        for (int i = 0; i < attempts; i++) {
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                return true;
            } catch (Exception e) {
                System.out.println("Retrying click (" + (i + 1) + "/" + attempts + "): " + e.getMessage());
            }
        }
        return false;
    }
}
