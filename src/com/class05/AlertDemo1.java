package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class AlertDemo1 extends CommonMethods{
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		Thread.sleep(2000);
		//find the element 
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		
		//ojo!!
		Alert alert = driver.switchTo().alert();
		//ojo!!
		Thread.sleep(2000);
		//get the text from alert box. before you hand the alert
		System.out.println("alert text: "+alert.getText());
		//accept alert any positive action. it could be ok
		alert.accept();
		Thread.sleep(2000);
		
		
		
		//get the text from the ui or main window
		String text = driver.findElement(By.xpath("//p[text()='Click the button to display an alert box:']")).getText();
		System.out.println(text);
		
		
	}

}
