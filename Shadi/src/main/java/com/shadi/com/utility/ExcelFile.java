package com.shadi.com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelFile {

	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;
	private static Cell Cell;
	static String excel_Path = null;

	public static void setExcelFile(String filePath, String SheetName) throws Exception {
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			ExcelWBook = getWorkbook(inputStream, filePath);
			ExcelWSheet = setSheetName(SheetName);
		} catch (Exception e){
			throw (e);
		}
	}
	
	public static Sheet setSheetName(String SheetName) throws Exception {
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){
			throw (e);
		}
		return ExcelWSheet;
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			DataFormatter df = new DataFormatter();
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = df.formatCellValue(Cell);
			return CellData;
		}catch (Exception e){
			return""+e.getMessage();
		}
	}

	public static int getRowCount() throws Exception {
		try{
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		}catch (Exception e){
			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}

	}

	private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

}
