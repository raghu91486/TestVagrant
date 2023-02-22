package com.testvagarant.genericLibraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility 
{
	public String getExcelData(String sheetname, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		DataFormatter format=new DataFormatter();
		Row row = sh.getRow(rownum);
		Cell cel = row.getCell(cellnum);
		String data = format.formatCellValue(cel);
		wb.close();
		return data;
	}

}
