package com.poc.tests;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.poc.base.AbstractBaseTest;
import com.poc.testdataprovider.ProductsDataProvider;


public class Test1 extends AbstractBaseTest {
	String firstName ="Sreehari";
	String lastName = "Aderu";
	SoftAssert SA = new SoftAssert();
	
	/** Test Case ID : TC_001
	 * Test Case Name: Register_User_Validation
	 * Description: This test case validates user registration functionality with valid details
	 * Precondition: None
	 *Expected Result: User should be registered successfully and username should be displayed
	 */
	@Test(enabled=true)
	public void Register_User_Validation() throws Exception {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		SA.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().SignuporLoginLinkClick();
		boolean signupPageCheck = App().pages().signupOrLoginpage().isSignupTitleDisplayed();
		Assert.assertTrue(signupPageCheck,"Signup page not loaded successfully");
		App().pages().signupOrLoginpage().enterName("Sreehari");
		App().pages().signupOrLoginpage().enterSignupEmailAddress("empirical.prawn.mxix@rapidletter.net");
		App().pages().signupOrLoginpage().signupBtnClick();
		App().pages().accountinfoPage().selectTitleRadioButton("Mr");
		App().pages().accountinfoPage().enterPassword("abcdef@123");
		App().pages().accountinfoPage().selectDayOfBirth("19");
		App().pages().accountinfoPage().selectMonthOfBirth("3");
		App().pages().accountinfoPage().selectYearOfBirth("1986");
		App().pages().accountinfoPage().selectNewsLetterCheckBox();
		App().pages().accountinfoPage().selectSpecialOffersCheckBox();
		App().pages().accountinfoPage().enterFirstName(firstName);
		App().pages().accountinfoPage().enterLaststName(lastName);
		App().pages().accountinfoPage().enterCompany("Infogain");
		App().pages().accountinfoPage().enterAddress1("Choodasandra");
		App().pages().accountinfoPage().enterAddress2("Jail road");
		App().pages().accountinfoPage().selectCountry("India");
		App().pages().accountinfoPage().enterStateName("Karnataka");
		App().pages().accountinfoPage().enterCityName("Bangalore");
		App().pages().accountinfoPage().enterZipCode("560099");
		App().pages().accountinfoPage().enterMobileNumber("9743181554");
		App().pages().accountinfoPage().createAccountBtnClick();
		Assert.assertTrue(App().pages().accountinfoPage().accountCreationCheck(),"Account creation unsuccessful");
		App().pages().accountinfoPage().continueLinkClick();
		boolean isLoggedIn = App().pages().accountinfoPage().userLoginCheck(firstName);
		Assert.assertTrue(isLoggedIn,"User Login failed");
		App().pages().loggedInPage().deleteBtnClick();
		Assert.assertTrue(App().pages().accountinfoPage().accountDeletionCheck(),"Account deletion unsuccessful"); 
		SA.assertAll();
		}
		catch(Exception e){
		logger.error("Test case failed with exception: "+e.getMessage());
		Assert.fail("Test case failed with exception: "+e.getMessage());
		}
		
	}
	
	/** Test Case ID : TC_002
	 * Test Case Name: Login_Validation
	 * Description: This test case validates user login functionality with valid credentials
	 * Precondition: User should be registered successfully
	 *Expected Result: User should be logged in successfully and username should be displayed
	 */
	@Test(enabled=true)
	public void Login_Validation() {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().SignuporLoginLinkClick();
		boolean loginPageCheck = App().pages().signupOrLoginpage().isLoginToYourAccountTitleDisplayed();
		Assert.assertTrue(loginPageCheck,"Signup page not loaded successfully");
		App().pages().signupOrLoginpage().Login("aderusreehari@gmail.ceom", "abcdef123");
		boolean isUserLoggedIn = App().pages().accountinfoPage().userLoginCheck(firstName.toLowerCase()+" "+lastName.toLowerCase());		
		Assert.assertTrue(isUserLoggedIn,"User login failed");
		}
		catch(Exception e) {
			logger.error("Login validation test failed with exception: "+e.getMessage());
			Assert.fail("Login validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_003
	 * Test Case Name: Invalid_Login_Validation
	 * Description: This test case validates user login functionality with invalid credentials
	 * Precondition: User should be registered successfully
	 *Expected Result: User should not be logged in and appropriate error message should be displayed
	 */
	@Test(enabled=true)
	public void Invalid_Login_Validation(){
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().SignuporLoginLinkClick();
		boolean loginPageCheck = App().pages().signupOrLoginpage().isLoginToYourAccountTitleDisplayed();
		Assert.assertTrue(loginPageCheck,"Signup page not loaded successfully");
		App().pages().signupOrLoginpage().Login("aderusreehari123@gmail.com", "abcdef");
		boolean isLoginFailCheck = App().pages().signupOrLoginpage().invalidLoginMessageCheck();
		Assert.assertTrue(isLoginFailCheck,"Invalid login message not displayed");
		}
		catch(Exception e) {
			logger.error("Invalid login validation test failed with exception: "+e.getMessage());
			Assert.fail("Invalid login validation test failed with exception: "+e.getMessage());
		}
		
	}
	
	/** Test Case ID : TC_004
	 * Test Case Name: Logout_Validation
	 * Description: This test case validates user logout functionality
	 * Precondition: User should be logged in successfully
	 *Expected Result: User should be logged out successfully and login link should be displayed
	 */
	@Test(enabled=true)
	public void Logout_Validation() {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().SignuporLoginLinkClick();
		boolean loginPageCheck = App().pages().signupOrLoginpage().isLoginToYourAccountTitleDisplayed();
		Assert.assertTrue(loginPageCheck,"Signup page not loaded successfully");
		App().pages().signupOrLoginpage().Login("aderusreehari@gmail.com", "abcdef123");
		boolean isUserLoggedIn = App().pages().accountinfoPage().userLoginCheck(firstName.toLowerCase()+" "+lastName.toLowerCase());		
		Assert.assertTrue(isUserLoggedIn,"User login failed");
		App().pages().loggedInPage().logoutLinkClick();
		boolean isLogoutSuccess = App().pages().HomePage().SignuporLoginLinkDisplayCheck();
		Assert.assertTrue(isLogoutSuccess,"User Logout unsuccessful");
		}
		catch(Exception e) {
			logger.error("Logout validation test failed with exception: "+e.getMessage());
			Assert.fail("Logout validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_005
	 * Test Case Name: Register_User_With_Existing_Email_Validation
	 * Description: This test case validates user registration functionality with an already registered email address
	 * Precondition: User should be registered successfully
	 *Expected Result: User should not be registered and appropriate error message should be displayed
	 */
	@Test(enabled=true)
	public void Register_User_With_Existing_Email_Validation() {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		SA.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().SignuporLoginLinkClick();
		boolean signupPageCheck = App().pages().signupOrLoginpage().isSignupTitleDisplayed();
		Assert.assertTrue(signupPageCheck,"Signup page not loaded successfully");
		App().pages().signupOrLoginpage().enterName("sreehari");
		App().pages().signupOrLoginpage().enterSignupEmailAddress("aderusreehari86@gmail.com");
		App().pages().signupOrLoginpage().signupBtnClick();
		boolean isEmailAlreadyExists = App().pages().signupOrLoginpage().EmailAlreadyExistsMsgCheck();
		Assert.assertTrue(isEmailAlreadyExists,"Info message not displayed when existing user trying to signup again");
		SA.assertAll();
		}
		catch(Exception e){
			logger.error("Test case failed with exception: "+e.getMessage());
			Assert.fail("Test case failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_006
	 * Test Case Name: Contact_Us_Form_Validation
	 * Description: This test case validates the contact us form functionality
	 * Precondition: None
	 *Expected Result: User should be able to submit the contact us form successfully and navigate back to home page
	 */
	@Test(enabled=true)
	public void Contact_Us_Form_Validation() {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().contactUsLinkClick();
		boolean iscontactsPageDisplayed = App().pages().contactUsPage().getInTouchTitleCheck();
		Assert.assertTrue(iscontactsPageDisplayed,"Contcat us page not displayed");
		App().pages().contactUsPage().enterName("sreehari");
		App().pages().contactUsPage().enterEmail("aderusreehari86@gmail.com");
		App().pages().contactUsPage().enterSubject("uploading a file");
		App().pages().contactUsPage().enterMessage("file upload in progress ,please wait for the file");
		App().pages().contactUsPage().chooseFile("C:\\Users\\sreehari\\eclipse-workspace\\poc\\src\\test\\resources\\Movie reviews.csv");
		App().pages().contactUsPage().submitBtnClick();
		App().pages().contactUsPage().acceptAlert();
		boolean isDtailsSubmittedSuccessfully = App().pages().contactUsPage().detailsSubmittedMsgCheck();
		SA.assertTrue(isDtailsSubmittedSuccessfully,"Details not submitted successfully");
		App().pages().contactUsPage().homeLinkClick();
		boolean isHomePageDisplayed = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(isHomePageDisplayed,"Home page not displayed");
		SA.assertAll();	
		}
		catch(Exception e) {
			logger.error("Contact us form validation test failed with exception: "+e.getMessage());
			Assert.fail("Contact us form validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_007
	 * Test Case Name: Testcases_Page_Validation
	 * Description: This test case validates the navigation to test cases page
	 * Precondition: None
	 *Expected Result: User should be able to navigate to test cases page successfully
	 */
	@Test(enabled=true)
	public void Testcases_Page_Validation() {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().testcasesLinkClick();
		boolean isTestcasePageDisplayed = App().pages().testCasesPage().testcaseTitleCheck();
		Assert.assertTrue(isTestcasePageDisplayed,"Test cases page navigation failed");
		}
		catch(Exception e) {
			logger.error("Test cases page validation test failed with exception: "+e.getMessage());
			Assert.fail("Test cases page validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_008
	 * Test Case Name: Subscription_Validation
	 * Description: This test case validates the subscription functionality from home page
	 * Precondition: None
	 *Expected Result: User should be able to subscribe successfully and success message should be displayed
	 */
	@Test(enabled = true)
	public void Subscription_Validation() throws Exception {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		boolean isSubscriptionTitleDisplayed = App().pages().HomePage().subscriptionTitleCheck();
		Assert.assertTrue(isSubscriptionTitleDisplayed,"Subscription form not displayed");
		App().pages().HomePage().enterSubscriptionEmail("aderusreehari86@gmail.com");
		App().pages().HomePage().subscribeBtnClick();
		boolean isSubscriptionSuccessful = App().pages().HomePage().subscriptionSuccessMsgCheck();
		Assert.assertTrue(isSubscriptionSuccessful,"Subscription not successful");
		}
		catch(Exception e) {
			logger.error("Subscription validation test failed with exception: "+e.getMessage());
			Assert.fail("Subscription validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_009
	 * Test Case Name: Subscription_In_Cart_Page_Validation
	 * Description: This test case validates the subscription functionality from cart page
	 * Precondition: User should have added at least one product to cart
	 *Expected Result: User should be able to subscribe successfully and success message should be displayed
	 */
	@Test(enabled=true)
	public void scubscription_In_Cart_Page_Validation() throws Exception {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().cartLinkClick();
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		boolean isSubscriptionDisplayed = App().pages().HomePage().subscriptionTitleCheck();
		Assert.assertTrue(isSubscriptionDisplayed,"Subscription details not displayed");
		App().pages().HomePage().enterSubscriptionEmail("aderusreehari86@gmail.com");
		App().pages().HomePage().subscribeBtnClick();
		boolean isSubscriptionSuccessful = App().pages().HomePage().subscriptionSuccessMsgCheck();
		Assert.assertTrue(isSubscriptionSuccessful,"Subscription not successful");	
		}
		catch(Exception e) {
			logger.error("Subscription in cart page validation test failed with exception: "+e.getMessage());
			Assert.fail("Subscription in cart page validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_010
	 * Test Case Name: Add_Products_To_Cart_Validation
	 * Description: This test case validates adding multiple products to cart functionality
	 * Precondition: None
	 *Expected Result: All selected products should be added to cart successfully with correct product details
	 */
	@Test(enabled = true)
	public void Add_Products_To_Cart_Validation() throws Exception {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().productsLinkClick();
		App().pages().productsPage().mouseHoverOnProduct(1);
		App().pages().productsPage().addToCartClick(1);
		WebDriver overlayDriver = App().Flow().switchToOverlayWindow(driver);
		App().pages().productsPage().continueShoppingBtnClick(overlayDriver);
		App().pages().productsPage().mouseHoverOnProduct(2);
		App().pages().productsPage().addToCartClick(2);
		WebDriver overlayDriver1 = App().Flow().switchToOverlayWindow(driver);
		App().pages().productsPage().viewCartLinkClick(overlayDriver1);
		int productsInCart = App().pages().cartpage().cartProductsCount();
		Assert.assertEquals(productsInCart,2,"All selected products are not added to cart");
		List<LinkedHashMap<String,String>> actualProdInfo = App().pages().cartpage().getCartProductsInfo("cart_info_table");
		List<LinkedHashMap<String,String>> expectedProdInfo = new ArrayList<>();
		LinkedHashMap<String,String>  ExpectedProd1 = new LinkedHashMap<>();
		ExpectedProd1.put("Product 1","Blue Top");
		ExpectedProd1.put("Price","Rs. 500");
		ExpectedProd1.put("Qty","1");
		ExpectedProd1.put("totalCost","Rs. 500");
		expectedProdInfo.add(ExpectedProd1);
		LinkedHashMap<String,String>  ExpectedProd2 = new LinkedHashMap<>();
		ExpectedProd2.put("Product 2","Men Tshirt");
		ExpectedProd2.put("Price","Rs. 400");
		ExpectedProd2.put("Qty","1");
		ExpectedProd2.put("totalCost","Rs. 400");
		expectedProdInfo.add(ExpectedProd2);
		Assert.assertEquals(actualProdInfo, expectedProdInfo,"Product data in cart is not showing as expected");
		}
		catch(Exception e) {
			logger.error("Add products to cart validation test failed with exception: "+e.getMessage());
			Assert.fail("Add products to cart validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_011
	 * Test Case Name: Product_Quantity_In_Cart_Validation
	 * Description: This test case validates the quantity of a product added to cart functionality
	 * Precondition: None
	 *Expected Result: Quantity of the added product should be displayed correctly in the cart
	 */
	@Test(enabled = true)
	public void Product_Quantity_In_Cart_Validation() throws Exception {
		try {
		int expectedQty=5;
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().viewProductClick(1);
		String pageTitle = App().Flow().getPageTitle();
		Assert.assertTrue(pageTitle.contains("Product Details"));
		App().pages().productdetailsPage().increaseProductQty(expectedQty);
		App().pages().productdetailsPage().addtoCartBtnClick();
		WebDriver overlayDriver = App().Flow().switchToOverlayWindow(driver);
		App().pages().productsPage().viewCartLinkClick(overlayDriver);
		int actualQty = Integer.parseInt(App().pages().cartpage().getProductQty(1));
		Assert.assertEquals(actualQty, expectedQty,"Quantity of the added product is not showing as expected");	
		}
		catch(Exception e) {
			logger.error("Product quantity in cart validation test failed with exception: "+e.getMessage());
			Assert.fail("Product quantity in cart validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_012
	 * Test Case Name: Add_Recommended_Products_Validation
	 * Description: This test case validates adding recommended products to cart functionality
	 * Precondition: None
	 *Expected Result: Recommended products should be added to cart successfully
	 */
	@Test(enabled = true,dataProvider="RecommendedProducts",dataProviderClass=ProductsDataProvider.class)
	public void Add_Recommended_Products_Validation(String product) {
		try {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().scrollToRecommendedItems();
		App().pages().HomePage().selectRecommendedProductandAddtoCart(product);
		WebDriver overlayDriver1 = App().Flow().switchToOverlayWindow(driver);
		App().pages().productsPage().viewCartLinkClick(overlayDriver1);
		boolean isProductAvailable = App().pages().cartpage().checkProductInCart(product);
		Assert.assertTrue(isProductAvailable,"Recommended product not added successfully to cart");
		logger.info("Recommended product "+product+" added successfully to cart");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Add recommended products validation test failed with exception: "+e.getMessage());
		}
	}
	
	/** Test Case ID : TC_013
	 * Test Case Name: Remove_Product_From_Cart_Validation
	 * Description: This test case validates removing a product from cart functionality
	 * Precondition: User should have at least one product added to cart
	 *Expected Result: Selected product should be removed from cart successfully
	 */
	@Test(enabled = true)
	public void Remove_Product_From_Cart_Validation() throws Exception {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().scrollToRecommendedItems();
		App().pages().HomePage().selectRecommendedProductandAddtoCart("Winter Top");
		WebDriver overlayDriver1 = App().Flow().switchToOverlayWindow(driver);
		App().pages().productsPage().viewCartLinkClick(overlayDriver1);
		boolean isProductAvailable = App().pages().cartpage().checkProductInCart("Winter Top");
		Assert.assertTrue(isProductAvailable,"Recommended product not added successfully to cart");
		logger.info("Recommended product Winter Top added successfully to cart");
		App().pages().cartpage().mouseHoverOnDeleteBtnAndClick("Winter Top");
		boolean isProductAvailableCheck = App().pages().cartpage().checkProductInCart("Winter Top");
		Assert.assertFalse(isProductAvailableCheck,"Product not removed from cart");	
	}
	
	/** Test Case ID : TC_014
	 * Test Case Name: View_Category_Products_Validation
	 * Description: This test case validates viewing products by category functionality
	 * Precondition: None
	 *Expected Result: User should be able to view products by selecting category and sub-category successfully
	 */
	@Test(enabled =true)
	public void View_Category_Products_Validation() throws Exception {
		String category = "Women";
		String subCategory = "Dress";
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		Assert.assertTrue(App().pages().HomePage().categoryTitleCheck(),"Category section not displayed in home page");
		App().pages().HomePage().clickOnCategoryLink(category);
		Thread.sleep(2000);
		App().pages().HomePage().clickOnSubCategoryLink(subCategory);
		Thread.sleep(2000);
		String pageTitle =App().Flow().getPageTitle();
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains(subCategory+ " Products" ),"Category products page not displayed");
		Assert.assertTrue(App().pages().categoryPage().isSubCategoryHeaderDisplayed("Women - Dress Products"),"Sub category header not displayed as expected");
		App().pages().HomePage().clickOnCategoryLink("Men");
		Thread.sleep(2000);
		App().pages().HomePage().clickOnSubCategoryLink("Jeans");
		Assert.assertTrue(App().pages().categoryPage().isSubCategoryHeaderDisplayed("Men - Jeans Products"),"Sub category header not displayed as expected");
	}
	
	/** Test Case ID : TC_015
	 * Test Case Name: View_Brand_Products_Validation
	 * Description: This test case validates viewing products by brand functionality
	 * Precondition: None
	 *Expected Result: User should be able to view products by selecting brand successfully
	 */
	@Test(enabled = true)
	public void View_Brand_Products_Validation() {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().productsLinkClick();
		Assert.assertTrue(App().pages().productsPage().isBrandsSectionDisplayed(),"Brands section not displayed in products page");
		App().pages().productsPage().clickBrandNameLink("Polo");
		Assert.assertTrue(App().pages().HomePage().brandProductsTitleCheck("Polo"));
		App().pages().productsPage().clickBrandNameLink("Madame");
		Assert.assertTrue(App().pages().HomePage().brandProductsTitleCheck("Madame"));
	}
	
	/** Test Case ID : TC_016
	 * Test Case Name: Add_Review_On_Product_Validation
	 * Description: This test case validates adding a review on a product functionality
	 * Precondition: None
	 *Expected Result: User should be able to add a review on a product successfully
	 */
	@Test(enabled = true)
	public void Add_Review_On_Product_Validation() {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().productsLinkClick();
		Assert.assertTrue(App().pages().productsPage().isAllProductsTitleDisplayed(),"All products title not displayed");
		App().pages().productsPage().clickViewProductLink(1);
		Assert.assertTrue(App().pages().productdetailsPage().isWriteYourReviewLinkVisible(),"Write your review section not displayed");
		App().pages().productdetailsPage().enterReviewDetails("Sreehari", "aderusreehari86@gmail.com","We are happy with this product quality");
		App().pages().productdetailsPage().submitReviewBtnClick();
		Assert.assertTrue(App().pages().productdetailsPage().isReviewSubmissionMsgVisible(),"Review submission message not displayed");
	}
	
	/** Test Case ID : TC_017
	 * Test Case Name: Scroll_Up_and_Scroll_Down_Validation
	 * Description: This test case validates scrolling up and down functionality on home page
	 * Precondition: None
	 *Expected Result: User should be able to scroll up and down successfully on home page
	 */
	@Test(enabled = true)
	 public void Scroll_Up_using_Arrow_And_Scroll_down_Validation() throws Exception {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Assert.assertTrue(App().pages().HomePage().subscriptionTitleCheck(),"Subscription form not displayed");
		App().pages().HomePage().scrollToTop();
		Assert.assertTrue(App().pages().HomePage().fullFledgedPracticeWebsiteTextCheck(),"Scrolling to top using arrow button failed");
	 }
	
	/** Test Case ID : TC_018
	 * Test Case Name: Scroll_Up_Without_Using_Arrow_And_Scroll_Down_Validation
	 * Description: This test case validates scrolling up without using arrow button and down functionality on home page
	 * Precondition: None
	 * Expected Result: User should be able to scroll up without using arrow button and down successfully on home page
	 */
	@Test(enabled = true)
	 public void Scroll_Up_Without_Using_Arrow_And_Scroll_down_Validation() throws Exception {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Assert.assertTrue(App().pages().HomePage().subscriptionTitleCheck(),"Subscription form not displayed");
		js.executeScript("window.scrollTo(0,0);");
		Assert.assertTrue(App().pages().HomePage().fullFledgedPracticeWebsiteTextCheck(),"Scrolling to top using arrow button failed");
	 }
	
	/** Test Case ID : TC_019
	 * Test Case Name: Search_Products_Validation
	 * Description: This test case validates searching a product functionality
	 * Precondition: None
	 * Expected Result: User should be able to search a product successfully and relevant products should be displayed
	 */
	@Test(enabled = true)
	public void Search_Products_Validation() {
		boolean homePageCheck = App().pages().HomePage().isHomepageDisplayed();
		Assert.assertTrue(homePageCheck,"Home page navigation failed");
		App().pages().HomePage().productsLinkClick();
		Assert.assertTrue(App().pages().productsPage().isAllProductsTitleDisplayed(),"All products title not displayed");
		App().pages().productsPage().enterProductInSearchBox("Blue Top");
		App().pages().productsPage().clickSearchBtn();
		Assert.assertTrue(App().pages().productdetailsPage().isProductNameDisplayed("Blue Top"),"Searched products title not displayed");		
	}

}
