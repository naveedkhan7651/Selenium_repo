package com.tricentis.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method will read String Data from excel and return value based on row and coloumn index
	 * @param SheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String getStringDataFromExcel(String SheetName,int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
	FileInputStream f= new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook workbook = WorkbookFactory.create(f);
	return workbook.getSheet(SheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
	}
/**
 * This will read Boolean data from Excel
 * @param SheetName
 * @param rowIndex
 * @param colIndex
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public boolean BooleanDataFromExcel(String SheetName,int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
	FileInputStream f= new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook workbook = WorkbookFactory.create(f);
	return workbook.getSheet(SheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
}
/**
 * This will read Numeric data from Excel
 * @param SheetName
 * @param rowIndex
 * @param colIndex
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public double getNumericDataFromExcel(String SheetName,int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
	FileInputStream f= new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook workbook = WorkbookFactory.create(f);
	return workbook.getSheet(SheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
}
/**
 * This will read Local Date and Time from Excel
 * @param SheetName
 * @param rowIndex
 * @param colIndex
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public LocalDateTime getLocalDateTimeFromExcel(String SheetName, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
	FileInputStream f= new FileInputStream("./src/test/resources/TestData/TestScriptData");
	Workbook workbook = WorkbookFactory.create(f);
	return workbook.getSheet(SheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
}
}
