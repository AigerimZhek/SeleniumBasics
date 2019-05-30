package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilis.CommonMethods;

public class RightClick extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		
		Thread.sleep(2000);
		
		WebElement rightClick = driver.findElement(By.cssSelector("input#user-name"));
		Actions action = new Actions(driver);
		action.contextClick(rightClick).perform();
		
		Thread.sleep(2000);
		
		
		rightClick=driver.findElement(By.cssSelector("input#password"));
		action.contextClick(rightClick).perform();
		
		Thread.sleep(2000);

		driver.quit();
	}

}
