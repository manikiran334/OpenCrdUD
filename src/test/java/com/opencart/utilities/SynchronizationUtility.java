package com.opencart.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationUtility {

    /**
     * Waits for a specific WebElement to be visible and not stale.
     *
     * @param element The WebElement to wait for.
     * @param wait    The WebDriverWait instance used for synchronization.
     */
    public static void synchronization(WebElement element, WebDriverWait wait) {
        // Loop to retry waiting for the element
        for (int i = 0; i < 5; i++) {
            try {
                // Wait until the element is not stale
                wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
                // Wait until the element is visible
                wait.until(ExpectedConditions.visibilityOf(element));
                return;  // Exit the method if the element is visible
            } catch (Exception e) {
                // Optionally log the exception for debugging purposes
                System.out.println("Attempt " + (i + 1) + ": Element not yet visible. Retrying...");
            }
        }
        System.out.println("Failed to synchronize with the element after 5 attempts.");
    }
}
