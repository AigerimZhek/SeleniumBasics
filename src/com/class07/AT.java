package com.class07;

import org.openqa.selenium.By;

import utilis.CommonMethods;

public class AT extends CommonMethods{
	/*
	 * TC 1: ToolsQA Frame verification 
	 * Open chrome browser 
	 * Go to “https://www.toolsqa.com/iframe-practice-page/” 
	 * Click on “Blogs” link inside first frame 
	 * Verify element “Interactions” is present in second frame 
	 * Navigate to Home Page 
	 * Quit browser
	 */

	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUpDriver("chrome", "https://www.toolsqa.com/iframe-practice-page/");
		
		driver.switchTo().frame("iframe1");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a[1]")).click();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("iframe2");
		boolean str = driver.findElement(By.xpath("//h3[text()='Interactions']")).isDisplayed();
		if(str) {
			System.out.println(" element “Interactions” is present in second frame ");
		}
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.quit();

	}

}
