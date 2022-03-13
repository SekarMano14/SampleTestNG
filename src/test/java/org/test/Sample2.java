package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(op);
		
		
		
		
		
		
	}

}
