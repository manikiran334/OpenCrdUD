package com.opencart.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    /**
     * Takes a screenshot of the current window.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param filePath The file path to save the screenshot.
     */
    public void takeScreenshot(WebDriver driver, String filePath) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
    /**
     * Takes a timestamped screenshot and saves it to the specified directory.
     *
     * @param driver     The WebDriver instance to control the browser.
     * @param directory  The directory where the screenshot will be saved.
     * @throws IOException If there is an issue saving the screenshot.
     */
    public void takeTimestampedScreenshot(WebDriver driver, String directory) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = directory + "/screenshot_" + timestamp + ".png";
        takeScreenshot(driver, filePath);
    }
}
