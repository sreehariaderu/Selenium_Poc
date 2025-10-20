package com.poc.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_HomePage_Elements {
	
	WebDriver driver;
	
	@FindBy(id="header") public WebElement HomePageLogo;
	@FindBy(xpath="//a[text()=' Signup / Login']") public WebElement Signup_Login_Link;
	@FindBy(xpath="//a[text()=' Contact us']")  public WebElement contactUsLink;
	@FindBy(xpath="//section[@id='slider']")  public WebElement slider;
	@FindBy(xpath="//a[text()=' Test Cases']") public WebElement testCasesLink;
	@FindBy(id="susbscribe_email")  public WebElement subscribeEmailTxtBox;
	@FindBy(id="subscribe")  public WebElement subscribeBtn;
	@FindBy(xpath="//div[@class='col-sm-3 col-sm-offset-1']//h2[text()='Subscription']")  public WebElement subscriptionTitle;
	@FindBy(xpath="//div[text()='You have been successfully subscribed!']")  public WebElement subscriptionSuccessMsg;
	@FindBy(xpath="//a[text()=' Cart']") public WebElement cartLink;
	@FindBy(xpath="//a[text()=' Products']")  public WebElement productsLink;
	@FindBy(xpath="//div[@class='recommended_items']") public WebElement recommendedItemsTitle;
	@FindBy(xpath="//div[@class='left-sidebar']/h2[text()='Category']") public WebElement CategoryTitle;
	@FindBy(xpath="//a[@id='scrollUp']") public WebElement scrollUpLink;
	@FindBy(xpath="//div[@class='item active']//h2[text()='Full-Fledged practice website for Automation Engineers']") public WebElement fullFledgedPracticeWebsiteText;
	
	public Poc_HomePage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public WebElement getCategoryLink(String categoryName) {
		return driver.findElement(By.xpath("//div[@id='accordian']//a[@href='#"+categoryName+"']"));
	}
	
	public WebElement getSubCategoryLink(String subCategoryName) {
		return driver.findElement(By.xpath("//div[@class='panel-collapse in']//a[text()='"+subCategoryName+" "+"']"));
	}
	
	public WebElement getBrandProductsTitle(String brandName) {
		return driver.findElement(By.xpath("//h2[text()='Brand - "+brandName+" Products']"));
	} 
	   
	
	
	

}
