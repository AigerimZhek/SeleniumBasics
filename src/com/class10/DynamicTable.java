package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilis.CommonMethods;

public class DynamicTable extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		 String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx";
		 setUpDriver("chrome", url);
		 
		sendText(driver.findElement(By.cssSelector("input[id$='username']")),"Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "test");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		//get number of rows and cols
		List <WebElement> rows =  driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr"));
		List <WebElement> cols = driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[1]/th"));
		/*//get data row by row
		for(WebElement el:rows) {
			System.out.println(el.getText());
		}*/
		
		//click on the checkbox next to susan mclaren
		String expectedValue = "Susan McLaren";
		
		for(int i=1; i<=rows.size(); i++) {
			String rowText = driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+i+"]")).getText();
			if(rowText.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+i+"]/td[13]")).click();
			}
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
