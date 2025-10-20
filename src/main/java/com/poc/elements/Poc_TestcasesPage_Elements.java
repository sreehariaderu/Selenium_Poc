package com.poc.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_TestcasesPage_Elements {
	WebDriver driver;
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']//b[text()='Test Cases']")  public WebElement testCasesTitle;
	
	public Poc_TestcasesPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}

}
