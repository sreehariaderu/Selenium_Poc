package com.poc.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_LoggedinPage_Elements {
	
	WebDriver driver;
	@FindBy(xpath="//a[text()=' Delete Account']") public WebElement deleteButton;
	@FindBy(xpath="//a[text()=' Logout']")  public WebElement logoutLink;
	
	public Poc_LoggedinPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
