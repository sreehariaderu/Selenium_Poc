package com.poc.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.poc.elements.Poc_ContactUsPage_Elements;

public class Poc_ContactUs_Page {
	
	WebDriver driver;
	Poc_ContactUsPage_Elements  contactUsElements;
	public static Logger logger = LogManager.getLogger(Poc_ContactUs_Page.class);
	
	public Poc_ContactUs_Page(WebDriver driver) {
		this.driver = driver;
		contactUsElements = new Poc_ContactUsPage_Elements(this.driver);
	}
	
	/** Method Name: getInTouchTitleCheck
	 * Description : This method verifies whether the 'Get In Touch' title is displayed
	 * @return boolean - true if displayed else false
	 */
	public boolean getInTouchTitleCheck() {
		try {
		return contactUsElements.getInTouchTitle.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	/** Method Name: enterName
	 * Description : This method enters name in the name text box
	 * @param name - name to be entered
	 */
	public void enterName(String name) {
		try {
		contactUsElements.nameTxtBox.sendKeys(name);
		}catch(Exception e) {
			logger.error("Name entry failed with exception: "+e.getMessage());
		}
	}
	
	/** Method Name: enterEmail
	 * Description : This method enters email in the email text box
	 * @param email - email to be entered
	 */
	public void enterEmail(String email) {
		try {
		contactUsElements.emailTxtBox.sendKeys(email);
		}catch(Exception e) {
		logger.error("Email entry failed with exception: "+e.getMessage());
		Assert.fail("Email entry failed");
		}
	}
	
	/** Method Name: enterSubject
	 * Description : This method enters subject in the subject text box
	 * @param subject - subject to be entered
	 */
	public void enterSubject(String subject) {
		try {
		contactUsElements.subjectTxtBox.sendKeys(subject);
		}catch(Exception e) {
			logger.error("Subject entry failed with exception: "+e.getMessage());
			Assert.fail("Subject entry failed");
		}
	}
	
	/** Method Name: enterMessage
	 * Description : This method enters message in the message text area
	 * @param message - message to be entered
	 */
	public void enterMessage(String message) {
		try {
		contactUsElements.messageTxtArea.sendKeys(message);
		}catch(Exception e) {
			logger.error("Message entry failed with exception: "+e.getMessage());
			Assert.fail("Message entry failed");
		}
	}
	
	/** Method Name: chooseFile
	 * Description : This method uploads a file using the upload file button
	 * @param filePath - path of the file to be uploaded
	 */
	public void chooseFile(String filePath) {
		try {		
		contactUsElements.uploadFileBtn.sendKeys(filePath);
		}catch(Exception e) {
			logger.error("File upload failed with exception: "+e.getMessage());
			Assert.fail("File upload failed");
		}
	}
	
	/** Method Name: submitBtnClick
	 * Description : This method clicks on the submit button
	 */
	public void submitBtnClick() {
		try {
		contactUsElements.submitBtn.click();
		}catch(Exception e) {
			logger.error("Submit button click failed with exception: "+e.getMessage());
			Assert.fail("Submit button click failed");
		}
	}
	
	/** Method Name: acceptAlert
	 * Description : This method accepts the alert popup
	 */
	public void acceptAlert() {
		try {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}catch(Exception e) {
			logger.error("Alert acceptance failed with exception: "+e.getMessage());
			Assert.fail("Alert acceptance failed");
		}
	}
	
	/** Method Name: detailsSubmittedMsgCheck
	 * Description : This method verifies whether the details submitted success message is displayed
	 * @return boolean - true if displayed else false
	 */
	public boolean detailsSubmittedMsgCheck() {
		try {
		return contactUsElements.detailsSubmittedSuccessMsg.isDisplayed();
		}catch(Exception e) {
			logger.error("Details submitted message not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	/** Method Name: homeLinkClick
	 * Description : This method clicks on the home link
	 */
	public void homeLinkClick() {
		try {
		contactUsElements.homeLink.click();
		}catch(Exception e) {
			logger.error("Home link click failed with exception: "+e.getMessage());
			Assert.fail("Home link click failed");
		}
	}

}
