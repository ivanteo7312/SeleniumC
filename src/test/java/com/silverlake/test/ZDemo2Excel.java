package com.silverlake.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2Excel {

	public static void main(String[] args) throws IOException {
		
		//location
		FileInputStream file = new FileInputStream("src/test/resources/open_emr_data.xlsx");

		//open 
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet=book.getSheet("validLoginTest");
		
//		String value = sheet.getRow(0).getCell(1).getStringCellValue();	
//		System.out.println(value);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowCount-1][cellCount];
		
		DataFormatter format = new DataFormatter();
		for(int r=1;r<rowCount;r++) {
			for(int c=0;c<cellCount;c++) {
//				String value = sheet.getRow(r).getCell(c).getStringCellValue();
				String value = format.formatCellValue(sheet.getRow(r).getCell(c));
				System.out.println(value);
				data[r-1][c] = value;
			}
		}
		
		book.close();
		file.close();
		
		//print all cell value excluding header
		
		//try to convert it to Object[][] data = new Object[2][3]
		
	}

}
