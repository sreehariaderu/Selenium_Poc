package com.poc.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.poc.elements.Poc_SignupLoginPage_Elements;

public class Poc_SignupOrLoginPage {
	
	WebDriver driver;
	Poc_SignupLoginPage_Elements signupOrLoginPage;
	public static Logger logger = LogManager.getLogger(Poc_SignupOrLoginPage.class);
	
	public Poc_SignupOrLoginPage(WebDriver driver) {
		this.driver = driver;
		signupOrLoginPage = new Poc_SignupLoginPage_Elements(this.driver);
	}
	
	public boolean isSignupTitleDisplayed() {
		try {
		return signupOrLoginPage.NewUserSignUpTitle.isDisplayed();
		}catch(Exception e) {
			logger.error("New User Signup title not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	public void enterName(String userName) {
		try {
		signupOrLoginPage.NameTxtBox.sendKeys(userName);
		}catch(Exception e) {
			logger.error("Name entry failed with exception: "+e.getMessage());
			Assert.fail("Name entry failed");
		}
	}
	
	public void enterSignupEmailAddress(String userEmail) {
		try {
		signupOrLoginPage.SignupEmailTxtBox.sendKeys(userEmail);
		}catch(Exception e) {
			logger.error("Email entry failed with exception: "+e.getMessage());
			Assert.fail("Email entry failed");
		}
	}
	
	
	public void signupBtnClick() {
		try {
		signupOrLoginPage.SignupBtn.click();
		}catch(Exception e) {
			logger.error("Signup button click failed with exception: "+e.getMessage());
			Assert.fail("Signup button click failed");
		}
	}
	
	
	public boolean isLoginToYourAccountTitleDisplayed() {
		try {
		return signupOrLoginPage.loginToYourAccountTitle.isDisplayed();
		}catch(Exception e) {
			logger.error("Login to your account title not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	
	public void enterLoginEmail(String loginEmailAddress) {
		try {
		signupOrLoginPage.loginEmailTxtBox.sendKeys(loginEmailAddress);
		}catch(Exception e) {
			logger.error("Login email entry failed with exception: "+e.getMessage());
			Assert.fail("Login email entry failed");
		}
	}
	
	public void enterPassword(String password) {
		try {
		signupOrLoginPage.passwordTxtBox.sendKeys(password);
		}catch(Exception e) {
			logger.error("Password entry failed with exception: "+e.getMessage());
			Assert.fail("Password entry failed");
		}
	}
	
	
	public void loginBtnClick() {
		try {
		signupOrLoginPage.loginBtn.click();
		}catch(Exception e) {
			logger.error("Login button click failed with exception: "+e.getMessage());
			Assert.fail("Login button click failed");
		}
	}
	
	public boolean invalidLoginMessageCheck() {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signupOrLoginPage.invalidLoginMsg));
		return signupOrLoginPage.invalidLoginMsg.isDisplayed();
		}catch(Exception e) {
			logger.error("Invalid login message not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	public boolean EmailAlreadyExistsMsgCheck() {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signupOrLoginPage.EmailAlreadyExistsMsg));
		return signupOrLoginPage.EmailAlreadyExistsMsg.isDisplayed();
		}catch(Exception e) {
			logger.error("Email already exists message not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	
	public void Login(String Email,String pwd) {
		try {
		signupOrLoginPage.loginEmailTxtBox.sendKeys(Email);
		signupOrLoginPage.passwordTxtBox.sendKeys(pwd);
		signupOrLoginPage.loginBtn.click();
		}catch(Exception e) {
			logger.error("Login failed with exception: "+e.getMessage());
			Assert.fail("Login failed");
		}
	}
}
