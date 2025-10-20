package com.poc.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.poc.elements.Poc_TestcasesPage_Elements;

public class Poc_TestCases_Page {
	WebDriver driver;
	Poc_TestcasesPage_Elements testcasePageElements;
	public static Logger logger = LogManager.getLogger(Poc_SignupOrLoginPage.class);
	
	public Poc_TestCases_Page(WebDriver driver) {
		this.driver = driver;
		testcasePageElements = new Poc_TestcasesPage_Elements(this.driver);
	}
	
	
	public boolean testcaseTitleCheck() {
		try {
		return testcasePageElements.testCasesTitle.isDisplayed();
		}catch(Exception e) {
			logger.error("Test Cases title not displayed with exception: "+e.getMessage());
			return false;
		}
	}

}
