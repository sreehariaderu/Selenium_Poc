package com.poc.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_SignupLoginPage_Elements {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='signup-form']/h2[text()='New User Signup!']")  public WebElement NewUserSignUpTitle;
	@FindBy(name="name") public WebElement NameTxtBox;
	@FindBy(xpath="//div[@class='signup-form']//following-sibling::input[@name='email']") public WebElement SignupEmailTxtBox;
	@FindBy(xpath="//button[text()='Signup']") public WebElement SignupBtn;
	@FindBy(xpath="//div[@class='login-form']/h2[text()='Login to your account']")   public WebElement  loginToYourAccountTitle;
	@FindBy(xpath="//div[@class='login-form']//input[@name='email']")  public WebElement loginEmailTxtBox;
	@FindBy(name="password")  public WebElement  passwordTxtBox;
	@FindBy(xpath="//button[text()='Login']") public WebElement loginBtn;
	@FindBy(xpath="//p[text()='Your email or password is incorrect!']")  public WebElement invalidLoginMsg;
	@FindBy(xpath="//div[@class='signup-form']//p[text()='Email Address already exist!']")  public WebElement EmailAlreadyExistsMsg;
	
	
	public Poc_SignupLoginPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
}
