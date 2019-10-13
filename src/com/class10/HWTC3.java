package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilis.CommonMethods;

public class HWTC3 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: Table headers and rows verification
		 * 1.Open chrome browser
		 * 2.Go to “https://jqueryui.com/”
		 * 3.Click on “Datepicker”
		 * 4.Select August 10 of 2019
		 * 5.Verify date “08/10/2019” has been entered succesfully
		 * 6.Close browser
		 */
		String url = "https://jqueryui.com/";
		setUpDriver("chrome", url);
		
		driver.findElement(By.linkText("Datepicker")).click();
		
		WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.cssSelector("input.hasDatepicker")).click();
		
		String expMonth = "September 2019";
		String val = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(val);
		
		 while(!val.equals(expMonth)){ 
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			val = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		}
		 
		
		List<WebElement> cal = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		String dateToChoose = "10";
		for(WebElement c:cal) {
			String date = c.getText();
			if(date.equals(dateToChoose)) {
				c.click();
			}
		}
		
		String expTxt = "09/10/2019";
		String txt = driver.findElement(By.cssSelector("input#datepicker")).getAttribute("value");
		if(txt.equals(expTxt)) {
			System.out.println("Date has been entered successfully");
		}else {
			System.out.println("Date has not been entered");
		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}
