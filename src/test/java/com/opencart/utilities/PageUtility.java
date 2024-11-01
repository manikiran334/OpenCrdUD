package com.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageUtility {

    /**
     * Refreshes the current page and retries if an exception occurs.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void refreshPage(WebDriver driver) {
        int attempts = 3; // Number of retry attempts
        for (int i = 0; i < attempts; i++) {
            try {
                driver.navigate().refresh();
                System.out.println("Page refreshed successfully");
                return;
            } catch (Exception e) {
                System.out.println("Attempt " + (i + 1) + " - Exception while refreshing the page: " + e.getMessage());
            }
        }
        System.out.println("Failed to refresh the page after " + attempts + " attempts");
    }
    /**
     * Gets the title of the current page.
     *
     * @param driver The WebDriver instance to control the browser.
     * @return The title of the page.
     */
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
    /**
     * Waits until the page title contains the specified substring.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param titleSubstring The substring to wait for in the title.
     * @param timeout The timeout in seconds to wait for the title.
     * @return true if the title contains the substring within the timeout; false otherwise.
     */
    public boolean waitForTitleContains(WebDriver driver, String titleSubstring, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.titleContains(titleSubstring));
    }

    /**
     * Verifies if the page title contains the expected text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param titleText The expected text in the title.
     * @return true if the title contains the text; false otherwise.
     */
    public boolean verifyPageTitleContains(WebDriver driver, String titleText) {
        return driver.getTitle().contains(titleText);
    }
    /**
     * Waits for the page to load completely.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void waitForPageLoad(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                if (js.executeScript("return document.readyState").toString().equals("complete")) {
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException while waiting for page load: " + e.getMessage());
            }
        }
    }
    /**
     * Gets the page source of the current page.
     *
     * @param driver The WebDriver instance to control the browser.
     * @return The page source as a String.
     */
    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }
}
