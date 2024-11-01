package com.opencart.testcases;

import com.opencart.pages.BaseTest;
import com.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCaseDemo extends BaseTest {

    @Test(priority = 1)
    public void verifyCustomerNavigation() {
        // Step 1: Perform login
        LoginPage lp = new LoginPage(driver);
        String username = "demoadmin";
        String password = "demopass";
        lp.loginPortal(username, password);

        // Step 2: Navigate to Customer Page
        driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
        driver.findElement(By.linkText("Customers")).click();

        // Step 3: Verify successful navigation to the Customers page
        WebElement customersPageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Customers')]"));

        // Assert that the title "Customers" is displayed
        Assert.assertTrue(customersPageTitle.isDisplayed(), "Navigation to Customers page failed.");
    }
}
