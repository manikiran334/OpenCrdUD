package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {

    /**
     * Drags an element from a source location and drops it to a target location.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param source The WebElement to drag.
     * @param target The WebElement where the source will be dropped.
     */
    public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        try {
            Actions action = new Actions(driver);
            action.dragAndDrop(source, target).build().perform();
            System.out.println("Drag and drop performed successfully");
        } catch (Exception e) {
            System.out.println("Exception while performing drag and drop: " + e.getMessage());
        }
    }
    /**
     * Performs a mouse hover action over the specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     */
    public void mouseHover(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }
    /**
     * Hovers over the specified element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the element.
     */
    public void hoverOverElement(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }
}
