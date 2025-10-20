package com.poc.pages;

import java.time.Duration;

//import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
//import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.poc.elements.Poc_HomePage_Elements;

public class Poc_Home_page {
	
	WebDriver driver;
	Poc_HomePage_Elements homePageElements;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	public static Logger logger = LogManager.getLogger(Poc_Home_page.class);
	
	public Poc_Home_page(WebDriver driver) {
		this.driver = driver;
		homePageElements = new Poc_HomePage_Elements(driver);
	}
	
	/** Method Name: isHomepageDisplayed
	 * Description : This method verifies whether the home page logo is displayed
	 * @return boolean - true if homepage displayed else false
	 */
	public boolean isHomepageDisplayed() {
		try {
		return homePageElements.HomePageLogo.isDisplayed();
		}catch(Exception e) {
			logger.error("Home page logo not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	/** Method Name: SignuporLoginLinkClick
	 * Description : This method clicks on Signup or Login link
	 */
	public void SignuporLoginLinkClick() {
		try {
		homePageElements.Signup_Login_Link.click();
		}catch(Exception e) {
			logger.error("Signup or Login link click failed with exception: "+e.getMessage());
			Assert.fail("Signup or Login link click failed");
		}
	}
	
	/** Method Name: SignuporLoginLinkDisplayCheck
	 * Description : This method verifies whether the Signup or Login link is displayed
	 * @return boolean - true if signuporLogin link displayed else false
	 */
	public boolean SignuporLoginLinkDisplayCheck() {
		try {
		wait.until(ExpectedConditions.visibilityOf(homePageElements.Signup_Login_Link));
		return homePageElements.Signup_Login_Link.isDisplayed();
		}catch(Exception e) {
			logger.error("Signup or Login link not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	/** Method Name: contactUsLinkClick
	 * Description : This method clicks on Contact us link
	 */
	public void contactUsLinkClick() {
		try {
		homePageElements.contactUsLink.click();
		}catch(Exception e) {
			logger.error("Contact us link click failed with exception: "+e.getMessage());
			Assert.fail("Contact us link click failed");
		}
	}
	
	/** Method Name: sliderCheck
	 * Description : This method verifies whether the slider is displayed
	 * @return boolean - true if slider displayed else false
	 */
	public boolean sliderCheck() {
		try {
		wait.until(ExpectedConditions.visibilityOf(homePageElements.slider));
		return homePageElements.slider.isDisplayed();
		}catch(Exception e) {
			logger.error("Slider not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	/** Method Name: testcasesLinkClick
	 * Description : This method clicks on Test cases link
	 */
	public void testcasesLinkClick() {
		try {
		homePageElements.testCasesLink.click();
		}catch(Exception e) {
			logger.error("Test cases link click failed with exception: "+e.getMessage());
			Assert.fail("Test cases link click failed");
		}
	}
	
	/** Method Name: subscriptionTitleCheck
	 * Description : This method verifies whether the subscription title is displayed
	 * @return boolean - true if subscription title displayed else false
	 */
	public boolean subscriptionTitleCheck() {
		try {
		return homePageElements.subscriptionTitle.isDisplayed();
		}catch(Exception e) {
			logger.error("Subscription title not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	/** Method Name: subscriptionSuccessMsgCheck
	 * Description : This method verifies whether the subscription success message is displayed
	 * @return boolean - true if subscription success message displayed else false
	 */
	public boolean subscriptionSuccessMsgCheck() {
		try {
		return homePageElements.subscriptionSuccessMsg.isDisplayed();
		}catch(Exception e) {
			logger.error("Subscription success message not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	/** Method Name: enterSubscriptionEmail
	 * Description : This method enters email in subscription textbox
	 * @param Email - String - email to be entered
	 */
	public void enterSubscriptionEmail(String Email) {
		try {
		homePageElements.subscribeEmailTxtBox.sendKeys(Email);
		}catch(Exception e) {
			logger.error("Entering subscription email failed with exception: "+e.getMessage());
			Assert.fail("Entering subscription email failed");
		}
	}
	
	/** Method Name: subscribeBtnClick
	 * Description : This method clicks on subscribe button
	 */
	public void subscribeBtnClick() {
		try {
		homePageElements.subscribeBtn.click();
		}catch(Exception e) {
			logger.error("Subscribe button click failed with exception: "+e.getMessage());
			Assert.fail("Subscribe button click failed");
		}
	}
	
	/** Method Name: cartLinkClick
	 * Description : This method clicks on Cart link
	 */
	public void cartLinkClick() {
		try {
		homePageElements.cartLink.click();
		}catch(Exception e) {
			logger.error("Cart link click failed with exception: "+e.getMessage());
			Assert.fail("Cart link click failed");
		}
	}
	
	/** Method Name: productsLinkClick
	 * Description : This method clicks on Products link
	 */
	public void productsLinkClick() {
		try {
		homePageElements.productsLink.click();
		}catch(Exception e) {
			logger.error("Products link click failed with exception: "+e.getMessage());
			Assert.fail("Products link click failed");
		}
	}
	
	/** Method Name: viewProductClick
	 * Description : This method clicks on View Product button for a specific product number
	 * @param ProductNo - int - product number whose View Product button to be clicked
	 */
	public void viewProductClick(int ProductNo) {
		try {
		WebElement viewProduct = driver.findElement(By.xpath("//a[@href='/product_details/"+ProductNo+"']"));
		viewProduct.click();
		}catch(Exception e) {
			logger.error("View Product "+ProductNo+" button click failed with exception: "+e.getMessage());
			Assert.fail("View Product "+ProductNo+" button click failed");
		}
	}
	
	/** Method Name: scrollToRecommendedItems
	 * Description : This method scrolls to Recommended items section
	 */
	public void scrollToRecommendedItems() {
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",homePageElements.recommendedItemsTitle);
	   		}catch(Exception e) {
			logger.error("Scrolling to Recommended items section failed with exception: "+e.getMessage());
			Assert.fail("Scrolling to Recommended items section failed");}
		}
	
	
	public void selectRecommendedProductandAddtoCart(String productName) {
		try {
	    WebElement addtoCart = driver.findElement(By.xpath("//div[@class='recommended_items']//p[text()='"+productName+"']//parent::div/a"));	
	    wait.until(ExpectedConditions.visibilityOf(addtoCart));
	    	 addtoCart.click();
		}catch(Exception e) {
		logger.error("Recommended product "+productName+" not found with exception: "+e.getMessage());
		Assert.fail("Recommended product "+productName+" not found");
		}
	 
	}
	
	/** Method Name: clickOnCategoryLink
	 * Description : This method clicks on a specific category link
	 * @param categoryName - String - category name whose link to be clicked
	 */
	public void clickOnCategoryLink(String categoryName) {
		try {
			WebElement categoryLink = homePageElements.getCategoryLink(categoryName);
			categoryLink.click();
		}catch(Exception e) {
			logger.error("Category link "+categoryName+" click failed with exception: "+e.getMessage());
			Assert.fail("Category link "+categoryName+" click failed");
		}
	}
	
	/** Method Name: clickOnSubCategoryLink
	 * Description : This method clicks on a specific sub-category link
	 * @param subCategoryName - String - sub-category name whose link to be clicked
	 */
	public void clickOnSubCategoryLink(String subCategoryName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(homePageElements.getSubCategoryLink(subCategoryName)));
			homePageElements.getSubCategoryLink(subCategoryName).click();
		}catch(Exception e) {
			logger.error("Category link "+subCategoryName+" click failed with exception: "+e.getMessage());
			Assert.fail("Category link "+subCategoryName+" click failed");
		}
	}
	
	/** Method Name: categoryTitleCheck
	 * Description : This method verifies whether the category title is displayed
	 * @return boolean - true if category title displayed else false
	 */
	public boolean categoryTitleCheck() {
		try {
		return homePageElements.CategoryTitle.isDisplayed();
		}catch(Exception e) {
			logger.error("Category title not displayed with exception: "+e.getMessage());
			return false;
		}	
  }
	
	
	public boolean brandProductsTitleCheck(String brandName) {
		try {
		return homePageElements.getBrandProductsTitle(brandName).isDisplayed();
		}catch(Exception e) {
			logger.error("Brand products title not displayed with exception: "+e.getMessage());
			return false;
		}
	}
	
	public void scrollToTop() {
		try {
		homePageElements.scrollUpLink.click();
	   	}catch(Exception e) {
			logger.error("Scrolling to top failed with exception: "+e.getMessage());
			Assert.fail("Scrolling to top failed");}
	}	
	
	public boolean fullFledgedPracticeWebsiteTextCheck() {
		try {
		return homePageElements.fullFledgedPracticeWebsiteText.isDisplayed();
		}catch(Exception e) {
			logger.error("Full Fledged Practice Website text not displayed with exception: "+e.getMessage());
			return false;
		}	
  }
}
	
