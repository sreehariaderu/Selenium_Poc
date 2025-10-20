package com.poc.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poc_CartPage_Elements {
	WebDriver driver;
	@FindBy(id="cart_info_table") public WebElement productsTable;
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr")  public List<WebElement> tableBodyRows;
	@FindBy(xpath="//table[@id='cart_info_table']//tbody//td")  public List<WebElement> tableBodyCells;
	@FindBy(xpath="//td[@class='cart_description']//a")  public  List<WebElement> productsInCart;
	@FindBy(xpath="//a[text()='Blue Top']/parent::h4/parent::td//following-sibling::td[@class='cart_delete']/a")  public WebElement deleteBtn;
	
	
	public Poc_CartPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	public WebElement qtyInCart(int productNum) {
		return driver.findElement(By.xpath("//tr[@id='product-"+productNum+"']/td[@class='cart_quantity']/button"));
	}
	
	public WebElement deleteProductBtn(String productName) {
		return driver.findElement(By.xpath("//a[text()='"+productName+"']/parent::h4/parent::td//following-sibling::td[@class='cart_delete']/a"));
	}

}
