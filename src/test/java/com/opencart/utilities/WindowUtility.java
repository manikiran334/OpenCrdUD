package com.opencart.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtility {

    /**
     * Closes all windows except the parent window.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @return true if only the parent window remains open; false otherwise.
     * @throws InterruptedException if the thread is interrupted during sleep.
     */
    public static boolean closeAllOtherWindows(WebDriver driver) throws InterruptedException {
        // Get the handle of the parent window
        String parentWindow = driver.getWindowHandle();

        // Get all window handles
        java.util.Set<String> allWindowHandles = driver.getWindowHandles();

        // Iterate through all window handles
        for (String currentWindowHandle : allWindowHandles) {
            // If the current window is not the parent, close it
            if (!currentWindowHandle.equals(parentWindow)) {
                driver.switchTo().window(currentWindowHandle);
                driver.close();
                // Optional: Sleep to ensure the window closes before continuing
                Thread.sleep(2000);
            }
        }

        // Switch back to the parent window
        driver.switchTo().window(parentWindow);

        // Return true if only the parent window remains open
        return driver.getWindowHandles().size() == 1;
    }
    /**
     * Switches to a window by its title.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param title The title of the window to switch to.
     * @return true if successfully switched; false otherwise.
     */
    public boolean switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Closes the current window and switches back to the previous window.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void closeCurrentWindow(WebDriver driver) {
        String currentWindow = driver.getWindowHandle();
        driver.close();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    /**
     * Switches to a newly opened window.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void switchToNewWindow(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    /**
     * Switches back to the parent window.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void switchToParentWindow(WebDriver driver, String parentWindowHandle) {
        driver.switchTo().window(parentWindowHandle);
    }
    /**
     * Switches to the latest opened window or tab.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void switchToLatestWindow(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    /**
     * Sets the size of the browser window.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param width The desired width of the window.
     * @param height The desired height of the window.
     */
    public void setWindowSize(WebDriver driver, int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }
    /**
     * Resizes the browser window to the specified width and height.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param width The desired width of the window.
     * @param height The desired height of the window.
     */
    public void resizeWindow(WebDriver driver, int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }
    /**
     * Closes all other windows except the main window.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void closeOtherWindows(WebDriver driver) {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }
    /**
     * Closes all windows except the main window.
     *
     * @param driver The WebDriver instance.
     */
    public void closeAllExceptMainWindow(WebDriver driver) {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }

}
