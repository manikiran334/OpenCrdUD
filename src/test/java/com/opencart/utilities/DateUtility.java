package com.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    /**
     * Sets a date in a date picker input field.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param element The WebElement representing the date picker input.
     * @param date The date string to set, e.g., "2024-10-31".
     */
    public void setDate(WebDriver driver, WebElement element, String date) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", element, date);
    }
    /**
     * Returns the current date formatted as a string.
     *
     * @param format The desired date format, e.g., "yyyy-MM-dd".
     * @return The current date as a string in the specified format.
     */
    public String getCurrentDateAsString(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

}
