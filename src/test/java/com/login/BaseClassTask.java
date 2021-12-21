
package com.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTask {
		
		static WebDriver driver;

		public static void getDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		public void type(WebElement element, String data) {
			element.sendKeys(data);
		}
		
		public static void loadUrl(String url) {
			driver.get(url);
		}
		
		public static void closeCurrentTab() {
			driver.close();
		}

		public static void maximize() {
			driver.manage().window().maximize();
		}

		public WebElement findElementById(String data) {
			
			WebElement element = driver.findElement(By.id(data));
			return element;
			
		}
		public WebElement findElementByClassname(String data) {
			WebElement element = driver.findElement(By.className(data));
			return element;

		}	


		public WebElement findElementByName(String data) {
			WebElement element = driver.findElement(By.id(data));
			return element;
		}

		public WebElement findElementByXpath(String data) {
			WebElement element = driver.findElement(By.id(data));
			return element;
		}

		public void click(WebElement element) {
			element.click();
		}

		public void selectOptionByText(WebElement element, String data) {
			Select select = new Select(element);
			select.selectByVisibleText(data);
		}

		public String getAttribute(WebElement element) {
			String data = element.getAttribute("value");
			return data;
		}

		public void createCell(int rowIndex, int columnIndex, String cellValue) throws IOException {
			
			File file = new File("C:\\\\Users\\\\91994\\\\eclipse-workspace\\\\Maven\\\\Excelsheet\\\\sheet001.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(columnIndex);
			
			//to write the data to excel
			cell.setCellValue(cellValue);
			FileOutputStream output = new FileOutputStream(file);
			workbook.write(output);

		}
		
		public String getdata(int rowIndex, int columnIndex) throws IOException   {
			
			File file = new File("C:\\Users\\91994\\eclipse-workspace\\Maven\\Excelsheet\\sheet001.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(rowIndex);//input
			Cell cell = row.getCell(columnIndex);//input
			
			
			
			//to get the data from the excel
			
			 int type = cell.getCellType();
			 
			 //if 1 -------text 
			 //if 0 ----------------- number or data
			if(type==1)
			{
				
				String data = cell.getStringCellValue();
				return data ;
			}else {
				
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
					String data = dateFormat.format(dateCellValue);
					return data;
				} else {
					double d = cell.getNumericCellValue();
					long l = (long) d;
					String data = String.valueOf(l);
					return data;
				}
			}	
		}	
	}