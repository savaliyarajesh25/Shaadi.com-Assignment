package com.shadi.com.Shadi;

import com.shadi.com.utility.Log;
import com.shadi.com.utility.UIElements;
import com.shadi.com.utility.BrowserConfigure;
import com.shadi.com.utility.Credentials;
import com.shadi.com.utility.Driver;
import com.shadi.com.utility.ExcelFile;
import com.shadi.com.utility.DateTimeConfig;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;

import org.testng.annotations.AfterClass;

public class AssignmentTestng {

	List<String> credential = null;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		Log.initialization("AssignmentReport_"+DateTimeConfig.getCurrentDateAndTime("dd_MM_yyyy HH_mm_ss"));
		Log.startTestCase("setup");
		credential = Credentials.getCredentials();
		System.out.println(Credentials.browserName);
		BrowserConfigure.browserConfigure(Credentials.browserName);
		Log.info("Browser Name: "+Credentials.browserName);
		Driver.driver.navigate().to(Credentials.URL);
		Log.info("URL: "+Credentials.URL);
		Log.endTestCase();
		
	}
	
	@Test
	public void verifyCommunityName() throws Exception {
		Log.startTestCase("verify Community Name");
		ExcelFile.setSheetName("Assignment");
		String createFor = ExcelFile.getCellData(1, 0);
		String gender = ExcelFile.getCellData(1, 1);
		String comunityName = new AssignmentModule().verifyCommunityName(credential.get(0), credential.get(1),
				createFor, gender);
		UIElements.verify(Credentials.product, comunityName);
		Log.endTestCase();
	}

	@AfterClass
	public void afterClass() {
		Driver.driver.quit();
	}
}
