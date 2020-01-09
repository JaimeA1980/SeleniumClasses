package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class DynamicTableDemo extends CommonMethods{
	/*Navigate to the WebOrders
	 * "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
	 * log in to WebOrders
	 * click checkbox next to Bob Feather
	 */
	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		String expectedValue = "Bob Feather";
		
		List<WebElement> rows =  driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for (int i = 1; i<rows.size(); i++) { //or i =0
			String rowText = rows.get(i).getText(); //or rows.get(i-1).getText()
			System.out.println(rowText);
			
			if(rowText.contains(expectedValue)) {													//or just i if above commentary was done
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(i)+"]/td[1]")).click();
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
