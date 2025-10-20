package com.poc.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Poc_CategoryPage_Elements {
	WebDriver driver;
	
	public Poc_CategoryPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	public WebElement getSubCategoryHeader(String subCategoryTitle) {
		return driver.findElement(By.xpath("//div[@class='features_items']/h2[text()='"+subCategoryTitle+"']"));
	}

}
