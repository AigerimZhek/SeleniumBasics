package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilis.CommonMethods;

public class HWTC1 extends CommonMethods{
	
	
	/*
	 * TC 1: Users Application Form Fill
	 * 1.Open chrome browser
	 * 2.Go to “http://uitestpractice.com/”
	 * 3.Click on “Forms” link
	 * 4.Fill out the entire form
	 * 5.Close the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		
		String url="http://uitestpractice.com/";
		setUpDriver("chrome", url);
		
		driver.findElement(By.linkText("Form")).click();
		
		
		WebElement element = driver.findElement(By.cssSelector("input[id='firstname']"));
		sendText(element, "Aigerim");
		
		element = driver.findElement(By.cssSelector("input[id='lastname']"));
		sendText(element, "Z");
		
		 element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div[3]/label[3]")); 
		 RadioButton(element);
		
		element = driver.findElement(By.cssSelector("input[value='read']"));
		checkBox(element);
		
		
		 driver.findElement(By.cssSelector("input#datepicker")).click();
		 element = driver.findElement(By.cssSelector("select[data-handler='selectMonth']"));
		 selectValueFromDD(element, 0);
		 
		 element = driver.findElement(By.cssSelector("select[data-handler='selectYear']"));
		 selectValueFromDD(element, "1996");
		 
		 String expectedDate="10";
			List <WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
			for (WebElement cell: cells) {
				String cellText=cell.getText();
				if (cellText.equals(expectedDate)) {
					cell.click();
				}
			}
		
			
		element = driver.findElement(By.cssSelector("select[id='sel1']"));
		selectValueFromDD(element, "Belarus");
		
		element = driver.findElement(By.cssSelector("input#phonenumber"));
		sendText(element, "123456789");
		
		element = driver.findElement(By.xpath("//input[@id='username']"));
		sendText(element, "aigerim10");
		
		element = driver.findElement(By.xpath("//input[@id='email']"));
		sendText(element, "zhekibaevaa@gmail.com");
		
		element = driver.findElement(By.cssSelector("textarea[id*='com']"));
		sendText(element, "I am a student");
		
		element = driver.findElement(By.cssSelector("input[type*='pass']"));
		sendText(element, "test1");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click(); 
		 
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
