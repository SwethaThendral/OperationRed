package com.ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.login.BaseClassTask;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 extends BaseClassTask {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		
	WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 12 (128GB) - Green')]//ancestor::div[@class='a-section a-spacing-none']//child::span[@class='a-price-whole']"));
	
	System.out.println(element.getText());
	
	WebElement ratingElement = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 12 (128GB) - Green')]//ancestor::div[@class='a-section a-spacing-none']//child::span[@class='a-price-whole']"));
	
	Actions action = new Actions(driver);
	
	action.moveToElement(ratingElement).perform();
	action.click(ratingElement).perform();
	
	WebElement rate = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']"));
	
	System.out.println(rate.getText());
	
}
}
