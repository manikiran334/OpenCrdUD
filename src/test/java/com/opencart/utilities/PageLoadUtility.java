package com.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageLoadUtility {

    /**
     * Waits for the page to completely load.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param timeoutSeconds The maximum time to wait for the page to load (in seconds).
     */
    public void waitForPageToLoad(WebDriver driver, int timeoutSeconds) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < timeoutSeconds; i++) {
            try {
                if (js.executeScript("return document.readyState").toString().equals("complete")) {
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception while waiting for page load: " + e.getMessage());
            }
        }
    }
}
