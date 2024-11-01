package com.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtility {

    /**
     * Scrolls the viewport to bring the specified element into view.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param element The WebElement to scroll to.
     */
    public void scrollToElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Scrolled to the element successfully.");
        } catch (Exception e) {
            System.out.println("Exception while scrolling to the element: " + e.getMessage());
        }
    }
    /**
     * Scrolls to the bottom of the page.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void scrollToBottom(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e) {
            System.out.println("Exception while scrolling to bottom: " + e.getMessage());
        }
    }
    /**
     * Scrolls the page by the specified number of pixels.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param pixels Number of pixels to scroll.
     */
    public void scrollByPixels(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ");");
    }
    /**
     * Scrolls horizontally to a specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param element The WebElement to scroll to.
     */
    public void scrollHorizontallyToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'center'});", element);
    }
    /**
     * Scrolls the view to the top of the page.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
}
