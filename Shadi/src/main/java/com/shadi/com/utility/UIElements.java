package com.shadi.com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIElements {

	public static long waitTiming = 60;

	public static void waitForVisibleElement(WebElement element) {
		try {
			Thread.sleep(1000);
			Log.info("Waiting for element visibility of " + element);
			WebDriverWait wait = new WebDriverWait(Driver.driver, waitTiming);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void verify(String expectedResult, String actualResult)
	{
		if(expectedResult.equals(actualResult)) {
			Log.pass("Expaected(i.e: '"+expectedResult+"') result and Actual(i.e: '"+actualResult+"') result are matched.");
		}else {
			Log.fail("TC Fail: Expected '"+expectedResult+"', but found '"+actualResult+"'");
		}
	}
}
