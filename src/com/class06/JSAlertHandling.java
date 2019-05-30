package com.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://uitestpractice.com");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Switch to")).click();;
		Thread.sleep(2000);
		driver.findElement(By.id("alert")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		Alert confirmAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		String alertText = confirmAlert.getText();
		System.out.println(alertText);
		Thread.sleep(2000);
		confirmAlert.dismiss();
		Thread.sleep(2000);
		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		Alert promptAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(promptAlert.getText());
		promptAlert.sendKeys("Hello");
		promptAlert.accept();
		Thread.sleep(2000);
	
		driver.quit();

	}

}
