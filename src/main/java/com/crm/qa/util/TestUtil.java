package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_PATH =".\\src\\main\\java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx";
	
	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentDir+"/Screenshots/"+System.currentTimeMillis()+".png"));
		}
	
	public static Object[][] getTestData(String sheetName) throws IOException{

		XLUtility xlsxUtil = new XLUtility(TESTDATA_PATH);

		int totalRows = xlsxUtil.getRowCount(sheetName);
		int totalCols = xlsxUtil.getCellCount(sheetName, 0);

		Object testData[][] = new Object[totalRows][totalCols];

		for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalCols;j++)
			{
				testData[i-1][j] =xlsxUtil.getCellData(sheetName, i, j);
			}
		}

		return testData;

	}
}
