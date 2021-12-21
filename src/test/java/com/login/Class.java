package com.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.google.common.collect.Table.Cell;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Class {
	
	WebDriver driver;//========================================================>instance varaible
	
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	 
	}
	
	private void getDriver2() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		

	}
	
	public String title() {
		
		String data = driver.getTitle();
		return data;

	}
	
	public void loadUrl(String Url) {
		driver.get(Url);
	}
	
	public WebElement findElementById(String name) {
		WebElement element = driver.findElement(By.id(name));
		return element;

	}
	
	public WebElement findELementByXpath(String data ) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}
	public void clickBtn(WebElement element) {
		element.click();		
	}
	public void SltOptions(WebElement element,String data) {
		Select select=new Select(element);
		select.selectByVisibleText(data);		
	}
	public void typData(WebElement element,String data) {
		element.sendKeys(data);
	}
	
	public String getData(int rowNo, int cellNo) throws IOException {

		String data = null;

		File file = new File("C:\\Users\\91994\\eclipse-workspace\\Maven\\Excelsheet\\adatichotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();

		if (cellType == 1) {
			data = cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
				data = dateFormat.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				data = String.valueOf(l);
			}
		return data;
		}
	
}

