package com.opencart.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtility {

    /**
     * Checks if an element is present on the page.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param by The By locator used to find the element.
     * @return true if the element is present; false otherwise.
     */
    private boolean isElementPresent(WebDriver driver, By by) {
        try {
            // Try to locate the element
            driver.findElement(by);
            return true;  // Element is found
        } catch (Exception e) {
            return false;  // Element not found or an exception occurred
        }
    }
    /**
     * Highlights a WebElement on the webpage by changing its background color and border.
     *
     * @param driver  The WebDriver instance to interact with the browser.
     * @param element The WebElement to highlight.
     */
    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Store the original style to restore later
        String originalStyle = element.getAttribute("style");

        // Highlight the element by changing its background color and border
        js.executeScript("arguments[0].setAttribute('style', 'background-color: yellow; border: 2px solid red;')", element);

        // Pause for a short duration to show the highlight
        try {
            Thread.sleep(1000); // Consider using WebDriverWait instead if applicable
        } catch (InterruptedException e) {
            // Handle the interruption
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }

        // Restore the original style of the element
        js.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }
    private int maxTimeout; // Set this to your desired timeout value

    /**
     * Retrieves the text from a specified WebElement.
     *
     * @param driver  The WebDriver instance to interact with the browser.
     * @param locator The By locator used to find the element.
     * @return The text from the element, or null if the element is not present.
     */
    public String getTextFromElement(WebDriver driver, By locator) {
        String text = null;
        try {
            // Check if the element is present before trying to get the text
            if (waitForElementToBePresentBool(driver, locator, maxTimeout)) {
                WebElement element = driver.findElement(locator);
                text = element.getText(); // Get the text from the element
                System.out.println("Element Text is: " + text);
            } else {
                System.out.println("Element not present!");
            }
        } catch (Exception ex) {
            // Log the exception message for better debugging
            System.out.println("Exception occurred: " + ex.getMessage());
        }
        return text; // Return the retrieved text or null if not found
    }

    /**
     * Placeholder for the method that checks if an element is present.
     * This should be implemented according to your existing utility methods.
     */
    public boolean waitForElementToBePresentBool(WebDriver driver, By locator, int waitTime) {
        // Implement this method based on your existing code
        return true; // Placeholder return value
    }
    /**
     * Gets text from an element if it is visible.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for finding the element.
     * @param timeoutSeconds The maximum time to wait for the element to be visible (in seconds).
     * @return The text of the element, or null if it is not visible.
     */
    public String getTextIfVisible(WebDriver driver, By locator, int timeoutSeconds) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        } catch (Exception e) {
            System.out.println("Exception while getting text: " + e.getMessage());
            return null;
        }
    }
    /**
     * Checks if an element's text matches the expected value.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param expectedText The expected text content of the element.
     * @return true if the element's text matches; false otherwise.
     */
    public boolean doesElementContainText(WebDriver driver, By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        return element.getText().contains(expectedText);
    }
    /**
     * Verifies if an element is visible.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @return true if the element is visible; false otherwise.
     */
    public boolean isElementVisible(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
    /**
     * Retrieves the value of a specified attribute from an element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param attribute The attribute name to retrieve.
     * @return The value of the attribute, or null if the element is not found.
     */
    public String getElementAttribute(WebDriver driver, By locator, String attribute) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getAttribute(attribute);
        } catch (Exception e) {
            System.out.println("Exception while getting attribute: " + e.getMessage());
            return null;
        }

    }
    /**
     * Waits for the specified element to be invisible.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param timeout The timeout in seconds to wait.
     */
    public void waitForElementToBeInvisible(WebDriver driver, By locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    /**
     * Retrieves the size of the specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @return An array containing width and height of the element.
     */
    public int[] getElementSize(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return new int[]{element.getSize().getWidth(), element.getSize().getHeight()};
    }
    /**
     * Retrieves the position of the specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @return An array containing x and y coordinates of the element.
     */
    public int[] getElementPosition(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return new int[]{element.getLocation().getX(), element.getLocation().getY()};
    }
    /**
     * Gets the location of the specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @return A Point object containing the x and y coordinates of the element.
     */
    public Point getElementLocation(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.getLocation();
    }
    /**
     * Waits until the specified attribute of an element has the specified value.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param attribute The attribute name to check.
     * @param expectedValue The expected value of the attribute.
     * @param timeout The maximum time to wait in seconds.
     * @return true if the attribute has the expected value; false otherwise.
     */
    public boolean waitForElementAttributeValue(WebDriver driver, By locator, String attribute, String expectedValue, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(driver1 -> {
                WebElement element = driver.findElement(locator);
                return expectedValue.equals(element.getAttribute(attribute));
            });
        } catch (Exception e) {
            System.out.println("Exception while waiting for element attribute value: " + e.getMessage());
            return false;
        }
    }
    /**
     * Gets the count of elements matching the specified locator.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the elements.
     * @return The count of elements matching the locator.
     */
    public int getElementCount(WebDriver driver, By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.size();
    }
    /**
     * Waits for the specified text to be present in the element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @param text The text to wait for.
     * @param timeout The timeout in seconds to wait for the text to be present.
     */
    public void waitForTextToBePresent(WebDriver driver, By locator, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    /**
     * Retrieves the tag name of the specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     * @return The tag name of the element.
     */
    public String getElementTagName(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.getTagName();
    }


}
