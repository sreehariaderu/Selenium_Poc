package com.poc.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.poc.elements.Poc_AccountInfoPage_Elements;

public class Poc_AccountInfo_Page {
	
	WebDriver driver;
	Poc_AccountInfoPage_Elements accountInfoElements;
	public static Logger logger = LogManager.getLogger(Poc_AccountInfo_Page.class);
	
	public Poc_AccountInfo_Page(WebDriver driver) {
		this.driver = driver;
		accountInfoElements = new Poc_AccountInfoPage_Elements(driver);
		
	}
	
	
	public Poc_AccountInfoPage_Elements accountInfoPageElements() {
		return accountInfoElements;
	}
	
	/**
	 * Method Name: selectTitleRadioButton
	 * Description: Selects the title radio button based on the provided title value.
	 *
	 * @param title Title to be selected (e.g., "Mr", "Mrs").
	 *
	 * @throws AssertionError if the title radio button selection fails.
	 *
	 * Author: Sreehari
	 * Date: 18-Oct-2025
	 */
	public void selectTitleRadioButton(String title) {
		try {
		List<WebElement>  radio = accountInfoElements.titleRadiogrp;
		for(WebElement r:radio) {
			if(r.getAttribute("value").contentEquals(title)) {
				r.click();
			}
		}
		}catch(Exception e) {
			logger.error("Title radio button selection failed with exception: "+e.getMessage());
			Assert.fail("Title radio button selection failed");
		}
	}
	
	/**
	 * Method Name: enterPassword
	 * Description: Enters the provided password into the password text box.
	 *
	 * @param password Password to be entered.
	 *
	 * @throws AssertionError if the password entry fails.
	 */
	public void enterPassword(String password) {
		try {
		accountInfoElements.passwordTxtBox.sendKeys(password);
		}catch(Exception e) {
			logger.error("Password entry failed with exception: "+e.getMessage());
			Assert.fail("Password entry failed");
		}
	}
	
	/**
	 * Method Name: selectDayOfBirth
	 * Description: Selects the day of birth from the dropdown based on the provided day value.
	 *
	 * @param day Day of birth to be selected (e.g., "1", "2", ..., "31").
	 *
	 * @throws AssertionError if the day of birth selection fails.
	 */
	public void selectDayOfBirth(String day) {
		try {
		Select select = new Select(accountInfoElements.dayDropdown);
		select.selectByValue(day);
		}catch(Exception e) {
			logger.error("Day of birth selection failed with exception: "+e.getMessage());
			Assert.fail("Day of birth selection failed");
		}
	}
	
	/**
	 * Method Name: selectMonthOfBirth
	 * Description: Selects the month of birth from the dropdown based on the provided month value.
	 *
	 * @param month Month of birth to be selected (e.g., "1" for January, "2" for February, etc.).
	 *
	 * @throws AssertionError if the month of birth selection fails.
	 */
	public void selectMonthOfBirth(String month) {
		try {
		Select select = new Select(accountInfoElements.monthDropdown);
		select.selectByValue(month);
		}catch(Exception e) {
			logger.error("Month of birth selection failed with exception: "+e.getMessage());
			Assert.fail("Month of birth selection failed");
		}
	}
	
	/**
	 * Method Name: selectYearOfBirth
	 * Description: Selects the year of birth from the dropdown based on the provided year value.
	 *
	 * @param year Year of birth to be selected (e.g., "1990", "2000", etc.).
	 *
	 * @throws AssertionError if the year of birth selection fails.
	 */
	public void selectYearOfBirth(String year) {
		try {
		Select select = new Select(accountInfoElements.yearDropdown);
		select.selectByValue(year);
		}catch(Exception e) {
			logger.error("Year of birth selection failed with exception: "+e.getMessage());
			Assert.fail("Year of birth selection failed");
		}
	}
	
	/**
	 * Method Name: selectNewsLetterCheckBox
	 * Description: Selects the newsletter checkbox.
	 *
	 * @throws AssertionError if the newsletter checkbox selection fails.
	 */
	public void selectNewsLetterCheckBox() {
		try {
		accountInfoElements.newsletterCheckBox.click();
		}catch(Exception e) {
			logger.error("Newsletter checkbox selection failed with exception: "+e.getMessage());
			Assert.fail("Newsletter checkbox selection failed");
		}
	}
	
