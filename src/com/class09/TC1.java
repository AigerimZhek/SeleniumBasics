package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilis.CommonMethods;

public class TC1 extends CommonMethods{
	/*
	 * TC 1: Verify element is present
Open chrome browser
Go to “https://the-internet.herokuapp.com/”
Click on “Click on the “Dynamic Loading” link
Click on “Example 1...” and click on “Start”
Verify element with text “Hello World!” is displayed
Close the browser
	 */
	
	public static void main(String[] args) {
		setUpDriver("chrome", "https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
		
		WebElement el = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
		
		if(el.isDisplayed()) {
			System.out.println("element is displayed");
		}else {
			System.out.println("element is not displayed");
		}
		
		driver.close();
		
	}

}
