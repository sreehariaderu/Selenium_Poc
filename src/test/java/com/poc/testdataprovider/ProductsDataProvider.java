package com.poc.testdataprovider;

import org.testng.annotations.DataProvider;

public class ProductsDataProvider {
	
	@DataProvider(name="RecommendedProducts")
	public Object[][] getdata(){
		return new Object [][] {{"Wnter Top"},{"Stylish Dress"},{"Summer White Top"}};
	}
}
