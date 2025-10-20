package com.poc.lib;

import org.openqa.selenium.WebDriver;


public class AppLib {
	
	private WebDriver driver;
	private PageLib pagelib;
	private FlowLib flow;
	
	public AppLib(WebDriver driver) {
		this.driver = driver;
		pagelib = new PageLib(this.driver);
		flow = new FlowLib(this.driver);
	}
	
	
	public PageLib pages() {
		return pagelib;
	}
	
	public FlowLib Flow() {
		return flow;
	
	}
}
