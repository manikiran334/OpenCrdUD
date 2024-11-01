package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CustomersNoOfPages {
    WebDriver driver;

    // Constructor to initialize driver
    public CustomersNoOfPages(WebDriver driver) {
        this.driver = driver;
    }

    // Method to find the total number of pages and iterate over them
    public void fetchCustomersDetails() {
        // Get the text that contains the number of pages
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();

        // Extract the total number of pages
        int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("pages") - 1));

        // Loop through each page
        for (int p = 1; p <= total_pages; p++) {
            if (p > 1) {
                // Click on the pagination button for each page
                WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='" + p + "']"));
                active_page.click();
            }

            // Find the number of rows in the current page's table
            List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
            int noOfRows = rows.size();

            // Loop through each row and print customer details
            for (int r = 1; r <= noOfRows; r++) {
                String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]/td[2]")).getText();
                String emailAddress = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]/td[3]")).getText();
                String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]/td[5]")).getText();

                // Print customer details
                System.out.println(customerName + "\t" + emailAddress + "\t" + status);
            }
        }
    }

    public void customersNoOfPages(WebDriver driver) {
    }
}
