package com.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TCButtons {

	public static void main(String[] args) throws InterruptedException {
		// * Check all Years of Experience radio buttons are clickable
		//* -----------------------------------------------
		//* Check all Automation Tools checkboxes are clickable
		//* and keep “Selenium WebDriver” option as selected
		
		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		List <WebElement> years = driver.findElements(By.name("exp"));
		for(WebElement year:years) {
			//System.out.println(year.isEnabled());
			year.click();
			Thread.sleep(1000);
		}
		String select = "Selenium Webdriver";

		List <WebElement> tools = driver.findElements(By.name("tool"));
		for(WebElement tool:tools ) {
			if(tool.isEnabled()) {
				tool.click();
				Thread.sleep(2000);
				}
			String value = tool.getAttribute("value");
			if(!value.equals(select)) {
				tool.click();
		        Thread.sleep(2000);
			}
			
		}
		driver.quit();
	}

}
