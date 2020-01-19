package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.Command;

import com.utils.CommonMethods;

public class AmazonReviewTask extends CommonMethods{
//	Amazon
//	Task 1:
//	As an analyst, I want to be able to click on an element inside any frame displayed on the homepage that will take me to the
//	respective page. Verify the landing page.
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.amazon.com/");
		Thread.sleep(5000);
		switchToFrame(driver.findElement(By.xpath("//div[@id='ape_Gateway_right-2_desktop_placement']/iframe")));
		
		  driver.findElement(By.className("clickthrough")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
//public static void main(String[] args) throws InterruptedException {
//	setUp("chrome", Constants.AMAZONURL);
//	Thread.sleep(3000);
//	switchToFrame(driver.findElement(By.xpath("//div[@id='ape_Gateway_right-2_desktop_placement']/iframe")));
//	/*
//	 * xpath to locate frame
//	 * div[@id='ape_Gateway_right-2_desktop_placement']/iframe
//	 */
//	driver.findElement(By.className("clickthrough")).click();