package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2Sunday {
//	TC 2: Mercury Tours Registration: 
//		Open chrome browser
//		Go to “http://newtours.demoaut.com/”
//		Click on Register Link
//		Fill out all required info
//		Click Submit
//		User successfully registered
//		(Create 2 scripts using different locators)
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com");

		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.id("email")).sendKeys("BCSanfer@aol.com");
		driver.findElement(By.name("password")).sendKeys("y0am0Chile");
		driver.findElement(By.name("confirmPassword")).sendKeys("y0am0Chile");

		driver.findElement(By.name("register")).click();

		Thread.sleep(3000);

		driver.close();

	}

}
