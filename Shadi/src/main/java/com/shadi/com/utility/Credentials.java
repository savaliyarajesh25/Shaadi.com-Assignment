package com.shadi.com.utility;

import java.util.ArrayList;
import java.util.List;

public class Credentials {

	public static String URL = "";
	public static String browserName = "";
	public static String product = "";

	public static String excelPath_uLearn = "/testData/shadi_testData.xlsx";

	public static List<String> getCredentials(){

		List<String> credential = new ArrayList<>();
		try {
			String filePath = "";
			filePath = System.getProperty("user.dir")+excelPath_uLearn;

			ExcelFile.setExcelFile(filePath, "userConfig");
			browserName = ExcelFile.getCellData(1, 1);

			String username = "";
			String password = "";
			product = ExcelFile.getCellData(0, 1);
			int lastRow = ExcelFile.getRowCount();
			for(int i=5; i<=lastRow; i++) {
				String rowProduct = ExcelFile.getCellData(i, 2);

				if(rowProduct.equalsIgnoreCase(product)) {
					URL = ExcelFile.getCellData(i, 3);
					username = ExcelFile.getCellData(i, 4);
					password = ExcelFile.getCellData(i, 5);
					break;
				}
			}
			credential.add(username);
			credential.add(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credential;
	}

	//Just For Debugging
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> credential = getCredentials();
		System.out.println("Username: "+credential.get(0));
		System.out.println("Password: "+credential.get(1));
	}
}
