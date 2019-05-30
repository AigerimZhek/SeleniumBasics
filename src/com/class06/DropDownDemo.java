package com.class06;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		Thread.sleep(2000);
		
		//identify DD with <select>
		WebElement countries = driver.findElement(By.cssSelector("select#continents"));
		//Pass to the Select class constructor
		Select select = new Select (countries);
		//find out how many options are available
		List <WebElement> allOptions = select.getOptions();
		System.out.println("Number of options in Countries DD " +allOptions.size());
		
		Iterator <WebElement> it =allOptions.iterator();
		while(it.hasNext()) {
			String option = it.next().getText();
			System.out.println(option);
		}
		
		
		select.selectByVisibleText("Africa");
		Thread.sleep(2000);
		select.selectByIndex(5);
		Thread.sleep(2000);
		
		
		//working with multiselect
		WebElement commandsDD = driver.findElement(By.id("selenium_commands"));
		Select select1 = new Select (commandsDD);
		List <WebElement> allOptions1 = select1.getOptions();
		System.out.println("Number of options in Commands DD " +allOptions1.size());
		
		for(int i=0; i<allOptions1.size(); i++) {
			System.out.println(allOptions1.get(i).getText());
		}
		if(select1.isMultiple()) {
			select1.selectByVisibleText("Navigation Commands");
			Thread.sleep(5000);
			select1.selectByIndex(2);
			select1.selectByIndex(3);
			select1.selectByIndex(4);
			Thread.sleep(5000);

		}
		//deselecting options from the MultipleSelect; You can ONLY deselect options from MULTISELECT!!!
		select1.deselectByIndex(2);
		Thread.sleep(5000);
		select1.deselectByVisibleText("Navigation Commands");
		Thread.sleep(5000);
		driver.quit();

	}

}
