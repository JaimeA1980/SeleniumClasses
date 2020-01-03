package com.class05;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TestCase2 extends CommonMethods{
	
	public static final String SYNTAX_PRACTICE_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Iframe")).click();
		
		
		driver.switchTo().frame("FrameOne");
		driver.findElement(By.linkText("Home")).click();
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("FrameTwo");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Syntax Technologies']")).isDisplayed();
		Thread.sleep(2000);
		driver.close();
		
		
		
		
	}


}
