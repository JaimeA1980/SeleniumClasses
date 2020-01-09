package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class WebTableDemo extends CommonMethods{
	public static void main(String[] args) {

		setUp("chrome", Constants.SYNTAX_PRACTICE_URL);
		//navigate to the table we need
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//Find how many rows of data table has
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("Number of rows in the table is ="+rows.size());
	
		//Number of Columns
		List<WebElement> cols=driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of cols in the table is ="+cols.size());
		//break till 11:50
	}
}
