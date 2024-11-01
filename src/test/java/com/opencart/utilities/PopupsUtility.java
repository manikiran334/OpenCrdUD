package com.opencart.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


    public class PopupsUtility {

        /**
         * Retrieves and accepts the popup alert message.
         *
         * @param driver The WebDriver instance to interact with the browser.
         * @return The message text from the popup alert, or null if no alert is present.
         */
        public static String getPopupMessage(final WebDriver driver) {
            String message = null;
            try {
                // Switch to the alert popup
                Alert alert = driver.switchTo().alert();
                // Retrieve the message text from the alert
                message = alert.getText();
                // Accept (close) the alert popup
                alert.accept();
            } catch (Exception e) {
                // If no alert is present, return null
                message = null;
            }
            System.out.println("Popup message: " + message);
            return message;
        }

        /**
         * Retrieves and dismisses (cancels) the popup alert message.
         *
         * @param driver The WebDriver instance to interact with the browser.
         * @return The message text from the popup alert, or null if no alert is present.
         */
        public static String cancelPopupMessageBox(final WebDriver driver) {
            String message = null;
            try {
                // Switch to the alert popup
                Alert alert = driver.switchTo().alert();
                // Retrieve the message text from the alert
                message = alert.getText();
                // Dismiss (close) the alert popup without accepting it
                alert.dismiss();
            } catch (Exception e) {
                // If no alert is present, return null
                message = null;
            }
            return message;
        }

        /**
         * Clears any existing text and enters a specified value into a text field.
         *
         * @param driver The WebDriver instance to interact with the browser.
         * @param locator The By locator used to locate the text field.
         * @param value The string value to be entered into the text field.
         */
        public static void insertText(WebDriver driver, By locator, String value) {
            // Locate the text field element
            WebElement field = driver.findElement(locator);
            // Clear any existing text in the field
            field.clear();
            // Enter the specified value into the text field
            field.sendKeys(value);
        }
    }



