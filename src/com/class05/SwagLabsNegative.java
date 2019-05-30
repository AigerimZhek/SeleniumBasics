package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsNegative {

	/*
	 * TC 2: Swag Labs Negative login: 
	 * Open chrome browser 
	 * Go to “https://www.saucedemo.com/” 
	 * Enter invalid username and password and click login 
	 * Verify error message contains: “Username and password do not match any user in this service”
	 */

	public static String userName = "standard_use";
	public static String pwd = "secret_sauce";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.saucedemo.com/");

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys(userName);
		driver.findElement(By.cssSelector("input[placeholder*='Pa']")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'btn')]")).click();

		WebElement isDisp = driver.findElement(By.cssSelector("h3[data-test*='err']"));
		String text = isDisp.getText();
		if (text.contains("Username and password do not match any user in this service")) {
			System.out.println("Error message contains 'Username and password do not match any user in this service'");
		} else {
			System.out.println("Error message doesn't contain 'Username and password do not match any user in this service'");
		}

		Thread.sleep(2000);
		driver.close();

	}

}
