package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver launchBrowser(String browsername) {
		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("Invalid BrowSer Name");
			break;
		}

		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	public static void fillTextBox(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static void btnClick(WebElement e) {
		e.click();
	}

	public static void quit() {
		driver.quit();

	}

	public static String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}

	public static String getTitle() {
		return driver.getTitle();

	}

	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");

	}

	public static void moveToElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public static void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static WebElement findElement(String locatorName, String locValue) {
		WebElement e = null;
		if (locatorName.equals("id")) {
			e = driver.findElement(By.id(locValue));
		} else if (locatorName.equals("name")) {
			e = driver.findElement(By.name(locValue));
		} else if (locatorName.equals("xpath")) {
			e = driver.findElement(By.xpath(locValue));
		}
		return e;

	}

	public static void takeScreenShot(String imagename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShots\\" + imagename + ".png");
		FileUtils.copyFile(src, des);

	}

	public static void jsSendKeys(WebElement e, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", e);

	}

	public static String getExcelData(String file, String sheetname, int rowno, int cellno) throws IOException {
		File loc = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\"
				+ file + ".xlsx");
		FileInputStream st = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(st);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);

		int type = cell.getCellType();
		// type--0-->Date,number
		// type--1--->String
		String value = null;
		if (type == 1) {
			value = cell.getStringCellValue();
		} else {
			if (DateUtil.isCellDateFormatted(cell)) {
				value = new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());
			} else {
				value = String.valueOf((long) cell.getNumericCellValue());
			}
		}
		return value;	}
}
