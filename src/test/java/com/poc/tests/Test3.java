package com.poc.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {
    static WebDriver driver;
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/signup");
		driver.findElement(By.name("name")).sendKeys("sreehari");
		driver.findElement(By.xpath("//div[@class='signup-form']//following-sibling::input[@name='email']")).sendKeys("aderusreehari86@gmail.com");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		Thread.sleep(3000);
		List<WebElement>  radio = driver.findElements(By.xpath("//input[@name='title']"));
		for(WebElement r:radio) {
			if(r.getAttribute("value").contentEquals("Mr")) {
				r.click();
			}
		}

	}

}
