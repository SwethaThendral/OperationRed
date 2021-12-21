package com.login;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.List;
	import java.util.Set;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.Select;

	public class Code {
		
		public static WebDriver driver;
		public static Actions a;
		public static Robot r;
		public static JavascriptExecutor js;
		
		
		//1 setup FirefoxDriver
		public static void setFirefoxDriver(String path) {
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
		}
		
		//2 setup chrome driver
		public static void setChromeDriver(String path) {
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
		}
		
		//3 load url
		public static void loadUrl(String url) {
			driver.get(url);
		}
		
		//4 get current url
		public static String getUrl() {
			return driver.getCurrentUrl();
		}
		
		//5 get page title
		public static String getTitle() {
			return driver.getTitle();
		}
		
		//6 maximize window
		public static void maximize() {
			driver.manage().window().maximize();
		}
		
		//7 minimize window
		public static void minimize() {
			driver.manage().window().minimize();
		}
		
		//8 sleep 
		public static void wait(int duration) {
			try {
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//9 find element by id
		public static WebElement findElementById(String id) {
			return driver.findElement(By.id(id));
		}
		
		//10 find element by name
		public static WebElement findElementByName(String name) {
			return driver.findElement(By.name(name));
		}
		
		//11 find element by class name 
		public static WebElement findElementByClassName(String className) {
			return driver.findElement(By.className(className));
		}
		
		//12 find element by xpath 
		public static WebElement findElementByXpath(String xpath) {
			return driver.findElement(By.xpath(xpath));
		}
		
		//13 get text from element
		public static String getText(WebElement element) {
			return element.getText();
		}
		
		//14 get attribute value
		public static String getAttribute(WebElement element, String attribute) {
			return element.getAttribute(attribute);
		}
		
		//15 click element
		public static void click(WebElement element) {
			element.click();
		}
		
		//16 send values to textbox
		public static void setText(WebElement element, String data) {
			element.sendKeys(data);
		}
		
		//17 click ok on alert
		public static void acceptAlert() {
			driver.switchTo().alert().accept();
		}
		
		//18 click cancel on alert
		public static void dismissAlert() {
			driver.switchTo().alert().dismiss();
		}
		
		//19 get alert text
		public static String getAlertText() {
			return driver.switchTo().alert().getText();
		}
		
		//20 switch to frame by id
		public static void switchToFrameById(String id) {
			driver.switchTo().frame(id);
		}
		
		//21 switch to frame by index
		public static void switchToFrameByIndex(int index) {
			driver.switchTo().frame(index);
		}
		
		//22 switch to frame by web element
		public static void switchToFrameByElement(WebElement element) {
			driver.switchTo().frame(element);
		}
		
		//23 switch to window by id
		public static void switchToWindowById(String id) {
			driver.switchTo().window(id);
		}
		
		//24 get all select options 
		public static List<WebElement> getAllOptions(WebElement element) {
			return new Select(element).getOptions();
		}
		
		//25 get all selected options
		public static List<WebElement> getAllSelectedOptions(WebElement element) {
			return new Select(element).getAllSelectedOptions();
		}
		
		//26 get first selected options
		public static  WebElement getFirstSelectOptions(WebElement element) {
			return new Select(element).getFirstSelectedOption();
		}
		
		//27 select by text
		public static void selectOptionByText(WebElement element, String text) {
			new Select(element).selectByVisibleText(text);
		}
		
		//28 select option by value
		public static void selectOptionByValue(WebElement element, String text) {
			new Select(element).selectByValue(text);
		}
		
		//29 select option by index
		public static void selectOptionByIndex(WebElement element, int index) {
			new Select(element).selectByIndex(index);
		}
		
		//30 deselect option by text
		public static void deselectOptionByText(WebElement element, String text) {
			new Select(element).deselectByVisibleText(text);
		}
		
		//31 deselect option by value
		public static void deselectOptionByValue(WebElement element, String text) {
			new Select(element).deselectByValue(text);
		}
		
		//32 deselect option by index
		public static void deselectOptionByIndex(WebElement element, int index) {
			new Select(element).deselectByIndex(index);
		}
		
		//33 cilcking keys by actions
		public static void actionsEnterKeyPress() {
			a = new Actions(driver);
			a.sendKeys(Keys.ENTER);
		}
		
		//34 drag and drop element
		public static void dragAndDrop(WebElement src, WebElement dest) {
			a = new Actions(driver);
			a.dragAndDrop(src, dest).perform();
		}
		
		//35 double click on element
		public static void doubleClick(WebElement element) {
			a = new Actions(driver);
			a.doubleClick(element);
		}
		
		//36 right click on element
		public static void contextClick(WebElement element) {
			a = new Actions(driver);
			a.moveToElement(element).contextClick();
		}
		
		//37 move mouse to location
		public static void moveMouse(int x, int y) throws AWTException {
			r = new Robot();
			r.mouseMove(x, y);
		}
		
		//38 mouse click
		public static void mouseClick(int button) throws AWTException {
			r = new Robot();
			r.mousePress(button);
			r.mouseRelease(button);
		}
		
		//39 press key with robot class
		public static void keyPress(int key) throws AWTException {
			r = new Robot();
			r.keyPress(key);
			r.keyRelease(key);
		}
		
		//40 hold keys for duration
		public static void keyPressAndHold(int key, int duration) throws InterruptedException, AWTException {
			r = new Robot();
			r.keyPress(key);
			Thread.sleep(duration);
			r.keyRelease(key);
		}
		
		//41 press sequence of keys
		public static void sequenceKeyPress(int key1, int key2) {
			r.keyPress(key1);
			r.keyPress(key2);
			r.keyRelease(key2);
			r.keyRelease(key1);
		}
		
		//42 take a screen shot
		
		public static void takeScreenShot(File saveFile) throws IOException {
			TakesScreenshot sct = (TakesScreenshot) driver;
			File screenshot = sct.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, saveFile);
		}
		
		//43 hover over an element
		public static void hoverOverElement(WebElement element) {
			a = new Actions(driver);
			a.moveToElement(element);		
		}
		
		//44 scroll an element into view
		public static void scrollElementToView(WebElement element) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);		
		}
		
		//45 click element by javascript
		public static void clickElementByJs(WebElement element) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
		}
		
		//46 enter value to alert prompt
		public static void sendToAlertPrompt(String data) {
			driver.switchTo().alert().sendKeys(data);
			driver.switchTo().alert().accept();
		}
		
		//47 read data from excel
		public static String readExcel(String path, String sheet, int row, int cell) throws IOException {
			FileInputStream stream = new FileInputStream(new File(path));
			Workbook book = new XSSFWorkbook(stream);
			Cell cellvalue = book.getSheet(sheet).getRow(row).getCell(cell);
			String result = "";
			if (cellvalue.getCellType() == 1) {
				result = cellvalue.getStringCellValue();
			} else if (cellvalue.getCellType() == 0) {
				if (DateUtil.isCellDateFormatted(cellvalue)) {
					result = new SimpleDateFormat("dd/MMM/yy").format(cellvalue.getDateCellValue());
				} else {
					result = String.valueOf((long) cellvalue.getNumericCellValue());
				}
			}
			return result;		
		}
		
		//48 write date to excel
		public static void writeExcel(String path, String sheet, int row, int cell, String data) throws IOException {
			Workbook book = new XSSFWorkbook();
			book.createSheet(sheet).createRow(row).createCell(cell).setCellValue(data);
			FileOutputStream stream = new FileOutputStream(new File(path));
			book.write(stream);
		}
		
		//49 update excel
		public static void updateExcel(String path, String sheet, int row, int cell, String data) throws IOException {
			FileInputStream stream = new FileInputStream(new File(path));
			Workbook book = new XSSFWorkbook(stream);
			book.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
		}
		
		//50 close current page
		public static void closePage() {
			driver.close();
		}
		
		//51 close all pages
		public static void closeAllPages() {
			driver.quit();
		}
		
		//52 replace cell value
		public static void replaceExcel(String path, String sheet, String find, String replace) throws IOException {
			FileInputStream stream = new FileInputStream(new File(path));
			Workbook book = new XSSFWorkbook(stream);
			Sheet mysheet = book.getSheet(sheet);
			for (int i = 0; i < mysheet.getPhysicalNumberOfRows(); i++) {
				Row r = mysheet.getRow(i);
				for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
					Cell mycell = r.getCell(j);				
					if (mycell.getStringCellValue().equals(find)) {
						mycell.setCellValue(replace);
					}
				}
				
			}
		}
		
		//53 is select option multiple enabled
		public static boolean isSelectMultiple(WebElement element) {
			return new Select(element).isMultiple();
		}
		
		//54 clear browser cache
		public static void clearCache() {
			driver.manage().deleteAllCookies();
		}
		
		//55 navigate to url
		public static void navigateToUrl(String url) {
			driver.navigate().to(url);
		}
		
		//56 navigate back
		public static void navigateBack() {
			driver.navigate().back();
		}
		
		//57 navigate forward
		public static void navigateForward() {
			driver.navigate().forward();
		}
		
		//58 clear text box
		public static void clearElementValue(WebElement element) {
			element.clear();
		}
		
		//59 get page source 
		public static String getPageSource() {
			return driver.getPageSource();
		}
		
		//60 get parent window name
		public static String getParentWindow() {
			return driver.getWindowHandle();
		}
		//61 get all window handles
		public static Set<String> getWindowHandles() {
			return driver.getWindowHandles();
		}
			
	}


