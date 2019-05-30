package com.class06;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW2 {
	/*
	 * TC 1: Facebook dropdown verification 
	 * Open chrome browser Go to “https://www.facebook.com” 
	 * Verify: month dd has 12 month options 
	 * day dd has 31 day options 
	 * year dd has 115 year options 
	 * Select your date of birth 
	 * Quit browser
	 */

	public static void select(WebElement element,String sel) {
        Select select = new Select(element);
		
		List <WebElement> options = select.getOptions();
		System.out.println("Number of elements = "+options.size());
		
		Iterator <WebElement> it = options.iterator();
		while(it.hasNext()) {
			String option = it.next().getText();
			System.out.println(option);
		}
		select.selectByVisibleText(sel);
	}

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		WebElement months = driver.findElement(By.cssSelector("select#month"));
		HW2.select(months,"Jan");
		
		WebElement days = driver.findElement(By.cssSelector("select#day"));
		HW2.select(days,"10");
		
		WebElement years = driver.findElement(By.cssSelector("select#year"));
		HW2.select(years,"1996");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
