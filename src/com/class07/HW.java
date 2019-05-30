package com.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import utilis.CommonMethods;

public class HW extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: ToolsQA Windows verification 
		 * Open chrome browser 
		 * Go to “https://the-internet.herokuapp.com/”
		 * Click on “Multiple Windows” link 
		 * Click on “Elemental Selenium” 
		 * Verify title of second window is “Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro” 
		 * Close second window
		 * Click on “Click Here” link 
		 * Verify title if newly open window is “New Window”
		 * Close second window Verify title of second window is “The Internet” 
		 * Quit browser
		 */
		
		setUpDriver("chrome", "https://the-internet.herokuapp.com/");
		String parent = driver.getTitle();
		String parentId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href*='selenium']")).click();
		Thread.sleep(2000);
		
		Set<String> allWindows = driver.getWindowHandles();
		Iterator <String> it = allWindows.iterator();
		parent=it.next();
		String child1 = it.next();
		driver.switchTo().window(child1);
		
		child1 =driver.getTitle();
		String childId = driver.getWindowHandle();
		System.out.println("Title: "+child1+" ID: "+childId);
		
		if(child1.equals("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro")) {
			System.out.println("The title of the second window is displayed");
		}
	
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[href*='new']")).click();
		allWindows = driver.getWindowHandles();
		it = allWindows.iterator();
		parent = it.next();
		
		String child2 = it.next();
		driver.switchTo().window(child2);
		
		child2=driver.getTitle();
		String child2Id = driver.getWindowHandle();
		
		Thread.sleep(2000);
		
		System.out.println("Title: "+child2+" ID: "+child2Id);
		if(child2.equals("New Window")) {
			System.out.println("The title of the third window is displayed");
		}
		
		driver.close();
		
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		parent = driver.getTitle();
		System.out.println("Title: "+parent+" ID: "+parentId);
		if(parent.equals("The Internet")) {
			System.out.println("The title of the first window is displayed");
		}
		
		driver.quit();
	}

}
