package com.poc.lib;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class FlowLib {
	
	private WebDriver driver;
	
	public FlowLib(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getUrl(String url) {
		this.driver.get(url);
	}
	
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	
	public String getPageTitle() {
		return this.driver.getTitle();
	}
	
	public WebDriver switchToOverlayWindow(WebDriver driver) {
		this.driver= driver;
		String mainWondowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		for(String handle:allWindowHandles) {
			if(!handle.equals(mainWondowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		return driver;
		
	}


}
