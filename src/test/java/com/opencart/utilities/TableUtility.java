package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableUtility {

    /**
     * Returns the row count of a table.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @return The row count.
     */
    public int getRowCount(WebDriver driver, By tableLocator) {
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size();
    }

    /**
     * Returns the column count of a specific row in a table.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @param rowIndex The index of the row (0-based).
     * @return The column count in the specified row.
     */
    public int getColumnCount(WebDriver driver, By tableLocator, int rowIndex) {
        WebElement table = driver.findElement(tableLocator);
        WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
        return row.findElements(By.tagName("td")).size();
    }

    /**
     * Returns the text content of a specific cell in the table.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @param rowIndex The index of the row (0-based).
     * @param colIndex The index of the column (0-based).
     * @return The text content of the cell.
     */
    public String getCellData(WebDriver driver, By tableLocator, int rowIndex, int colIndex) {
        WebElement table = driver.findElement(tableLocator);
        WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
        WebElement cell = row.findElements(By.tagName("td")).get(colIndex);
        return cell.getText();
    }

    /**
     * Clicks a specific cell in the table.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @param rowIndex The index of the row (0-based).
     * @param colIndex The index of the column (0-based).
     */
    public void clickCell(WebDriver driver, By tableLocator, int rowIndex, int colIndex) {
        WebElement table = driver.findElement(tableLocator);
        WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
        WebElement cell = row.findElements(By.tagName("td")).get(colIndex);
        cell.click();
    }
    /**
     * Returns the text content of each cell in a specified row as a list.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @param rowIndex The index of the row (0-based).
     * @return A list of strings containing each cell's text in the specified row.
     */
    public List<String> getRowData(WebDriver driver, By tableLocator, int rowIndex) {
        List<String> rowData = new ArrayList<>();
        WebElement table = driver.findElement(tableLocator);
        WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        for (WebElement cell : cells) {
            rowData.add(cell.getText());
        }
        return rowData;
    }

    /**
     * Returns the text content of each cell in a specified column across all rows.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @param colIndex The index of the column (0-based).
     * @return A list of strings containing each cell's text in the specified column.
     */
    public List<String> getColumnData(WebDriver driver, By tableLocator, int colIndex) {
        List<String> columnData = new ArrayList<>();
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (colIndex < cells.size()) {
                columnData.add(cells.get(colIndex).getText());
            }
        }
        return columnData;
    }

    /**
     * Finds the row index of the first row containing a cell with the specified text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @param searchText The text to search within the cells.
     * @return The row index (0-based) of the row containing the text, or -1 if not found.
     */
    public int findRowByCellText(WebDriver driver, By tableLocator, String searchText) {
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            List<WebElement> cells = rows.get(rowIndex).findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(searchText)) {
                    return rowIndex;
                }
            }
        }
        return -1; // Return -1 if no match is found
    }

    /**
     * Checks if any cell within the table contains the specified text.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @param text The text to search for in the table cells.
     * @return true if the text is found in any cell; false otherwise.
     */
    public boolean doesTableContainText(WebDriver driver, By tableLocator, String text) {
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(text)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Gets the row count of a table element.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param tableLocator The By locator for locating the table.
     * @return The number of rows in the table.
     */
    public int getTableRowCount(WebDriver driver, By tableLocator) {
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size();
    }
}
