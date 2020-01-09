package com.class09;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class AlertReviewtask extends CommonMethods{
//	ToolsQA
//	Task 2:
//	Using the toolsqa Website, write code to accept an alert when clicking on 'Timing Alert' button and write code that accepts an
//	alert when clicking on 'Timing Alert' button - DO NOT USE Thread.Sleep();

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.toolsqa.com/automation-practice-switch-windows/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Timing Alert']")).click();
		Thread.sleep(3000);
		acceptAlert();
		
		
	}
}
