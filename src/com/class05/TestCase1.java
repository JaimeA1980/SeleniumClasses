package com.class05;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TestCase1 extends CommonMethods{
		public static final String SYNTAX_PRACTICE_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

		public static void main(String[] args) throws InterruptedException {
		
			CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
			
			driver.findElement(By.linkText("Alerts & Modals")).click();
			driver.findElement(By.linkText("Javascript Alerts")).click();
			driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
			
			
			
			
			
		}


}
