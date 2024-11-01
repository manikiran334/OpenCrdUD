package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerPage {
    WebDriver driver;

    // Constructor
    public CustomerPage(WebDriver driver) {
        this.driver = driver; // Initialize driver
    }

    // Method to interact with elements
    public void navigateToCustomers() {
        WebElement customerbtn = driver.findElement(By.xpath("//li[@id='menu-customer']"));
        WebElement customersbtn = driver.findElement(By.linkText("Customers"));
        customerbtn.click();
        customersbtn.click();
    }
}
