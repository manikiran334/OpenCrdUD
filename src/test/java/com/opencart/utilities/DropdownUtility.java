package com.opencart.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownUtility {

    /**
     * Selects an option from a dropdown by visible text.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to locate the dropdown element.
     * @param value The visible text of the option to be selected.
     */
    public static void selectDropdown(WebDriver driver, By locator, String value) {
        // Create a Select object and select an option by visible text
        new Select(driver.findElement(locator)).selectByVisibleText(value);
    }

    /**
     * Selects an option from a searchable dropdown by entering text.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to locate the searchable dropdown element.
     * @param value The text to enter into the dropdown for selection.
     */
    public static void selectSearchDropdown(WebDriver driver, By locator, String value) {
        WebElement dropdown = driver.findElement(locator);

        // Click to open the dropdown
        dropdown.click();

        // Enter the desired text into the dropdown
        dropdown.sendKeys(value);

        // Press TAB to confirm selection
        dropdown.sendKeys(Keys.TAB);
    }
    public static void dropDownSelectionByText(WebDriver driver, By dropDownID, String dropDownValue) {
        try {
            // Wait until the dropdown is clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Use Duration
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));

            // Find the dropdown element
            WebElement element = driver.findElement(dropDownID);
            Select dropDown = new Select(element); // Create Select object

            // Select the dropdown option by visible text
            dropDown.selectByVisibleText(dropDownValue);
        } catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("Dropdown option not found: " + dropDownValue + ", " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An unexpected exception occurred: " + ex.getMessage());
        }
    }
    /**
     * Selects an option from a dropdown by its value.
     *
     * @param driver         The WebDriver instance to interact with the browser.
     * @param dropDownID     The By locator used to find the dropdown element.
     * @param dropDownValue  The value to search for in the dropdown options.
     */
    public static void dropDownSelectionByValue(WebDriver driver, By dropDownID, String dropDownValue) {
        try {
            // Create a WebDriverWait instance with a timeout of 5 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Use Duration

            // Wait until the dropdown is clickable
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));

            // Find the dropdown element
            WebElement element = driver.findElement(dropDownID);
            Select dropDown = new Select(element); // Create Select object

            // Select the dropdown option by value
            dropDown.selectByValue(dropDownValue);
        } catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("Dropdown option not found: " + dropDownValue + ", " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An unexpected exception occurred: " + ex.getMessage());
        }
    }
    public static void dropDownSelectionByIndex(WebDriver driver, By dropDownID, int dropDownIndex) {
        try {
            // Create a WebDriverWait instance with a timeout of 5 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Use Duration

            // Wait until the dropdown is clickable
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));

            // Find the dropdown element
            WebElement element = driver.findElement(dropDownID);
            Select dropDown = new Select(element); // Create Select object

            // Select the dropdown option by index
            dropDown.selectByIndex(dropDownIndex);
        } catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("Dropdown index not found: " + dropDownIndex + ", " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An unexpected exception occurred: " + ex.getMessage());
        }
    }

    /**
     * Retrieves all options from a dropdown as a list of strings.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param dropdownLocator The By locator for locating the dropdown.
     * @return A list of strings containing the text of each dropdown option.
     */
    public List<String> getAllDropdownOptions(WebDriver driver, By dropdownLocator) {
        List<String> optionsText = new ArrayList<>();
        WebElement dropdown = driver.findElement(dropdownLocator);
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            optionsText.add(option.getText());
        }
        return optionsText;
    }
    /**
     * Selects an option in a dropdown menu by partially matching the visible text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param dropDownLocator The By locator for locating the dropdown element.
     * @param partialText The partial text to match for the option.
     */
    public void selectOptionByPartialText(WebDriver driver, By dropDownLocator, String partialText) {
        WebElement dropdownElement = driver.findElement(dropDownLocator);
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            if (option.getText().contains(partialText)) {
                option.click();
                break;
            }
        }
    }
    /**
     * Retrieves all options from a dropdown.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the dropdown element.
     * @return A list of option texts.
     */
    public List<String> getAllOptionsFromDropdown(WebDriver driver, By locator) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        return select.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    /**
     * Selects multiple options from a dropdown by visible text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the dropdown element.
     * @param options The list of visible text options to select.
     */
    public void selectMultipleOptionsByText(WebDriver driver, By locator, List<String> options) {
        Select dropdown = new Select(driver.findElement(locator));
        for (String option : options) {
            dropdown.selectByVisibleText(option);
        }
    }
    /**
     * Deselects all options from a multi-select dropdown.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param locator The By locator for locating the dropdown element.
     */
    public void deselectAllOptions(WebDriver driver, By locator) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectAll();
    }
}
