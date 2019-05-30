package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilis.CommonMethods;

public class HWTC2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * TC 1: Table headers and rows verification1.Open browser and go to
		 * “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
		 * 2.Login to the application 3.Create an Order 4.Verify order of that person is
		 * displayed in the table “List of All Orders” 5.Click on edit of that specific
		 * order 6.Verify each order details 7.Update street address 8.Verify in the
		 * table that street has been updated 9.Close browser
		 */
		String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
		setUpDriver("chrome", url);

		sendText(driver.findElement(By.cssSelector("input[id$='username']")), "Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "test");
		driver.findElement(By.cssSelector("input[value='Login']")).click();

		driver.findElement(By.linkText("Order")).click();

		WebElement element = driver.findElement(By.cssSelector("select[id$='Product']"));
		selectValueFromDD(element, 1);

		element = driver.findElement(By.cssSelector("input[id$='Quantity']"));
		sendText(element, "2");

		element = driver.findElement(By.cssSelector("input[id$='txtName']"));
		sendText(element, "Aigerim Zhek");

		element = driver.findElement(By.cssSelector("input[id$='Box2']"));
		sendText(element, "Rockville Pike");

		element = driver.findElement(By.cssSelector("input[id$='Box3']"));
		sendText(element, "Rockville");

		element = driver.findElement(By.cssSelector("input[id$='Box4']"));
		sendText(element, "MD");

		element = driver.findElement(By.cssSelector("input[id$='Box5']"));
		sendText(element, "20852");

		element = driver.findElement(By.cssSelector("input[value^='Master']"));
		RadioButton(element);

		element = driver.findElement(By.cssSelector("input[id$='Box6']"));
		sendText(element, "0000111122223333");

		element = driver.findElement(By.cssSelector("input[id$='Box1']"));
		sendText(element, "02/22");

		Thread.sleep(2000);

		driver.findElement(By.linkText("Process")).click();

		driver.findElement(By.linkText("View all orders")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		String valueToFind = "Aigerim";

		for (int i = 1; i <= rows.size(); i++) {

			String rowText = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + i + "]")).getText();
			if (rowText.contains(valueToFind)) {
				driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[13]")).click();
				break;
			}
		}

		element = driver.findElement(By.cssSelector("select[id$='Product']"));
		verifyEntry(element, "FamilyAlbum");
		element = driver.findElement(By.cssSelector("input[id$='Quantity']"));
		verifyEntry(element, "2");
		element = driver.findElement(By.cssSelector("input[id$='txtName']"));
		verifyEntry(element, "Aigerim Zhek");
		element = driver.findElement(By.cssSelector("input[id$='Box2']"));
		verifyEntry(element, "Rockville Pike");
		element = driver.findElement(By.cssSelector("input[id$='Box3']"));
		verifyEntry(element, "Rockville");
		element = driver.findElement(By.cssSelector("input[id$='Box4']"));
		verifyEntry(element, "MD");
		element = driver.findElement(By.cssSelector("input[id$='Box5']"));
		verifyEntry(element, "20852");
		element = driver.findElement(By.cssSelector("input[value^='Master']"));
		System.out.println("RadioButton was selected: " + element.isSelected());
		element = driver.findElement(By.cssSelector("input[id$='Box6']"));
		verifyEntry(element, "0000111122223333");
		element = driver.findElement(By.cssSelector("input[id$='Box1']"));
		verifyEntry(element, "02/22");

		element = driver.findElement(By.cssSelector("input[id$='Box2']"));
		sendText(element, "Shady Grove road");

		Thread.sleep(2000);

		driver.findElement(By.linkText("Update")).click();

		driver.findElement(By.linkText("View all orders")).click();
		
		String street = "Shady Grove road";
		for (int i = 1; i <= rows.size(); i++) {
			String rowText = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + i + "]")).getText();
			if (rowText.contains(valueToFind) && rowText.contains(street)) {
				System.out.println("The street name was updated");
				break;
			}
	}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
