import java.util.List;

import com.shadi.com.Shadi.AssignmentModule;
import com.shadi.com.utility.BrowserConfigure;
import com.shadi.com.utility.Credentials;
import com.shadi.com.utility.DateTimeConfig;
import com.shadi.com.utility.Driver;
import com.shadi.com.utility.ExcelFile;
import com.shadi.com.utility.Log;
import com.shadi.com.utility.UIElements;

public class RunnereFile {

	static List<String> credential = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Log.initialization("AssignmentReport_"+DateTimeConfig.getCurrentDateAndTime("dd_MM_yyyy HH_mm_ss"));
			Log.startTestCase("setup");
			credential = Credentials.getCredentials();
			System.out.println(Credentials.browserName);
			BrowserConfigure.browserConfigure(Credentials.browserName);
			Log.info("Browser Name: "+Credentials.browserName);
			Driver.driver.navigate().to(Credentials.URL);
			Log.info("URL: "+Credentials.URL);
			Log.endTestCase();
			
			Log.startTestCase("verify Community Name");
			ExcelFile.setSheetName("Assignment");
			String createFor = ExcelFile.getCellData(1, 0);
			String gender = ExcelFile.getCellData(1, 1);
			String comunityName = new AssignmentModule().verifyCommunityName(credential.get(0), credential.get(1),
					createFor, gender);
			UIElements.verify(Credentials.product, comunityName);
			Log.endTestCase();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Driver.driver.quit();
		}
	}

}
