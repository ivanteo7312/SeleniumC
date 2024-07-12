package com.silverlake.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;


/*
 * This class contains all dataprovider methods.
 */
public class DataSource {

	@DataProvider
	public Object[][] commonDataProvider(Method mtd) throws IOException{
		
		String testName = mtd.getName();
		
		Object[][] data = ExcelUtils.getSheetIntoTwoDimensionalArray("src/test/resources/open_emr_data.xlsx", testName);
		return data;
	}
	
	@DataProvider
	public Object[][] validLoginData(){
		
		Object[][] data = new Object[2][3];
		
		data[0][1]="admin";
		data[0][2]="pass";
		data[0][3]="openEMR";
		
		data[1][0]="receptionist";
		data[1][1]="receptionist";
		data[1][2]="openEMR";
		
		return data;
		
		
	}
}
