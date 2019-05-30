package com.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertTC {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: JavaScript alert text verification 
		 * Open chrome browser 
		 * Go to “https://www.seleniumeasy.com/test/javascript-alert-box-demo.html” 
		 * Verify alert box with text “I am an alert box!” is present 
		 * confirm box with text “Press a button!” is present 
		 * prompt box with text “Please enter your name” is present 
		 * Quit browser
		 */

		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[onclick*='A']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		String expectedText = "I am an alert box!";
		if(txt.equals(expectedText)) {
			alert.accept();
			System.out.println("---");
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button[onclick*='C']")).click();
		Thread.sleep(2000);
		alert = driver.switchTo().alert();
		txt = alert.getText();
		expectedText = "Press a button!";
		if(txt.equals(expectedText)) {
			alert.accept();
			System.out.println("---");
		}
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("button[onclick*='P']")).click();
		Thread.sleep(2000);
		alert = driver.switchTo().alert();
		txt = alert.getText();
		expectedText = "Please enter your name";
		if(txt.equals(expectedText)) {
			alert.sendKeys("Aigerim");
			alert.accept();
			System.out.println("---");
		}
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
