package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilis.CommonMethods;

public class Task3 extends CommonMethods{
	/*
	 * Task Three
Ahead to http://uitestpractice.com/Students/Index
Click on the Actions
Click and hold on 1,2,3,4 boxes
Close the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("firefox", "http://uitestpractice.com/Students/Index");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Actions']")).click();
		Thread.sleep(1000);

		WebElement one = driver.findElement(By.cssSelector("li[name='one']"));
		WebElement two = driver.findElement(By.cssSelector("li[name='two']"));
		WebElement three = driver.findElement(By.cssSelector("li[name='three']"));
		WebElement eleven = driver.findElement(By.cssSelector("li[name='eleven']"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(one).perform();
		Thread.sleep(1000);
		act.clickAndHold(two).perform();
		Thread.sleep(1000);
		act.clickAndHold(three).perform();
		Thread.sleep(1000);
		act.clickAndHold(eleven).perform();
		Thread.sleep(3000);
		
		driver.close();
	}

}
