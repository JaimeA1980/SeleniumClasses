 package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class TC2TableHeadersAndRowsVerification extends CommonMethods{
//	1.chrome browser
//	2.Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
//	3.Login to the application
//	4.Verify customer “Susan McLaren” is present in the table
//	5.Click on customer details
//	6.Update customers last name 
//	7.Verify updated customers name is displayed in table
//	8.Close browserTest Case
	
public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		String expectedValue = "Susan McLaren";
		
		
		List<WebElement> rows =  driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for (int i = 1; i<rows.size(); i++) { 
			String rowText = rows.get(i).getText(); 
			
			if(rowText.contains(expectedValue)) {													
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(i+1)+"]/td[13]")).click();
				System.out.println("Susan McLaren is listed");
				break;
			}
		}
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).clear();
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).sendKeys("Susan Gallegos");
		driver.findElement(By.xpath("//a[text()='Update']")).click();
		expectedValue="Susan Gallegos";
		List<WebElement> rows2=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for (int i = 1; i<rows2.size(); i++) {
			String rowText2 =rows2.get(i).getText();
			if(rowText2.contains(expectedValue)) {
				String suzysNewName =driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr["+(i+1)+"]/td[2]")).getText();
				System.out.println("Suzy got married to a Galician so her new name is "+suzysNewName);
			}
		}
		
		Thread.sleep(10000);
		driver.quit();
	}

}
