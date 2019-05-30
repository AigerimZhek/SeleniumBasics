package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilis.CommonMethods;

public class CellByCell extends CommonMethods{

	public static void main(String[] args) {
		
		setUpDriver("chrome", "https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(rows.size());

		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println(cols.size());
		
		for(WebElement row:rows) {
			System.out.println(row.getText());
		}
		
		//how to print value cell by cell
		
		//1. loop through all rows
		//2. loop through all columns
		
		//way#1
		for(int i =1; i<=rows.size(); i++) {
			for(int j = 1; j<= cols.size(); j++) {
				String cellText = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(cellText);
			}
		}
		
		//way#2
		List <WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
		for(WebElement cell:cells) {
			System.out.println(cell.getText());
		}
	}

}
