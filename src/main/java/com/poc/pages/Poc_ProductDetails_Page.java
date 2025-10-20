package com.poc.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.poc.elements.Poc_ProductDetailsPage_Elements;

public class Poc_ProductDetails_Page {
	
	WebDriver driver;
	Poc_ProductDetailsPage_Elements productDetailsPageElements;
	public static Logger logger = LogManager.getLogger(Poc_ProductDetails_Page.class);
	
	public Poc_ProductDetails_Page(WebDriver driver) {
		this.driver = driver;
		productDetailsPageElements = new Poc_ProductDetailsPage_Elements(this.driver);
	}
	
	
	public void increaseProductQty(int qty) {
		try {
		productDetailsPageElements.qtyTxtBox.clear();
		productDetailsPageElements.qtyTxtBox.sendKeys(String.valueOf(qty));
		}catch(Exception e) {
			logger.error("Product quantity update failed with exception: "+e.getMessage());
			Assert.fail("Product quantity update failed");
		}
	}
	
	public void addtoCartBtnClick() {
		try {
		productDetailsPageElements.addtoCartBtn.click();
		}catch(Exception e) {
			logger.error("Add to cart button click failed with exception: "+e.getMessage());
			Assert.fail("Add to cart button click failed");
		}
	}
	
	public boolean isWriteYourReviewLinkVisible() {
		try {
		return productDetailsPageElements.writeYourReviewLink.isDisplayed();
		}catch(Exception e) {
			logger.error("Checking visibility of Write your review link failed with exception: "+e.getMessage());
			Assert.fail("Checking visibility of Write your review link failed");
			return false;
		}
	}
	
	public void enterReviewDetails(String name, String email, String reviewText) {
		try {
		productDetailsPageElements.reviewNameTxtBox.sendKeys(name);
		productDetailsPageElements.reviewEmailTxtBox.sendKeys(email);
		productDetailsPageElements.reviewTextTxtBox.sendKeys(reviewText);
		}catch(Exception e) {
			logger.error("Entering review details failed with exception: "+e.getMessage());
			Assert.fail("Entering review details failed");
		}
	}
	
	public void submitReviewBtnClick() {
		try {
		productDetailsPageElements.submitReviewBtn.click();
		}catch(Exception e) {
			logger.error("Submit review button click failed with exception: "+e.getMessage());
			Assert.fail("Submit review button click failed");
		}
	}
	
	public boolean isReviewSubmissionMsgVisible() {
		try {
		return productDetailsPageElements.reviewSubmissionMsg.isDisplayed();
		}catch(Exception e) {
			logger.error("Checking visibility of review submission message failed with exception: "+e.getMessage());
			Assert.fail("Checking visibility of review submission message failed");
			return false;
		}
	}
	
	public boolean isProductNameDisplayed(String productName) {
		try {
		return productDetailsPageElements.getProductName(productName).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
}
