package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC1 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: Amazon Department List Verification 
		 * Open chrome browser Go to “http://amazon.com/” 
		 * Verify how many department options available. 
		 * Print each department 
		 * Select Computers 
		 * Quit browser
		 */
		
		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://amazon.com/");
		
		Thread.sleep(2000);
		
		WebElement dept  = driver.findElement(By.cssSelector("#searchDropdownBox"));
		
		Select select = new Select(dept);
		List <WebElement> allOptions = select.getOptions();
		System.out.println("Number of options in Department DD " +allOptions.size());
		
		for(WebElement option:allOptions) {
			System.out.println(option.getText());
		}
		
		select.selectByVisibleText("Computers");
		
		Thread.sleep(7000);
		
		driver.quit();

	}

}
