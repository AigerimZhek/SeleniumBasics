package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/zheki/Selenium/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.syntaxtechs.com");
		Thread.sleep(2000);
		driver.navigate().to("http://www.google.com");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Syntax")) {
			System.out.println("Url contains 'syntax'");
		}else {
			System.out.println("Url doesn't contain 'syntax'");
		}
		
		driver.close();
		

	}

}
