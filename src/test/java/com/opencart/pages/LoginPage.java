package com.opencart.pages;

import com.opencart.utilities.ReadExcelFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Constructor to initialize the driver and PageFactory elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page elements using @FindBy
    @FindBy(xpath = "//input[@id='input-username']")
    WebElement uname;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    // Method to log in to the portal
    public void loginPortal(String username, String password) {
        uname.clear();  // Clear the username field
        pass.clear();   // Clear the password field
        uname.sendKeys(username);  // Enter the provided username
        pass.sendKeys(password);   // Enter the provided password
        loginBtn.click();  // Click the login button
    }
}
