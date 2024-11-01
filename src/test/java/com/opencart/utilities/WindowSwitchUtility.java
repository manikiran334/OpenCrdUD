package com.opencart.utilities;

import org.openqa.selenium.WebDriver;

public class WindowSwitchUtility {

    /**
     * Switches to a window by its title.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param title The title of the window to switch to.
     * @return true if the switch was successful; false otherwise.
     */
    public boolean switchToWindowByTitle(WebDriver driver, String title) {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
