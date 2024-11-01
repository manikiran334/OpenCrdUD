package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementInteractionUtility {

    private int maxTimeout; // Define maxTimeout based on your requirements

    /**
     * Moves to a specified WebElement and performs a click action.
     *
     * @param driver       The WebDriver instance to interact with the browser.
     * @param attributeValue The By locator to find the element.
     */
    public void mouseClickActionMoveToElement(WebDriver driver, By attributeValue) {
        try {
            // Check if the element is clickable before performing the action
            if (waitForElementToBeClickableBool(driver, attributeValue, maxTimeout)) {
                WebElement element = driver.findElement(attributeValue);
                // Create an Actions object to perform the move and click
                Actions builder = new Actions(driver);
                builder.moveToElement(element).click().perform(); // Removed build() as it's not needed here
                System.out.println("Able to locate and click the element!");
            } else {
                System.out.println("Not able to locate the element!");
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred: " + ex.getMessage());
        }
    }

    /**
     * Placeholder method for checking if an element is clickable.
     * This method should be implemented according to your existing utility methods.
     */
    public boolean waitForElementToBeClickableBool(WebDriver driver, By locator, int waitTime) {
        // Implement this method based on your existing code
        return true; // Placeholder return value
    }
}
