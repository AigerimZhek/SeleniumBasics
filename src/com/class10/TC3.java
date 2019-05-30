package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilis.CommonMethods;

public class TC3 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		String url = "https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url);
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		
		//1 way
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,30);
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@type='text']")));
		 * 
		 * String textToEnter="Sunday";
		 * driver.findElement(By.xpath("//input[@type='text']")).sendKeys(textToEnter);
		 * 
		 * String returnedTxt =
		 * driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
		 * 
		 * //compare entered and returned text if(returnedTxt.equals(textToEnter)) {
		 * System.out.println("Text is entered"); }else {
		 * System.out.println("Text "+textToEnter+" is not entered"); }
		 */
		
		
		//2 way
		//identify the element and then pass it to the expected conditions
		WebElement element = driver.findElement(By.xpath("//input[@type='text']"));
		
		WebDriverWait wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		String textToEnter = "Hi";
		element.sendKeys(textToEnter);
		String enteredText = element.getAttribute("value");
		System.out.println(enteredText);
		
		if(enteredText.equals(textToEnter)) {
			System.out.println("Text is entered");
		}else {
			System.out.println("Text "+textToEnter+" is not entered");
		}
		
		Thread.sleep(5000);
		driver.quit();

	}

}
