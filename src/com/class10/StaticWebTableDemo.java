package com.class10;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilis.CommonMethods;

public class StaticWebTableDemo extends CommonMethods{

	public static void main(String[] args) {

		setUpDriver("chrome", "https://www.toolsqa.com/automation-practice-table/");
		//getting number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@summary='Sample Table']/tbody/tr"));
		System.out.println(rows.size());
		
		Iterator<WebElement> it = rows.iterator();
		while(it.hasNext()) {
			String rowText = it.next().getText();
			System.out.println(rowText);
		}
		//getting number of columns
		List<WebElement> cols = driver.findElements(By.xpath("//table[@summary='Sample Table']/thead/tr/th"));
		System.out.println(cols.size());
		
		for(WebElement col:cols) {
			String colText=col.getText();
			System.out.println(colText);
		}

	}

}
