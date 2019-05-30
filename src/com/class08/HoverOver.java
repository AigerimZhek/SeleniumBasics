package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilis.CommonMethods;

public class HoverOver extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://www.toolsqa.com");
		
		WebElement hover = driver.findElement(By.xpath("//span[text() ='DEMO SITES']"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).click().perform();
		driver.findElement(By.xpath("//span[text()='Automation Practice Switch Windows']")).click();
		Thread.sleep(2000);
		
		driver.quit();

	}

}