	/**
	 * Method Name: selectSpecialOffersCheckBox
	 * Description: Selects the special offers checkbox.
	 *
	 * @throws AssertionError if the special offers checkbox selection fails.
	 */
	public void selectSpecialOffersCheckBox() {
		try {
		accountInfoElements.specialOffersCheckBox.click();
		}catch(Exception e) {
			logger.error("Special offers checkbox selection failed with exception: "+e.getMessage());
			Assert.fail("Special offers checkbox selection failed");
		}
	}
	
	/**
	 * Method Name: enterFirstName
	 * Description: Enters the provided first name into the first name text box.
	 *
	 * @param firstName First name to be entered.
	 *
	 * @throws AssertionError if the first name entry fails.
	 */
	public void enterFirstName(String firstName) {
		try {
		accountInfoElements.firstNametxtBox.sendKeys(firstName);
		}catch(Exception e) {
			logger.error("First name entry failed with exception: "+e.getMessage());
			Assert.fail("First name entry failed");
		}
	}
	
	/**
	 * Method Name: enterLaststName
	 * Description: Enters the provided last name into the last name text box.
	 *
	 * @param LastName Last name to be entered.
	 *
	 * @throws AssertionError if the last name entry fails.
	 */
	public void enterLaststName(String LastName) {
		try {
		accountInfoElements.lastNametxtBox.sendKeys(LastName);
		}catch(Exception e) {
			logger.error("Last name entry failed with exception: "+e.getMessage());
			Assert.fail("Last name entry failed");
		}
	}
	
	/**
	 * Method Name: enterCompany
	 * Description: Enters the provided company name into the company text box.
	 *
	 * @param company Company name to be entered.
	 *
	 * @throws AssertionError if the company name entry fails.
	 */
	public void enterCompany(String company) {
		try {
		accountInfoElements.companytxtBox.sendKeys(company);
		}catch(Exception e) {
			logger.error("Company name entry failed with exception: "+e.getMessage());
			Assert.fail("Company name entry failed");
		}
	}
	
	/**
	 * Method Name: enterAddress1
	 * Description: Enters the provided address line 1 into the address1 text box.
	 *
	 * @param address1 Address line 1 to be entered.
	 *
	 * @throws AssertionError if the address1 entry fails.
	 */
	public void enterAddress1(String address1) {
		try {
		accountInfoElements.address1txtBox.sendKeys(address1);
		}catch(Exception e) {
			logger.error("Address1 entry failed with exception: "+e.getMessage());
			Assert.fail("Address1 entry failed");
		}
	}
	
	/**
	 * Method Name: enterAddress2
	 * Description: Enters the provided address line 2 into the address2 text box.
	 *
	 * @param address2 Address line 2 to be entered.
	 *
	 * @throws AssertionError if the address2 entry fails.
	 */
	public void enterAddress2(String address2) {
		try {
		accountInfoElements.address2txtBox.sendKeys(address2);
		}catch(Exception e) {
			logger.error("Address2 entry failed with exception: "+e.getMessage());
			Assert.fail("Address2 entry failed");
		}
	}
	
	/**
	 * Method Name: selectCountry
	 * Description: Selects the country from the dropdown based on the provided country value.
	 *
	 * @param country Country to be selected (e.g., "United States", "Canada", etc.).
	 *
	 * @throws AssertionError if the country selection fails.
	 */
	public void selectCountry(String country) {
		try {
		Select select = new Select(accountInfoElements.countryDropdown);
		select.selectByVisibleText(country);
		}catch(Exception e) {
			logger.error("Country selection failed with exception: "+e.getMessage());
			Assert.fail("Country selection failed");
		}
	}
    
	/**
	 * Method Name: enterStateName
	 * Description: Enters the provided state name into the state text box.
	 *
	 * @param state State name to be entered.
	 *
	 * @throws AssertionError if the state name entry fails.
	 */
	public void enterStateName(String state) {
		try {
		accountInfoElements.statetxtBox.sendKeys(state);
		}catch(Exception e) {
			logger.error("State name entry failed with exception: "+e.getMessage());
			Assert.fail("State name entry failed");
		}
	}
	
