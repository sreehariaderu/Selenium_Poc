package com.poc.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_ProductsPage_Elements {
	
	WebDriver driver;
	@FindBy(xpath="//button[text()='Continue Shopping']")  public WebElement continueShoppingBtn;
	@FindBy(xpath="//u[text()='View Cart']")  public WebElement viewCartLink;
    @FindBy(xpath="//div[@class='brands_products']") public WebElement brandsSection;
    @FindBy(xpath="//h2[text()='All Products']") public WebElement allProductsTitle;
    @FindBy(id="search_product") public WebElement searchProductTxtBox;
    @FindBy(id="submit_search") public WebElement searchBtn;
	
	public Poc_ProductsPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	public WebElement getProductBynumber(int ProductNo) {
		String productXpath ="//img[@src='/get_product_picture/"+ProductNo+"']";
		return driver.findElement(By.xpath(productXpath));
	}
	
	
	public WebElement getAddToCartBtn(int ProductNo) {
		String addToCartXpath ="//img[@src='/get_product_picture/"+ProductNo+"']/parent::div/a";
		return driver.findElement(By.xpath(addToCartXpath));
	}
	
	public WebElement getBrandNameLink(String brandName) {
		return driver.findElement(By.xpath("//a[text()='"+brandName+"']"));
	}
	
	public WebElement getViewProductLink(int productNo) {
		return driver.findElement(By.xpath("//a[@href='/product_details/"+productNo+"' and text()='View Product']"));
	}

}
