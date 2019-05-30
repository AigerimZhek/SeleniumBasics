package com.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import utilis.CommonMethods;

public class Windows extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");
		String parent = driver.getTitle();
		String parentId = driver.getWindowHandle();
		
		System.out.println("Title: "+parent+" id: "+parentId);
		driver.findElement(By.xpath("//a[text()='Opens in a new window']")).click();
		Thread.sleep(2000);
		
		Set<String> allWindows = driver.getWindowHandles();
		Iterator <String> it = allWindows.iterator();
		parent=it.next();
		String child = it.next();
		driver.switchTo().window(child);
		child = driver.getTitle();
		String childId = driver.getWindowHandle();
		System.out.println("Title: "+child+" id: "+childId);
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		driver.quit();

	}

}
