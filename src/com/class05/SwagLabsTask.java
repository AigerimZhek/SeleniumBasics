package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsTask {
	/*
	 * TC 1: Swag Labs Positive login: 
	 * Open chrome browser 
	 * Go to “https://www.saucedemo.com/” 
	 * Enter valid username and valid password and click login 
	 * Verify robot icon is displayed 
	 * Verify “Products” text is available next to the robot icon
	 */

	public static String userName = "standard_user";
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

		boolean display = driver.findElement(By.cssSelector("div[class='peek']")).isDisplayed();

		if (display) {
			System.out.println("Robot icon is displayed");
		} else {
			System.out.println("Robot icon is not displayed");
		}

		WebElement prod = driver.findElement(By.xpath("//div[text()='Products']"));
		String value = prod.getText();
		if (value.contains("Products")) {
			System.out.println("Products icon is displayed. Test case is passed");
		} else {
			System.out.println("Products icon is not displayed. Test case is failed");
		}

		Thread.sleep(2000);
		driver.quit();

	}

}
