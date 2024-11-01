package com.opencart.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ElementScreenshotUtility {

    /**
     * Captures a screenshot of a specific element.
     *
     * @param element The WebElement to capture in the screenshot.
     * @param filePath The file path to save the screenshot.
     */
    public void captureElementScreenshot(WebElement element, String filePath) {
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile, new File(filePath));
        } catch (IOException e) {
            System.out.println("Exception while capturing element screenshot: " + e.getMessage());
        }
    }
}
