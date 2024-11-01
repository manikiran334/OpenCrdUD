package com.itlearn.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

    private XSSFWorkbook wb;

    // Constructor to initialize the workbook
    public ExcelDataProvider() {
        File src = new File("./TestData/Data.xlsx");
        try (FileInputStream fis = new FileInputStream(src)) {
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to read Excel file: " + e.getMessage());
        }
    }

    // Method to get string data from a specific cell
    public String getStringData(int sheetIndex, int row, int column) {
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
    }

    // Overloaded method to get string data using sheet name
    public String getStringData(String sheetName, int row, int column) {
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    // Method to get numeric data using sheet name
    public double getNumericData(String sheetName, int row, int column) {
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }

    // Method to get the number of rows in a specific sheet
    public int getRowCount(String sheetName) {
        return wb.getSheet(sheetName).getPhysicalNumberOfRows();
    }

    // Method to get the number of columns in a specific sheet
    public int getColumnCount(String sheetName) {
        return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
    }

    // Method to get cell data regardless of the cell type
    public String getCellData(String sheetName, int row, int column) {
        Cell cell = wb.getSheet(sheetName).getRow(row).getCell(column);
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

    // Close the workbook
    public void closeWorkbook() {
        try {
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing workbook: " + e.getMessage());
        }
    }
}
