package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TextUtility {

    /**
     * Extracts the text of all elements matching the specified locator.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the elements.
     * @return A list of text values of all matching elements.
     */
    public List<String> getTextOfAllElements(WebDriver driver, By locator) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> texts = new ArrayList<>();
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
    }
    /**
     * Waits for the specified text to be present in an element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param text The text to wait for in the element.
     * @param timeout The time in seconds to wait.
     * @return true if the text is present within the timeout; false otherwise.
     */
    public boolean waitForTextToBePresentInElement(WebDriver driver, By locator, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    /**
     * Retrieves text from an element after waiting for visibility.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param timeout The maximum wait time in seconds.
     * @return The text content of the element.
     */
    public String getElementTextWithTimeout(WebDriver driver, By locator, int timeout) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }
}
