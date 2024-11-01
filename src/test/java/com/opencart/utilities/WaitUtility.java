package com.opencart.utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

public class WaitUtility {

    /**
     * Waits for a specified element to be visible on the page.
     * This method ignores StaleElementReferenceException, making it ideal for dynamic pages.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to find the element.
     * @param waitTime The maximum time to wait for the element to be visible (in seconds).
     * @return true if the element becomes visible within the wait time; false otherwise.
     */
    public static boolean waitForElementToBeVisible(WebDriver driver, By locator, int waitTime) {
        try {
            // Use Duration.ofSeconds to specify the wait time
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;  // Element is visible
        } catch (TimeoutException e) {
            System.out.println("Timeout: Element not visible within " + waitTime + " seconds.");
            return false;  // Element is not visible within the wait time
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for element: " + e.getMessage());
            return false;  // General failure in finding the element
        }
    }
    /**
     * Waits until the specified element is no longer visible on the page.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param timeout The time to wait for the element to disappear.
     * @return true if the element disappears; false if the timeout occurs first.
     */
    public boolean waitForElementToDisappear(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    /**
     * Waits until the page title contains the specified text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param titleFragment The text that should be present in the title.
     * @param timeout The timeout in seconds.
     * @return true if the title contains the text; false if the timeout occurs first.
     */
    public boolean waitForTitleContains(WebDriver driver, String titleFragment, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.titleContains(titleFragment));
    }
    /**
     * Waits for the URL to change from the specified initial URL.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param initialURL The initial URL before the expected change.
     * @param timeout The timeout in seconds.
     * @return true if the URL changes; false if the timeout occurs first.
     */
    public boolean waitForURLToChange(WebDriver driver, String initialURL, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialURL)));
    }
    /**
     * Waits until the specified element is no longer visible.
     *
     * @param driver  The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param timeout The timeout in seconds.
     */
    public void waitForElementToBeHidden(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
