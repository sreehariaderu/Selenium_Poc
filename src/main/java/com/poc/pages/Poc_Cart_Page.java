package com.poc.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.poc.elements.Poc_CartPage_Elements;

public class Poc_Cart_Page {
	WebDriver driver;
	Poc_CartPage_Elements cartPageElements;
	public static Logger logger = LogManager.getLogger(Poc_Cart_Page.class);
	
	public Poc_Cart_Page(WebDriver driver) {
		this.driver = driver;
		cartPageElements = new Poc_CartPage_Elements(this.driver);
	}
	
	/** Method Name: cartProductsCount
	 * Description : This method returns the count of products in the cart
	 * @return int - count of products in the cart
	 */
	public int cartProductsCount() {
		return cartPageElements.tableBodyRows.size();
	}
	
	public List<LinkedHashMap<String,String>> getCartProductsInfo(String tableId) {
		try {
		List<LinkedHashMap<String,String>>  actualProductInfo = new ArrayList<>();
		int totalRows = cartProductsCount();
		for (int i=1;i<=totalRows;i++) {
			LinkedHashMap<String,String> productsInfo = new LinkedHashMap<>();
			String productName = driver.findElement(By.xpath("//table[@id='"+tableId+"']/tbody/tr[@id='product-"+i+"']/td[@class='cart_description']//a")).getText();
			String productPrice = driver.findElement(By.xpath("//table[@id='"+tableId+"']/tbody/tr[@id='product-"+i+"']/td[@class='cart_price']//p")).getText();
			String productQty = driver.findElement(By.xpath("//table[@id='"+tableId+"']/tbody/tr[@id='product-"+i+"']/td[@class='cart_quantity']//button")).getText();
			String productTotalCost =driver.findElement(By.xpath("//table[@id='"+tableId+"']/tbody/tr[@id='product-"+i+"']/td[@class='cart_total']//p")).getText();
			productsInfo.put("Product "+i,productName);
			productsInfo.put("Price",productPrice);
			productsInfo.put("Qty",productQty);
			productsInfo.put("totalCost",productTotalCost);
			
			actualProductInfo.add(productsInfo);
		}
		
		return actualProductInfo;
		}catch(Exception e) {
			logger.error("Getting cart products info failed with exception: "+e.getMessage());
			return null;
		}
		
	}
	
	/** Method Name: getProductQty
	 * Description : This method returns the quantity of a product in the cart based on the product number
	 * @param productNum - int - product number in the cart
	 * @return String - quantity of the product
	 */
	public String getProductQty(int productNum) {
		try {
		return cartPageElements.qtyInCart(productNum).getText();
		}catch(Exception e) {
			logger.error("Getting product quantity failed with exception: "+e.getMessage());
			return null;
		}
	}
	
	/** Method Name: checkProductInCart
	 * Description : This method checks if a product is present in the cart
	 * @param productName - String - name of the product to check
	 * @return boolean - true if product is present, false otherwise
	 */
	public boolean checkProductInCart(String productName) {
		try {
		List<WebElement> products = cartPageElements.productsInCart;
		for(WebElement product : products) {
			if (product.getText().contains(productName)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
	}	catch(Exception e) {
			logger.error("Checking product in cart failed with exception: "+e.getMessage());
			return false;
		}
		return false;
	}
	
	/** Method Name: deleteProductFromCart
	 * Description : This method deletes a product from the cart based on the product name
	 * @param productName - String - name of the product to delete
	 */
	public void deleteProductFromCart(String productName) {
		try {
		   cartPageElements.deleteProductBtn(productName).click();
		}catch(Exception e) {
			logger.error("Deleting product from cart failed with exception: "+e.getMessage());
			Assert.fail("Deleting product from cart failed");
		}
	}
	
	/** Method Name: mouseHoverOnDeleteBtnAndClick
	 * Description : This method performs mouse hover on delete button of a product and clicks it
	 * @param productName - String - name of the product to delete
	 */
	public void mouseHoverOnDeleteBtnAndClick(String productName) {
		try {
		Actions actions = new Actions(this.driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		actions.moveToElement(cartPageElements.deleteProductBtn(productName)).click().perform();
		wait.until(ExpectedConditions.invisibilityOf(cartPageElements.deleteProductBtn(productName)));
		}catch(Exception e) {
			logger.error("Mouse hover on delete button and click failed with exception: "+e.getMessage());
			Assert.fail("Mouse hover on delete button and click failed");
		}
	}
	

}
