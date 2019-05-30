package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookCSS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/zheki/Selenium/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[id^='em']")).sendKeys("2403885131");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#pass")).sendKeys("Aigerim10");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type*=sub]")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
