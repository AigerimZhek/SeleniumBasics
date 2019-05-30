package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryCSS {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Ai");
		driver.findElement(By.cssSelector("input[name*='last']")).sendKeys("Z");
		driver.findElement(By.cssSelector("input#email")).sendKeys("test");
		driver.findElement(By.cssSelector("input[name^='pass']")).sendKeys("123");
		driver.findElement(By.cssSelector("input[name$='Password']")).sendKeys("123");
		driver.findElement(By.cssSelector("input[name='register']")).click();

	}

}
