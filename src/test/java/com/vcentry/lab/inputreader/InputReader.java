package com.vcentry.lab.inputreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputReader {
	public static Object [][] data;
	public static boolean getRunMode(String TestCaseName) throws FileNotFoundException, IOException {
		// reads and tell whether need to run or not
		XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File ("src/test/resources/com/vcentry/lab/inputs/Copy of inputcontroller.xlsx")));
		XSSFSheet TcSheetHome=workbook.getSheet("Home");
		int totalRow=TcSheetHome.getLastRowNum();
		for (int k=1;k<=totalRow;k++)
		{
			String runMode=TcSheetHome.getRow(k).getCell(2).getStringCellValue();
			String homePageTcName=TcSheetHome.getRow(k).getCell(0).getStringCellValue();
			if(runMode.equals("Y") & homePageTcName.equals(TestCaseName))
			{
				return true;
			} 
		}                                                                                                                                              
		return false;

	}

	public static Object[][] selectSingleOrMultiRun(String TestCaseName) throws FileNotFoundException, IOException {
		//reads and tell whether need to run or not

		XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File ("src/test/resources/com/vcentry/lab/inputs/Copy of inputcontroller.xlsx")));
		XSSFSheet TcSheetHome=workbook.getSheet("Home");
		int TcrowHome=TcSheetHome.getLastRowNum();
		
		for (int k=1;k<=TcrowHome;k++)
		{
			String TCNameHome=TcSheetHome.getRow(k).getCell(0).getStringCellValue();
			if(TCNameHome.equals(TestCaseName))
			{	
			String runForData=TcSheetHome.getRow(k).getCell(3).getStringCellValue();
			if(runForData.equals("Y"))
			{
				collectAllMultiData(TestCaseName);
				break;
			} else  
			{
				collectSingleDataOnly(TestCaseName);
				break;
			}
			}
		}
		return data;
		
	}

	public static Object[][] collectAllMultiData(String TestCaseName) throws FileNotFoundException, IOException {
		XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File ("src/test/resources/com/vcentry/lab/inputs/Copy of multiData.xlsx")));
		XSSFSheet TcSheet=workbook.getSheet(TestCaseName);
		int TcRow=TcSheet.getLastRowNum();
		int TcCol=TcSheet.getRow(1).getLastCellNum();
		data=new Object[TcCol][TcRow+1];
		for (int i=0;i<=TcRow;i++)
		{
			for (int j=0;j<TcCol;j++)
			{
			Cell Cell=TcSheet.getRow(i).getCell(j);
			TcSheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			data[j][i]=TcSheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;

	}
	

	public static Object[][] collectSingleDataOnly(String TestCaseName) throws FileNotFoundException, IOException {
		XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File ("src/test/resources/com/vcentry/lab/inputs/Copy of inputcontroller.xlsx")));
		XSSFSheet TcSheet=workbook.getSheet(TestCaseName);
		int TcRow=TcSheet.getLastRowNum();
		data=new Object[1][TcRow+1];
		for (int i=0;i<=TcRow;i++)
		{
			Cell Cell=TcSheet.getRow(i).getCell(5);
			TcSheet.getRow(i).getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			data[0][i]=TcSheet.getRow(i).getCell(5).getStringCellValue();
		}
		return data;

	}
}
