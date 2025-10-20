package com.poc.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.poc.elements.Poc_ProductsPage_Elements;

public class Poc_Products_Page {
	
	WebDriver driver;
	Poc_ProductsPage_Elements  productsPageElements;
	public static Logger logger = LogManager.getLogger(Poc_Products_Page.class);
	Actions actions;
	
	public Poc_Products_Page(WebDriver driver) {
		this.driver = driver;
		productsPageElements = new Poc_ProductsPage_Elements(this.driver);
		actions = new Actions(this.driver);
	}
	
	public void mouseHoverOnProduct(int ProductNumber) {
		try {
		actions.moveToElement(productsPageElements.getProductBynumber(ProductNumber)).perform();
		}catch(Exception e) {
			logger.error("Mouse hover on product failed with exception: "+e.getMessage());
			Assert.fail("Mouse hover on product failed");
		}
		
	}
	
	public void mouseHoverOnAddToCart(int ProductNumber) {
		try {
		actions.moveToElement(productsPageElements.getAddToCartBtn(ProductNumber)).perform();
		}catch(Exception e) {
			logger.error("Mouse hover on Add to cart button failed with exception: "+e.getMessage());
			Assert.fail("Mouse hover on Add to cart button failed");
		}
		
	}
	
	public void addToCartClick(int ProductNum) {
		try {
		productsPageElements.getAddToCartBtn(ProductNum).click();
		}catch(Exception e) {
			logger.error("Add to cart button click failed with exception: "+e.getMessage());
			Assert.fail("Add to cart button click failed");
		}
	}
	
	public void continueShoppingBtnClick(WebDriver driver) throws Exception {
		try {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(productsPageElements.continueShoppingBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productsPageElements.continueShoppingBtn);
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsPageElements.continueShoppingBtn);
		}catch(Exception e) {
			logger.error("Continue shopping button click failed with exception: "+e.getMessage());
			Assert.fail("Continue shopping button click failed");
		  }
		}
	
	public void viewCartLinkClick(WebDriver driver) {
		try {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(productsPageElements.viewCartLink));
		productsPageElements.viewCartLink.click();
		}catch(Exception e) {
			logger.error("View cart link click failed with exception: "+e.getMessage());
			Assert.fail("View cart link click failed");
		  }
		
	}
	
	public boolean isBrandsSectionDisplayed() {
		try {
			return productsPageElements.brandsSection.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickBrandNameLink(String brandName) {
		try {
			productsPageElements.getBrandNameLink(brandName).click();
		}catch(Exception e) {
			logger.error("Brand name link "+brandName+" click failed with exception: "+e.getMessage());
			Assert.fail("Brand name link "+brandName+" click failed");
		}
	}
	
	public boolean isAllProductsTitleDisplayed() {
		try {
			return productsPageElements.allProductsTitle.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickViewProductLink(int productNo) {
		try {
			productsPageElements.getViewProductLink(productNo).click();
		}catch(Exception e) {
			logger.error("View product link click failed with exception: "+e.getMessage());
			Assert.fail("View product link click failed");
		}
	}
	
	public void enterProductInSearchBox(String productName) {
		try {
			productsPageElements.searchProductTxtBox.clear();
			productsPageElements.searchProductTxtBox.sendKeys(productName);
		}catch(Exception e) {
			logger.error("Entering product name in search box failed with exception: "+e.getMessage());
			Assert.fail("Entering product name in search box failed");
		}
	}
	
	public void clickSearchBtn() {
		try {
			productsPageElements.searchBtn.click();
		}catch(Exception e) {
			logger.error("Search button click failed with exception: "+e.getMessage());
			Assert.fail("Search button click failed");
		}
	}
	
}