package com.poc.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.poc.elements.Poc_LoggedinPage_Elements;

public class Poc_Loggedin_Page {
	
	WebDriver driver;
	Poc_LoggedinPage_Elements loggedinPageElements;
	public static Logger logger = LogManager.getLogger(Poc_Loggedin_Page.class);
	
	public Poc_Loggedin_Page(WebDriver driver) {
		this.driver = driver;
		loggedinPageElements = new Poc_LoggedinPage_Elements(this.driver);
	}
	
	
	public void deleteBtnClick() {
		try {
		loggedinPageElements.deleteButton.click();
		}catch(Exception e) {
			logger.error("Delete button click failed with exception: "+e.getMessage());
			Assert.fail("Delete button click failed");
		}
	}
	
	
	public void logoutLinkClick() {
		try {
		loggedinPageElements.logoutLink.click();
		}catch(Exception e) {
			logger.error("Logout link click failed with exception: "+e.getMessage());
			Assert.fail("Logout link click failed");
		}
	}
	
	

}
