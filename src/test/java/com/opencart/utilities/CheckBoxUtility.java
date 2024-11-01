package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Arrays;

public class CheckBoxUtility {

    /**
     * Selects checkboxes based on the specified values.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to locate the checkbox elements.
     * @param value A comma-separated string of checkbox values to be selected.
     */
    public static void selectCheckboxes(WebDriver driver, By locator, String value) {
        // Locate all checkboxes matching the provided locator
        List<WebElement> checkboxes = driver.findElements(locator);

        // Split the comma-separated values and convert them into a list
        List<String> valuesToSelect = Arrays.asList(value.split(","));

        // Iterate through each value that needs to be selected
        for (String check : valuesToSelect) {
            // For each checkbox element, check if its value matches the desired value
            for (WebElement checkbox : checkboxes) {
                if (checkbox.getAttribute("value").equalsIgnoreCase(check.trim())) {
                    // If a match is found, select the checkbox
                    checkbox.click();
                    break;  // Exit the inner loop once a match is clicked
                }
            }
        }
    }
    /**
     * Checks if a checkbox is selected.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for finding the checkbox element.
     * @return true if the checkbox is selected; false otherwise.
     */
    public boolean isCheckboxSelected(WebDriver driver, By locator) {
        try {
            WebElement checkbox = driver.findElement(locator);
            return checkbox.isSelected();
        } catch (Exception e) {
            System.out.println("Exception while checking checkbox selection: " + e.getMessage());
            return false;
        }
    }
}
