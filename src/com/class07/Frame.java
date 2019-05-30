package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilis.CommonMethods;

public class Frame extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");
		
		//1 way:name or id
		//driver.switchTo().frame("iframe_a");
		
		//2 way: weblement
		//WebElement el = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		//driver.switchTo().frame(el);
		
		//3 way:index
		driver.switchTo().frame(0);
		
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#name")).sendKeys("Ai");
		Thread.sleep(2000);
		driver.close();

	}

}
