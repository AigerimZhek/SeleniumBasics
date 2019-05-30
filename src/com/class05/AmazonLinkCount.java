package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLinkCount {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/zheki/Selenium/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("https://www.amazon.com");
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links "+links.size());
		
		Iterator <WebElement> it = links.iterator();
		int count = 0;
		while(it.hasNext()) {
			WebElement link = it.next();
			String withText = link.getText();
			if(!withText.isEmpty()) {
				System.out.println(withText);
				count++;
			}
		}
		System.out.println("Number of links with text "+count);
		driver.quit();

	}

}
