package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadingFileUtility {

    /**
     * Uploads a file to a specified file input element.
     *
     * @param driver The WebDriver instance to interact with the browser.
     * @param locator The By locator used to find the file input element.
     * @param path The full path of the file to upload.
     */

    public void uploadFile(WebDriver driver, By locator, String filePath) {
        try {
            driver.findElement(locator).sendKeys(filePath);
            System.out.println("File uploaded successfully.");
        } catch (Exception e) {
            System.out.println("Exception while uploading file: " + e.getMessage());
        }
    }
}
