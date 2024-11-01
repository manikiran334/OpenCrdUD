package com.opencart.testcases;

import com.opencart.pages.BaseTest;
import com.opencart.pages.LoginPage;
import com.opencart.utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    String fileName = System.getProperty("user.dir") + "\\TestData\\TestInfo.xlsx";

    @Test(priority = 1, dataProvider = "LoginDataProvider")
    public void verifyLogin(String username, String password) {
        // Initialize LoginPage
        LoginPage lp = new LoginPage(driver);

        // Perform login
        lp.loginPortal(username, password);

        // Add an assertion to verify the login was successful
        // Assuming that after login, the dashboard page or some specific element is displayed
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed for username: " + username);
    }

    @DataProvider(name = "LoginDataProvider")
    public String[][] loginDataProvider() {
        // Read the number of rows and columns from the Excel sheet
        int ttlRows = ReadExcelFile.getRowCount(fileName, "Sheet1");
        int ttlColumns = ReadExcelFile.getColCount(fileName, "Sheet1");

        // Initialize data array to store Excel data
        String data[][] = new String[ttlRows - 1][ttlColumns];

        // Loop through the Excel sheet and populate data array
        for (int i = 1; i < ttlRows; i++) {
            for (int j = 0; j < ttlColumns; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "Sheet1", i, j);
            }
        }
        return data;
    }
}
