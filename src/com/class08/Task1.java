package com.class08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilis.CommonMethods;

public class Task1 extends CommonMethods{
	/*
	 * Task One
Ahead to http://uitestpractice.com/Students/Index
Click on the Actions
Click on the click me !
Handle the alert and click okay
Double Click Double Click Me !
Handle the alert and click okay
Close the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http://uitestpractice.com/Students/Index");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Actions']")).click();
		Thread.sleep(1000);
		
		WebElement click = driver.findElement(By.cssSelector("button[name='click']"));
		Actions act = new Actions(driver);
		act.moveToElement(click).click().perform();
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(1000);
		
		WebElement btn = driver.findElement(By.cssSelector("button[name='dblClick']"));
		act.doubleClick(btn).perform();
		Thread.sleep(1000);
		alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		
		driver.quit();

	}

}
