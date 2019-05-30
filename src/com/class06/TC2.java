package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC2 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 2: Select and Deselect values Open chrome browser 
		 * Go to “http://uitestpractice.com/” 
		 * Click on “Select” tab 
		 * Verify how many options available in the first drop down and 
		 * then select “United states of America”
		 * Verify how many options available in the second drop down and 
		 * then select all. 
		 * Deselect China from the second drop down 
		 * Quit browser
		 */

		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestpractice.com/");
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Select")).click();
		driver.findElement(By.cssSelector("a[href*='Select']")).click();
		Thread.sleep(2000);
		
		WebElement drop1 = driver.findElement(By.cssSelector("select#countriesSingle"));
		drop1.click();
		Thread.sleep(2000);
		Select s= new Select(drop1);
		
		List<WebElement> list = s.getOptions();
		System.out.println(list.size());
		for(WebElement l:list) {
			System.out.println(l.getText());
		}
		
		s.selectByIndex(1);
		Thread.sleep(2000);
		
		
		WebElement drop2 = driver.findElement(By.cssSelector("select#countriesMultiple"));
		Select s2 = new Select(drop2);
		
		List<WebElement> list2 = s2.getOptions();
		System.out.println(list2.size());
		
		//check if we can select multiple options 
		if(s2.isMultiple()) {
			//select all options
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i).getText());
			s2.selectByIndex(i);
			Thread.sleep(1000);
		}
		}
		
		//enhanced loop
		//for(WebElement l:list2) {
		//	l.click();
		//}
		
		
		Thread.sleep(2000);
		s2.deselectByIndex(2);
		Thread.sleep(5000);
		driver.quit();
	}

}
