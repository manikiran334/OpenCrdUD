package com.opencart.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {

    /**
     * Gets the value of a specific cell in an Excel sheet.
     *
     * @param fileName  The path to the Excel file.
     * @param sheetName The name of the sheet.
     * @param rowNo     The row number (0-based).
     * @param cellNo    The cell number (0-based).
     * @return The value of the cell as a String, or an empty string if an error occurs.
     */
    public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {
        try (FileInputStream inputStream = new FileInputStream(fileName);
             XSSFWorkbook workBook = new XSSFWorkbook(inputStream)) {

            XSSFSheet excelSheet = workBook.getSheet(sheetName);
            XSSFRow row = excelSheet.getRow(rowNo);
            XSSFCell cell = row.getCell(cellNo);

            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        return cell.getStringCellValue();
                    case NUMERIC:
                        return String.valueOf(cell.getNumericCellValue());
                    case BOOLEAN:
                        return String.valueOf(cell.getBooleanCellValue());
                    default:
                        return "";
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading cell value: " + e.getMessage());
        }
        return "";
    }

    /**
     * Gets the total number of rows in a specified sheet.
     *
     * @param fileName  The path to the Excel file.
     * @param sheetName The name of the sheet.
     * @return The number of rows in the sheet, or 0 if an error occurs.
     */
    public static int getRowCount(String fileName, String sheetName) {
        try (FileInputStream inputStream = new FileInputStream(fileName);
             XSSFWorkbook workBook = new XSSFWorkbook(inputStream)) {

            XSSFSheet excelSheet = workBook.getSheet(sheetName);
            return excelSheet.getPhysicalNumberOfRows();
        } catch (IOException e) {
            System.err.println("Error reading row count: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Gets the total number of columns in the first row of a specified sheet.
     *
     * @param fileName  The path to the Excel file.
     * @param sheetName The name of the sheet.
     * @return The number of columns in the sheet, or 0 if an error occurs.
     */
    public static int getColCount(String fileName, String sheetName) {
        try (FileInputStream inputStream = new FileInputStream(fileName);
             XSSFWorkbook workBook = new XSSFWorkbook(inputStream)) {

            XSSFSheet excelSheet = workBook.getSheet(sheetName);
            return excelSheet.getRow(0).getPhysicalNumberOfCells();
        } catch (IOException e) {
            System.err.println("Error reading column count: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Gets a string value from a specific cell in the specified sheet by index.
     *
     * @param sheetIndex The index of the sheet (0-based).
     * @param row        The row number (0-based).
     * @param column     The column number (0-based).
     * @return The cell value as a String.
     */
    public String getStringData(int sheetIndex, int row, int column) {
        try (FileInputStream inputStream = new FileInputStream("YourExcelFile.xlsx");
             XSSFWorkbook workBook = new XSSFWorkbook(inputStream)) {

            return workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
        } catch (IOException e) {
            System.err.println("Error reading string data: " + e.getMessage());
        }
        return "";
    }

    /**
     * Gets a string value from a specific cell in the specified sheet by name.
     *
     * @param sheetName The name of the sheet.
     * @param row       The row number (0-based).
     * @param column    The column number (0-based).
     * @return The cell value as a String.
     */
    public String getStringData(String sheetName, int row, int column) {
        return getStringData(sheetName, row, column); // Avoid duplicating code; consider refactoring
    }

    /**
     * Gets a numeric value from a specific cell in the specified sheet by name.
     *
     * @param sheetName The name of the sheet.
     * @param row       The row number (0-based).
     * @param column    The column number (0-based).
     * @return The cell value as a double.
     */
    public double getNumericData(String sheetName, int row, int column) {
        try (FileInputStream inputStream = new FileInputStream("YourExcelFile.xlsx");
             XSSFWorkbook workBook = new XSSFWorkbook(inputStream)) {

            return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
        } catch (IOException e) {
            System.err.println("Error reading numeric data: " + e.getMessage());
        }
        return 0;
    }
}
