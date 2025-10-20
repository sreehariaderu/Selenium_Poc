package com.poc.elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_AccountInfoPage_Elements {
	WebDriver driver;
	@FindBy(xpath="//div[@class='login-form']/h2/b") public WebElement enterAccountInfoTitle;
	@FindBy(xpath="//input[@name='title']")  public List<WebElement> titleRadiogrp;
	@FindBy(id="password")  public WebElement passwordTxtBox;
	@FindBy(id="days")  public WebElement dayDropdown;
	@FindBy(id="months")  public WebElement monthDropdown;
	@FindBy(id="years")   public WebElement yearDropdown;
	@FindBy(id="newsletter")  public WebElement newsletterCheckBox;
	@FindBy(id="optin")  public WebElement specialOffersCheckBox;
	@FindBy(id="first_name")   public WebElement firstNametxtBox;
	@FindBy(id="last_name")   public WebElement lastNametxtBox;
	@FindBy(id="company")   public WebElement companytxtBox;
	@FindBy(id="address1")   public WebElement address1txtBox;
	@FindBy(id="address2")   public WebElement address2txtBox;
	@FindBy(id="country")   public WebElement countryDropdown;
	@FindBy(id="state")   public WebElement statetxtBox;
	@FindBy(id="city")   public WebElement citytxtBox;
	@FindBy(id="zipcode")   public WebElement zipcodetxtBox;
	@FindBy(id="mobile_number")   public WebElement mobileNumbertxtBox;
	@FindBy(xpath="//button[text()='Create Account']")   public WebElement createAccountBtn;
	@FindBy(xpath="//h2[@data-qa='account-created']")  public WebElement accountCreationSuccessMsg;
	@FindBy(xpath="//a[text()='Continue']")  public WebElement continueLink;
	@FindBy(xpath="//h2[@data-qa='account-deleted']")  public WebElement accountDeletedMsg;
	
	
	

	public Poc_AccountInfoPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	

}
