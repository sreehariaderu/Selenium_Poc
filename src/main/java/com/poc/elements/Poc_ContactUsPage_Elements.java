package com.poc.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_ContactUsPage_Elements {
	
	WebDriver driver;
	@FindBy(xpath="//h2[text()='Get In Touch']")  public WebElement getInTouchTitle;
	@FindBy(name="name") public WebElement nameTxtBox;
	@FindBy(name="email") public WebElement emailTxtBox;
	@FindBy(name="subject") public WebElement subjectTxtBox;
	@FindBy(id="message") public WebElement messageTxtArea;
	@FindBy(name="upload_file")  public WebElement uploadFileBtn;
	@FindBy(name="submit") public WebElement submitBtn;
	@FindBy(xpath="//div[text()='Success! Your details have been submitted successfully.' and @class='status alert alert-success']")  public WebElement detailsSubmittedSuccessMsg;
	@FindBy(xpath="//div[@id='form-section']//a[@class='btn btn-success']")  public WebElement homeLink;
	
	public Poc_ContactUsPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

}
