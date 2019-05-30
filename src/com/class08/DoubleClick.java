package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilis.CommonMethods;

public class DoubleClick extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
        setUpDriver("chrome", "https://www.saucedemo.com/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("double");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.cssSelector("input#user-name"))).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input#password")).sendKeys("double");
		
		Thread.sleep(2000);
		action.doubleClick(driver.findElement(By.cssSelector("input#password"))).perform();
		Thread.sleep(2000);
		driver.close();

	}

}