	/**
	 * Method Name: enterCityName
	 * Description: Enters the provided city name into the city text box.
	 *
	 * @param city City name to be entered.
	 *
	 * @throws AssertionError if the city name entry fails.
	 */
	public void enterCityName(String city) {
		try {
		accountInfoElements.citytxtBox.sendKeys(city);
		}catch(Exception e) {
			logger.error("City name entry failed with exception: "+e.getMessage());
			Assert.fail("City name entry failed");
		}
	}
	
	/**
	 * Method Name: enterZipCode
	 * Description: Enters the provided zip code into the zip code text box.
	 *
	 * @param zipCode Zip code to be entered.
	 *
	 * @throws AssertionError if the zip code entry fails.
	 */
	public void enterZipCode(String zipCode) {
		try {
		accountInfoElements.zipcodetxtBox.sendKeys(zipCode);
		}catch(Exception e) {
			logger.error("Zip code entry failed with exception: "+e.getMessage());
			Assert.fail("Zip code entry failed");
		}
	}
	
	/**
	 * Method Name: enterMobileNumber
	 * Description: Enters the provided mobile number into the mobile number text box.
	 *
	 * @param mobileNo Mobile number to be entered.
	 *
	 * @throws AssertionError if the mobile number entry fails.
	 */
	public void enterMobileNumber(String mobileNo) {
		try {
		accountInfoElements.mobileNumbertxtBox.sendKeys(mobileNo);
		}catch(Exception e) {
			logger.error("Mobile number entry failed with exception: "+e.getMessage());
			Assert.fail("Mobile number entry failed");
		}
	}
	
	/**
	 * Method Name: createAccountBtnClick
	 * Description: Clicks the create account button.
	 *
	 * @throws AssertionError if the create account button click fails.
	 */
	public void createAccountBtnClick() {
		try {
		accountInfoElements.createAccountBtn.click();
		}catch(Exception e) {
			logger.error("Create account button click failed with exception: "+e.getMessage());
			Assert.fail("Create account button click failed");
		}
	}
	
	
	/**
	 * Method Name: accountCreationCheck
	 * Description: Checks if the account creation was successful by verifying the presence of the success message.
	 *
	 * @return true if the account creation success message is displayed, false otherwise.
	 */
	public boolean accountCreationCheck() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(accountInfoElements.accountCreationSuccessMsg));
		return accountInfoElements.accountCreationSuccessMsg.isDisplayed();
		}catch(Exception e) {
			logger.error("Account creation check failed with exception: "+e.getMessage());
			return false;
		}
	}
	
	/**
	 * Method Name: continueLinkClick
	 * Description: Clicks the continue link after account creation.
	 *
	 * @throws AssertionError if the continue link click fails.
	 */
	public void continueLinkClick() {
		try {
		accountInfoElements.continueLink.click();
		}catch(Exception e) {
			logger.error("Continue link click failed with exception: "+e.getMessage());
			Assert.fail("Continue link click failed");
		}
	}
	
	/**
	 * Method Name: userLoginCheck
	 * Description: Checks if the user is logged in by verifying the presence of the logged-in message with the specified username.
	 *
	 * @param userName Username to be verified in the logged-in message.
	 * @return true if the logged-in message with the specified username is displayed, false otherwise.
	 */
	public boolean userLoginCheck(String userName) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement loggedInMsg = driver.findElement(By.xpath("//a[text()=' Logged in as ']/b[text()='"+userName+"']"));
		wait.until(ExpectedConditions.visibilityOf(loggedInMsg));
		return loggedInMsg.isDisplayed();
		}catch(Exception e) {
			logger.error("User login check failed with exception: "+e.getMessage());
			return false;
		}
	}
	
	/**
	 * Method Name: accountDeletionCheck
	 * Description: Checks if the account deletion was successful by verifying the presence of the deletion message.
	 *
	 * @return true if the account deletion message is displayed, false otherwise.
	 */
	public boolean accountDeletionCheck() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(accountInfoElements.accountDeletedMsg));
		return accountInfoElements.accountDeletedMsg.isDisplayed();
		}catch(Exception e) {
			logger.error("Account deletion check failed with exception: "+e.getMessage());
			return false;
		}
	}
	
	

}
