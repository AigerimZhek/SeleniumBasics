package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/zheki/Selenium/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.amazon.com");
		System.out.println(driver.getTitle());
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")) {
			System.out.println("title is displayed");
		}else {
			System.out.println("wrong title");
		}
		

	}

}
