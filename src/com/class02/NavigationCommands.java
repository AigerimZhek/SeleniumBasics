package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/zheki/Selenium/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.walmart.com");
		Thread.sleep(1000);
		driver.navigate().to("http://www.google.com");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();

	}

}
