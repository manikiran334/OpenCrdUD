package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {

    /**
     * Clicks on an element using JavaScript.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param element The WebElement to be clicked.
     */
    public void jsClick(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("Exception while performing JavaScript click: " + e.getMessage());
        }
    }
    /**
     * Clicks on a hidden or non-interactive element using JavaScript.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param element The WebElement to click.
     */
    public void clickElementUsingJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    /**
     * Executes a custom JavaScript snippet.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param script The JavaScript code to execute.
     * @return The result of the script execution, if any.
     */
    public Object executeJavaScript(WebDriver driver, String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script);
    }
    /**
     * Clicks an element using JavaScript.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     */
    public void clickElementUsingJavaScript(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    /**
     * Scrolls to a specific element using JavaScript.
     *
     * @param driver  The WebDriver instance to control the browser.
     * @param element The element to scroll to.
     */
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
