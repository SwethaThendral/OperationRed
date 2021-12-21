package com.login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReuseCode {
	
	WebDriver driver;
	int index;
	
	public void getdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
}
	
public void loadUrl(String Url) {
	
	    driver.get("url");  
}
 public void maximize()
   {
		driver.manage().window().maximize();
		}		
 public void type(WebElement element, String data)
   {
   
   element.sendKeys(data);   
}
public void click(WebElement element) 
  {
	  element.click();
  }
public WebElement findElementById(String data)
{
	WebElement element = driver.findElement( By.id(data));
	
	return element;
}
public WebElement findElementByName(String data)
{
	WebElement element = driver.findElement(By.name(data));
	return element;
	
}
public WebElement findElementByXpath(String data)
{
	WebElement element = driver.findElement(By.xpath(data));
	return element;	
}
public String getEnteredUrl()
{
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
	
}

public String getTitle()
{
	String title = driver.getTitle();
	return title;
	
}
public String getAttribute(WebElement element, String attributeName)//=========================>input
{
	
	String string = element.getAttribute(attributeName);
	return string;
	
}

public String getAttribute(WebElement element) {
	String data = element.getAttribute("value");
	return data;
	
}

public void selectOptionsByText(WebElement element,String data)
{
	Select select = new Select(element);
	select.selectByVisibleText(data);
	}
public void selectOptionsByAttribute(WebElement element, String data)

{
	Select select = new Select(element);
	select.selectByIndex(index);
}

public void typeJs(WebElement element, String data)

{
	//JavascriptExecutor executor = (JavaScriptExecutor) driver;
   //executor.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
}

public void SwitchToFrameById(String Id)
{
	driver.switchTo().frame(index);
}


public void switchToFrameByElement(WebElement element) {
	driver.switchTo().frame(element);

}

}

