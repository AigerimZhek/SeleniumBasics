package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilis.CommonMethods;

public class Task2 extends CommonMethods{
	/*
	 * Task Two
Ahead to http://uitestpractice.com/Students/Index
Click on the Actions
Handle the drag and drop
Close the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http://uitestpractice.com/Students/Index");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Actions']")).click();
		Thread.sleep(1000);
		
		WebElement drag = driver.findElement(By.cssSelector("div#draggable"));
		WebElement drop = driver.findElement(By.cssSelector("div#droppable"));
		
		Actions act = new Actions(driver);
		//act.dragAndDrop(drag, drop).perform();
		act.clickAndHold(drag).moveToElement(drop).release(drag).perform();
		Thread.sleep(2000);
		driver.close();

	}

}
