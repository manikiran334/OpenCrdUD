package com.opencart.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserFactory {
    private static final Logger logger = Logger.getLogger(BrowserFactory.class.getName());

    /**
     * Starts the specified browser and navigates to the given URL.
     *
     * @param driver The WebDriver instance.
     * @param browserName The name of the browser to start (Chrome, Firefox, or IE).
     * @param appUrl The URL of the application to navigate to.
     * @return The initialized WebDriver instance.
     */
    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl) {
        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*"); // Allowing remote origins
                driver = new ChromeDriver(chromeOptions);
                break;

            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe"); // Correct property for Firefox
                driver = new FirefoxDriver();
                break;

            case "IE":
                System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe"); // Correct property for IE
                driver = new InternetExplorerDriver();
                break;

            default:
                logger.log(Level.SEVERE, "Browser not supported: " + browserName);
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        driver.manage().window().maximize(); // Maximize the browser window
        driver.get(appUrl); // Navigate to the specified URL
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Set implicit wait
        driver.manage().deleteAllCookies(); // Clear cookies for a fresh session

        logger.info("Started " + browserName + " and navigated to " + appUrl);
        return driver; // Return the initialized WebDriver instance
    }

    /**
     * Quits the WebDriver session.
     *
     * @param driver The WebDriver instance to quit.
     */
    public static void quitBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit(); // Close the browser and clean up
            logger.info("Browser closed successfully.");
        }
    }
    /**
     * Launches a WebDriver instance in incognito mode.
     *
     * @return A WebDriver instance with incognito mode enabled.
     */
    public static WebDriver launchIncognitoMode() {
        // Set up Chrome options for incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // Initialize ChromeDriver with the specified options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
