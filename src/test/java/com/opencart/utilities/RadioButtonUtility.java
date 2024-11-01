package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonUtility {

    /**
     * Selects a radio button based on the specified value.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to locate the radio button elements.
     * @param value The specific value attribute of the radio button to be selected.
     */
    public static void selectRadioButton(WebDriver driver, By locator, String value) {
        // Locate all radio buttons matching the provided locator
        List<WebElement> radioButtons = driver.findElements(locator);

        // Iterate through each radio button element
        for (WebElement element : radioButtons) {
            // Check if the radio button's value attribute matches the specified value
            if (element.getAttribute("value").equalsIgnoreCase(value)) {
                // Click the radio button if there's a match
                element.click();
                break;  // Exit the loop once the desired radio button is selected
            }
        }
    }
    /**
     * Selects a radio button by its value.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param radioButtonName The name attribute of the radio buttons group.
     * @param value The value attribute of the radio button to select.
     */
    public void selectRadioButtonByValue(WebDriver driver, String radioButtonName, String value) {
        try {
            By locator = By.xpath("//input[@type='radio' and @name='" + radioButtonName + "' and @value='" + value + "']");
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.out.println("Exception while selecting radio button: " + e.getMessage());
        }
    }

}
