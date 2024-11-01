package com.opencart.pages;

import java.io.File;
import java.io.IOException;

import com.opencart.utilities.BrowserFactory;
import com.opencart.utilities.ConfigDataProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public ConfigDataProvider config = new ConfigDataProvider();

    /**
     * Sets up the test environment by initializing the WebDriver.
     */
    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
    }

    /**
     * Cleans up after the tests by quitting the WebDriver.
     */
    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    /**
     * Captures a screenshot of the current browser window.
     *
     * @param driver   The WebDriver instance.
     * @param testName The name of the test, used as the filename for the screenshot.
     * @throws IOException If an error occurs while saving the screenshot.
     */
    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File destDir = new File("./Screenshots");

        // Ensure the directory exists
        if (!destDir.exists()) {
            destDir.mkdir();
        }

        File dest = new File(destDir, testName + ".png");

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.err.println("Error while saving screenshot: " + e.getMessage());
        }
    }
}
