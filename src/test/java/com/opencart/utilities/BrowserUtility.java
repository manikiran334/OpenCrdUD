package com.opencart.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {

    /**
     * Clears all cookies and refreshes the current page.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void clearCookiesAndRefresh(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
    /**
     * Closes the current browser tab.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void closeCurrentTab(WebDriver driver) {
        driver.close();
    }
    /**
     * Initializes a WebDriver instance based on the specified browser type.
     *
     * @param browserType The type of browser (e.g., "chrome", "firefox").
     * @return The WebDriver instance.
     */
    public WebDriver initDriver(String browserType) {
        WebDriver driver = null;
        switch (browserType.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
        return driver;
    }
    /**
     * Closes the specified WebDriver instance.
     *
     * @param driver The WebDriver instance to close.
     */
    public void closeDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
