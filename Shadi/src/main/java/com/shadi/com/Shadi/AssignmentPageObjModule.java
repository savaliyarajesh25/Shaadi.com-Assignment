package com.shadi.com.Shadi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.shadi.com.utility.Driver;
import com.shadi.com.utility.Log;
import com.shadi.com.utility.UIElements;

public class AssignmentPageObjModule {

	public AssignmentPageObjModule() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(Driver.driver, this);
	}
	
	public void btnLetsBegin() {
		try {
			UIElements.waitForVisibleElement(btnLetsBegin);
			btnLetsBegin.click();
			Log.info("Click on Let's Begin.");
		} catch (Exception e) {
			Log.error("Unable to click, Error: "+e.getMessage());
		}
	}
	
	public void txtSignUpEmailId(String signupUsername) {
		try {
			txtSignUpEmailId.clear();
			txtSignUpEmailId.sendKeys(signupUsername);
			Log.info("Entered signup emailID in the textbox i.e: '"+signupUsername+"'.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Unable to click, Error: "+e.getMessage());
		}
	}
	
	public void txtSignupPassword(String signupPassword) {
		try {
			txtSignupPassword.clear();
			txtSignupPassword.sendKeys(signupPassword);
			Log.info("Entered signup password in the textbox i.e: '"+signupPassword+"'.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Unable to click, Error: "+e.getMessage());
		}
	}
	
	public void drpCreateProfileFor(String profileFor) {
		try {
			drpCreateProfileFor.click();
			Log.info("Click on Create profile for dropdown.");
			Driver.driver.findElement(By.xpath("//div[contains(text(),'"+profileFor+"')]")).click();
			Log.info("Click on "+profileFor+".");
		} catch (Exception e) {
			Log.error("Unable to click, Error: "+e.getMessage());
		}
	}
	
	public void rdbMale() {
		try {
			rdbMale.click();
			Log.info("Click on Male.");
		} catch (Exception e) {
			Log.error("Unable to click, Error: "+e.getMessage());
		}
	}
	
	public void rdbFemale() {
		try {
			rdbFemale.click();
			Log.info("Click on Female.");
		} catch (Exception e) {
			Log.error("Unable to click, Error: "+e.getMessage());
		}
	}
	
	public void btnNext() {
		try {
			btnNext.click();
			Log.info("Click on Next.");
		} catch (Exception e) {
			Log.error("Unable to click, Error: "+e.getMessage());
		}
	}
	
	public String getComunity() {
		UIElements.waitForVisibleElement(drpComunity);
		String communityName = null;
		try {
			communityName = drpComunity.getText();
			Log.info("Community name is: '"+communityName+"'.");
		} catch (Exception e) {
			Log.error("Unable to get coumunityName, Error: "+e.getMessage());
		}
		return communityName;
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),\"Let's Begin\")]")
	public WebElement btnLetsBegin;
	
	@FindBy(how = How.XPATH, using = "//input[@data-testid='email']")
	public WebElement txtSignUpEmailId;
	
	@FindBy(how = How.XPATH, using = "//input[@data-testid='signup_password']")
	public WebElement txtSignupPassword;
	
	@FindBy(how = How.XPATH, using = "//div[@class='Dropdown-root false']/div")
	public WebElement drpCreateProfileFor;
	
	@FindBy(how = How.ID, using = "gender_male")
	public WebElement rdbMale;
	
	@FindBy(how = How.ID, using = "gender_female")
	public WebElement rdbFemale;
	
	@FindBy(how = How.XPATH, using = "//button[@data-testid=\"next_button\"]")
	public WebElement btnNext;
	
	@FindBy(how = How.XPATH, using = "//div[@class='Dropdown-control mother_tongue_selector Dropdown-disabled']/div")
	public WebElement drpComunity;
	
	
	
}
