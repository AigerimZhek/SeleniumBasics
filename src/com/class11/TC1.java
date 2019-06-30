package com.class11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilis.CommonMethods;

public class TC1 extends CommonMethods{

	public static void main(String[] args) {
		/**
		 * TC 1: Upload file and Take Screenshot

            Navigate to “http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
            Upload file
            Verify file got successfully uploaded and take screenshot
		 */
		
		setUpDriver("chrome", "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");
		
		String filePath = "C:\\Users\\zheki\\Desktop\\What-is-Agile-Scrum-Framework.jpg";
		driver.findElement(By.id("gwt-debug-cwFileUpload")).sendKeys(filePath);
		
		driver.findElement(By.cssSelector("button.gwt-Button")).click();
		
		String expected="File uploaded!";
		String actual = getAlertText();
		
		if(actual.equals(expected)) {
			System.out.println("File is uploaded");
		}else {
			System.out.println("File is not uploaded");
		}
	
		acceptAlert();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scr, new File("ScreenShots/Samples/TC1.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screen was not taken");
		}
	
		driver.quit();
		

	}

}
