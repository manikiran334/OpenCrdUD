package com.opencart.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertUtility {

    /**
     * Waits for an alert to be present within a specified time.
     *
     * @param driver   The WebDriver instance to interact with the browser.
     * @param waitTime The maximum time to wait for the alert (in seconds).
     * @return true if the alert is present; false otherwise.
     */
    public boolean waitForAlertPresent(WebDriver driver, int waitTime) {
        try {
            // Create a WebDriverWait instance with the specified timeout duration
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            // Wait for the alert to be present
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.alertIsPresent());
            // If alert is present, switch to it
            driver.switchTo().alert();
            return true;  // Alert is present
        } catch (Exception e) {
            // Log the exception if needed
            System.out.println("No alert present within the wait time. Exception: " + e.getMessage());
            return false;  // Alert is not present or an error occurred
        }
    }
    public String handleAlert(WebDriver driver) {
        String alertText = "";
        try {
            // Wait for the alert to be present with a 5-second timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            // Switch to the alert, retrieve the text, and accept it
            alertText = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            System.out.println("Alert handled successfully. Alert text: " + alertText);
        } catch (Exception e) {
            System.out.println("No alert present: " + e.getMessage());
        }
        return alertText;
    }

    /**
     * Checks if an alert is present.
     *
     * @param driver The WebDriver instance to control the browser.
     * @return true if an alert is present; false otherwise.
     */
    public boolean isAlertPresent(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.getText();  // Access alert to confirm its presence.
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * Accepts an alert if present.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void acceptAlert(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present to accept: " + e.getMessage());
        }
    }

    /**
     * Dismisses an alert if present.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void dismissAlert(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            System.out.println("No alert present to dismiss: " + e.getMessage());
        }
    }


}
