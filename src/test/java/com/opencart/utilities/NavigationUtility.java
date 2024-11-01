package com.opencart.utilities;

import org.openqa.selenium.WebDriver;

public class NavigationUtility {

    /**
     * Navigates to a specified URL if it is valid.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param url The URL to navigate to.
     */
    public void navigateToUrl(WebDriver driver, String url) {
        try {
            if (url != null && !url.isEmpty()) {
                driver.navigate().to(url);
                System.out.println("Navigated to: " + url);
            } else {
                System.out.println("Invalid URL: " + url);
            }
        } catch (Exception e) {
            System.out.println("Exception while navigating to URL: " + e.getMessage());
        }
    }

    /**
     * Navigates back to the previous page.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }

    /**
     * Navigates forward to the next page.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }
    /**
     * Retrieves the current URL of the page.
     *
     * @param driver The WebDriver instance to control the browser.
     * @return The current URL as a String.
     */
    public String getCurrentPageURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    /**
     * Retrieves the current page title.
     *
     * @param driver The WebDriver instance to control the browser.
     * @return The title of the current page.
     */
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

}
