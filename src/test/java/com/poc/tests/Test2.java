package com.poc.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
	
	WebDriver driver;
	
	@Test
	public void radioCheck() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/signup");
		driver.findElement(By.name("name")).sendKeys("sreehari");
		driver.findElement(By.xpath("//div[@class='signup-form']//following-sibling::input[@name='email']")).sendKeys("aderusreehari86@gmail.com");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		List<WebElement>  radio = driver.findElements(By.xpath("//div[@class='radio-inline']"));
		for(WebElement r:radio) {
			System.out.println(r.getAttribute("id"));
		}
		
		
	}

}
