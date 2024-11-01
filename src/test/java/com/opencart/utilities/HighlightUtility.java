package com.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightUtility {

    /**
     * Highlights a specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param element The WebElement to highlight.
     */
    public void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; background: yellow;');", element);
        try {
            Thread.sleep(1000); // Pause to see the highlight
        } catch (InterruptedException e) {
            System.out.println("Exception while highlighting element: " + e.getMessage());
        }
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
    }
}
