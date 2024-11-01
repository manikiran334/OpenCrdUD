package com.opencart.testcases;

import com.opencart.pages.*;
import com.opencart.utilities.ReadExcelFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CustomerListTest extends BaseTest {

    String fileName = System.getProperty("user.dir") + "\\TestData\\TestInfo.xlsx";

    @Test
    public void validateCustomerList() {

        // Login page
        LoginPage li = new LoginPage(driver);
        String username = ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 0);
        String password = ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 1);
        li.loginPortal(username, password);

        // Navigate to Customer page
        CustomerPage cl = new CustomerPage(driver);  // Pass driver to constructor
        cl.navigateToCustomers();

        // Fetch customer details
        CustomersNoOfPages cn = new CustomersNoOfPages(driver);  // Pass driver to constructor
        cn.fetchCustomersDetails();

        // Logout
        LogOutPage lo = new LogOutPage(driver);  // Pass driver to constructor
        lo.logout();  // Logout the user
    }

    @AfterTest
    public void tearDown() {
        // Code to close browser or perform other cleanup if necessary
        driver.quit();
    }
}
