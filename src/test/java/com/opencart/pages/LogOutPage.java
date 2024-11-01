package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    WebDriver driver;

    // Constructor to initialize driver and PageFactory elements
    public LogOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Finding the logout button
    @FindBy(xpath = "//input[@id='nav-logout']")
    WebElement logout;

    // Method to click the logout button
    public void logout() {
        logout.click();
    }
}
