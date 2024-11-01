package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActionUtility {

    /**
     * Moves to a specified element and performs a click action if the element is clickable.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to find the element.
     * @param maxTimeout The maximum time to wait for the element to be clickable (in seconds).
     */
    public static void mouseClickActionMoveToElement(WebDriver driver, By locator, int maxTimeout) {
        try {
            // Wait until the element is clickable
            if (!WaitUtility.waitForElementToBeVisible(driver, locator, maxTimeout)) {
                System.out.println("Unable to locate the element within the specified timeout.");
            } else {
                WebElement element = driver.findElement(locator);

                // Initialize Actions class and move to element, then click
                Actions builder = new Actions(driver);
                builder.moveToElement(element).click().build().perform();

                System.out.println("Successfully located and clicked on the element!");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while attempting to click element: " + e.getMessage());
        }
    }
}
