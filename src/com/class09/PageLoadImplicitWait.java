package com.class09;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadImplicitWait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("http://cnn.com");
	    
	    driver.findElement(By.linkText("World")).click();
	    
	    boolean isDisp = driver.findElement(By.xpath("//h1[text()='World']")).isDisplayed();
	    if(isDisp) {
	    	System.out.println("Element is present");
	    }else {
	    	System.out.println("Element is not present");
	    }
	    
	    driver.quit();

	}

}
