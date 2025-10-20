package com.poc.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_ProductDetailsPage_Elements {
	
	WebDriver driver;
	@FindBy(id="quantity")  public WebElement qtyTxtBox;
	@FindBy(xpath="//button[@class='btn btn-default cart']")  public WebElement addtoCartBtn;
	@FindBy(xpath="//a[text()='Write Your Review']") public WebElement writeYourReviewLink;
	@FindBy(id="name") public WebElement reviewNameTxtBox;
	@FindBy(id="email") public WebElement reviewEmailTxtBox;
	@FindBy(id="review") public WebElement reviewTextTxtBox;
	@FindBy(id="button-review") public WebElement submitReviewBtn;
	@FindBy(xpath="//span[text()='Thank you for your review.']") public WebElement reviewSubmissionMsg;
	
	public Poc_ProductDetailsPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	public WebElement getProductName(String productName) {
		return driver.findElement(By.xpath("//div[@class='productinfo text-center']//p[text()='"+productName+"']"));
	}

}
