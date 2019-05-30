package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW1 {
	public static String date="05/21/2019";

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: Tools QA check all elements 
		 * Open chrome browser Go to “https://www.toolsqa.com/automation-practice-form/” 
		 * Fill out: First Name Last Name 
		 * Check that sex radio buttons are enabled and select “Male” 
		 * Check all Years of Experience radio buttons are clickable 
		 * Date 
		 * Select both checkboxes for profession 
		 * Check all Automation Tools checkboxes are clickable 
		 * and keep “Selenium WebDriver” option as selected 
		 * Select Africa from DD
		 * MultiSelect DD
		 * Quit browser
		 */

		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("firstname")).sendKeys("Ai");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Z");
		Thread.sleep(2000);
		
		//List <WebElement> ss = driver.findElements(By.name("sex"));
		
		driver.findElement(By.id("sex-1")).isEnabled();
		WebElement male = driver.findElement(By.id("sex-0"));
		if(male.isEnabled() && !male.isSelected()) {
			male.click();
		}
		Thread.sleep(2000);
		
		List <WebElement> elements = driver.findElements(By.cssSelector("input[name*='exp']"));
		int a =elements.size();
		System.out.println(a);
		
		for(WebElement year:elements) {
			year.click();
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[id*='date']")).sendKeys(date);
		Thread.sleep(2000);
		
		elements=driver.findElements(By.xpath("//input[contains(@id,'profession')]"));
		
		for(WebElement prof:elements) {
			prof.click();
		}
		Thread.sleep(2000);
		
		elements = driver.findElements(By.cssSelector("input[name*='tool']"));
		String str = "Selenium Webdriver";
		for (WebElement tool:elements) {
			if(tool.isEnabled() && !tool.isSelected()) {
				tool.click();
				Thread.sleep(1000);
			}
			String value=tool.getAttribute("value");
			if(!value.equals(str)) {
				tool.click();
				Thread.sleep(1000);
			}
		}
		
		
		WebElement conts = driver.findElement(By.name("continents"));
		Select select = new Select(conts);
		List <WebElement> options = select.getOptions();
		System.out.println("Total number of options from the DD "+options.size());
		for(WebElement option:options) {
			System.out.println(option.getText());
		}
		
		select.selectByIndex(2);
		Thread.sleep(2000);
		
		WebElement commands = driver.findElement(By.cssSelector("select[id*='comman']"));
		select = new Select(commands);
		List <WebElement> options1 = select.getOptions();
		System.out.println("Total number of options from the Multiple DD "+options1.size());
		for(int i=0; i<options1.size(); i++) {
			if(select.isMultiple()) {
				System.out.println(options1.get(i).getText());
				select.selectByIndex(i);
				Thread.sleep(1000);
			}
		}
		
		select.deselectByIndex(1);
		Thread.sleep(1000);
		select.deselectByIndex(3);
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
