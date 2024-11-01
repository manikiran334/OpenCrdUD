package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FrameUtility {

    /**
     * Switches to the default content from within any iframe.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public static void switchToDefaultFrame(WebDriver driver) {
        try {
            // Switches the WebDriver context back to the default content
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            // Logs the exception message to aid in debugging
            System.out.println("Exception occurred while switching to default frame: " + e.getMessage());
        }
    }
    /**
     * Switches to a specified iframe if it is present on the page.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to find the iframe element.
     * @param maxTimeout The maximum time to wait for the iframe to be present (in seconds).
     */
    public static void switchToFrame(WebDriver driver, By locator, int maxTimeout) {
        try {
            // Wait for the iframe to be present
            if (WaitUtility.waitForElementToBeVisible(driver, locator, maxTimeout)) {
                WebElement iframe = driver.findElement(locator);  // Locate the iframe as WebElement
                driver.switchTo().frame(iframe);  // Switch to iframe using WebElement
                System.out.println("Switched to frame successfully.");
            } else {
                System.out.println("Frame not found within the specified timeout.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while switching to frame: " + e.getMessage());
        }
    }
    public static void selectIFrameUsingIndex(WebDriver driver, int index) {
        try {
            // Switches to the iframe by its index
            driver.switchTo().frame(index);
            System.out.println("Switched to iframe with index: " + index);
        } catch (Exception e) {
            System.out.println("Failed to switch to iframe with index: " + index + ". Exception: " + e.getMessage());
        }
    }
    /**
     * Switches to an iframe by its name or ID on the page.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param nameOrId The name or ID of the iframe to switch to.
     */
    public static void selectIFrameUsingNameOrId(WebDriver driver, String nameOrId) {
        try {
            // Switch to the iframe by its name or ID
            driver.switchTo().frame(nameOrId);
            System.out.println("Switched to iframe with name or ID: " + nameOrId);
        } catch (Exception e) {
            System.out.println("Failed to switch to iframe with name or ID: " + nameOrId + ". Exception: " + e.getMessage());
        }
    }
    /**
     * Clears all text fields in a specified form.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param formLocator The By locator to locate the form.
     */
    public void clearAllTextFields(WebDriver driver, By formLocator) {
        WebElement form = driver.findElement(formLocator);
        List<WebElement> textFields = form.findElements(By.xpath(".//input[@type='text']"));
        for (WebElement textField : textFields) {
            textField.clear();
        }
    }
    /**
     * Switches to the specified frame by its locator.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the frame.
     */
    public void switchToFrame(WebDriver driver, By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }
    /**
     * Switches back to the default content from a frame.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

}
