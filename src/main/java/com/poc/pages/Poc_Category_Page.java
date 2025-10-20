package com.poc.pages;

import org.openqa.selenium.WebDriver;

import com.poc.elements.Poc_CategoryPage_Elements;

public class Poc_Category_Page {
	WebDriver driver;
	Poc_CategoryPage_Elements categoryPageElements;
	
	public Poc_Category_Page(WebDriver driver) {
		this.driver=driver;
		categoryPageElements = new Poc_CategoryPage_Elements(this.driver);
	}
	
	/** Method Name: isSubCategoryHeaderDisplayed
	 * Description : This method verifies whether the sub-category header is displayed
	 * @param subCategoryTitle - sub-category title to be verified
	 * @return boolean - true if displayed else false
	 */
	public boolean isSubCategoryHeaderDisplayed(String subCategoryTitle) {
		try {
			return categoryPageElements.getSubCategoryHeader(subCategoryTitle).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

}
