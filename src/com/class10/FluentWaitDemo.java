package com.class10;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import utilis.CommonMethods;

public class FluentWaitDemo extends CommonMethods{

	public static void main(String[] args) {
		String url = "https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url);
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		
	}

}
