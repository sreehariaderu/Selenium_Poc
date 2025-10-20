package com.poc.lib;

import org.openqa.selenium.WebDriver;

import com.poc.pages.Poc_AccountInfo_Page;
import com.poc.pages.Poc_Cart_Page;
import com.poc.pages.Poc_Category_Page;
import com.poc.pages.Poc_ContactUs_Page;
import com.poc.pages.Poc_Home_page;
import com.poc.pages.Poc_Loggedin_Page;
import com.poc.pages.Poc_ProductDetails_Page;
import com.poc.pages.Poc_Products_Page;
import com.poc.pages.Poc_SignupOrLoginPage;
import com.poc.pages.Poc_TestCases_Page;

public class PageLib {
	
	WebDriver driver;
	Poc_Home_page homePage;
	Poc_SignupOrLoginPage signupOrLoginPage;
	Poc_AccountInfo_Page accountInfoPage;
	Poc_Loggedin_Page loggedinPage;
	Poc_ContactUs_Page contactUsPage;
	Poc_TestCases_Page testCasePage;
	Poc_Products_Page productPage;
	Poc_Cart_Page cartPage;
	Poc_ProductDetails_Page  productDetailsPage;
	Poc_Category_Page  categoryPage;
	
	public PageLib(WebDriver driver) {
		this.driver = driver;
		homePage = new Poc_Home_page(this.driver);
		signupOrLoginPage = new Poc_SignupOrLoginPage(this.driver);
		accountInfoPage = new Poc_AccountInfo_Page(this.driver);
		loggedinPage = new Poc_Loggedin_Page(this.driver);
		contactUsPage = new Poc_ContactUs_Page(this.driver);
		testCasePage = new Poc_TestCases_Page(this.driver);
		productPage = new Poc_Products_Page(this.driver);
		cartPage = new Poc_Cart_Page(this.driver);
		productDetailsPage = new Poc_ProductDetails_Page(this.driver);
		categoryPage = new Poc_Category_Page(this.driver);
		
	}
	
	public Poc_Home_page HomePage() {
		return homePage;
	}
	
	public Poc_SignupOrLoginPage signupOrLoginpage() {
		return signupOrLoginPage;
	}
	
	
	public Poc_AccountInfo_Page accountinfoPage() {
		return accountInfoPage;
	}
	
	public Poc_Loggedin_Page loggedInPage() {
		return loggedinPage;
	}
	
	public Poc_ContactUs_Page contactUsPage() {
		return contactUsPage;
	}
	
	public Poc_TestCases_Page testCasesPage() {
		return testCasePage;
	}
	
	public Poc_Products_Page productsPage() {
		return productPage;
	}
	
	public Poc_Cart_Page cartpage() {
		return cartPage;
	}
	
	public Poc_ProductDetails_Page productdetailsPage() {
		return productDetailsPage;
	}
	
	public Poc_Category_Page categoryPage() {
		return categoryPage;
	}

}
