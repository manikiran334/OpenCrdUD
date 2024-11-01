package com.opencart.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Date;

public class TimeUtility {

    /**
     * Gets the current time in seconds since the Unix epoch (January 1, 1970).
     *
     * @return The current time in seconds as an integer.
     */
    public static int getCurrentTimeInSeconds() {
        long currentDateMS = new Date().getTime();  // Get current time in milliseconds
        int seconds = (int) (currentDateMS / 1000);  // Convert milliseconds to seconds
        return seconds;
    }
    /**
     * Gets the current system time in seconds since the start of the current hour.
     *
     * @return The current time in seconds (0 to 3599).
     */
    public static int getCurrentTime() {
        long currentDateMS = new Date().getTime(); // Get current time in milliseconds
        return (int) ((currentDateMS / 1000) % 3600); // Convert to seconds and get remainder of an hour
    }
    /**
     * Closes all open windows except the parent window.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @return true if only the parent window remains open; false otherwise.
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    public static boolean closeAllOtherWindows(WebDriver driver) throws InterruptedException {
        // Store the handle of the parent window
        String parentWindowHandle = driver.getWindowHandle();
        // Get all window handles
        java.util.Set<String> allWindowHandles = driver.getWindowHandles();

        // Loop through all window handles
        for (String currentWindowHandle : allWindowHandles) {
            // Close any window that is not the parent
            if (!currentWindowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(currentWindowHandle); // Switch to the window
                driver.close(); // Close the window
                Thread.sleep(2000); // Sleep for 2 seconds (optional)
            }
        }

        // Switch back to the parent window
        driver.switchTo().window(parentWindowHandle);

        // Check if only the parent window remains open
        return driver.getWindowHandles().size() == 1;
    }
}
