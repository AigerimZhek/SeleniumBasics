package com.class11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilis.CommonMethods;

public class FileUpload extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		String url = "http://the-internet.herokuapp.com";
		setUpDriver("chrome", url);
		
		driver.findElement(By.linkText("File Upload")).click();
		String filePath = "C:\\Users\\zheki\\Desktop\\What-is-Agile-Scrum-Framework.jpg";
		driver.findElement(By.id("file-upload")).sendKeys(filePath);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("file-submit")).click();
		
		boolean isDisp = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed();
		if(isDisp) {
			System.out.println("File has been uploaded successfully");
		}else {
			System.out.println("File hasn't been uploaded");
		}
		Thread.sleep(4000);
		
		//steps to take screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File pic=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(pic, new File("ScreenShots/TheInternet/fileUpload.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ScreenShot was not taken");
		}
	
		driver.quit();
		
		

	}

}
