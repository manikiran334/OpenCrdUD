package com.opencart.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class URLUtility {

    /**
     * Waits until the URL contains the specified substring.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param urlFraction The substring expected to be part of the URL.
     * @param timeout The timeout in seconds to wait for the URL to contain the substring.
     * @return true if the URL contains the substring; false if the timeout occurs first.
     */
    public boolean waitForURLContains(WebDriver driver, String urlFraction, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlContains(urlFraction));
    }
    /**
     * Verifies if the current URL matches the expected URL.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param expectedUrl The expected URL to match.
     * @return true if the current URL matches the expected URL; false otherwise.
     */
    public boolean verifyURLMatches(WebDriver driver, String expectedUrl) {
        return driver.getCurrentUrl().equals(expectedUrl);
    }/**
     * Checks if the current URL contains the specified substring.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param expectedSubstring The substring expected to be part of the URL.
     * @return true if the current URL contains the substring; false otherwise.
     */
    public boolean isURLContains(WebDriver driver, String expectedSubstring) {
        return driver.getCurrentUrl().contains(expectedSubstring);
    }
}
