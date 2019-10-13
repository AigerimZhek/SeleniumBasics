package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilis.CommonMethods;

public class Task extends CommonMethods{
	
	public static void task(String searchTxt) {
		
		setUpDriver("chrome", "https://www.amazon.com");
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys(searchTxt);
		
		driver.findElement(By.cssSelector("input[value='Go']")).click();
		
		String txt = driver.findElement(By.cssSelector("span[class='a-color-state a-text-bold']")).getText();
		
		String incorrect = driver.findElement(By.cssSelector("span[class='a-size-medium a-color-base']")).getText();
		if(txt.contains(searchTxt)) {
			System.out.println("Search results displayed");
		}else if (incorrect.contains("No results")) {
			System.out.println("Search results not displayed");
		}else {
			System.out.println("Try to check your spelling");
		}
	}

	public static void main(String[] args) {
		
		task("pen");
		
	}

}
