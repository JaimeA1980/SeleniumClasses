package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormSubmissionTestCase {
//	1.Open chrome browser
//	2.Go to “http://166.62.36.207/syntaxpractice/”
//	3.Click on “Input Forms” link
//	4.Click on “Input Form Submit” link
//	5.Using different locator submit the form and click on “Send” button
//	6.Quit the browserTest Case
	public static final String FS_URL = "http://166.62.36.207/syntaxpractice/";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(FS_URL);
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Input Form Submit")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("El");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Huaso");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']")).sendKeys("anyone@obsolete.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='(845)555-1212']")).sendKeys("(202)232-0847");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Address']")).sendKeys("2801 Adams Mill Rd");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='city']")).sendKeys("Washington");
		Thread.sleep(1000);
		WebElement dropdown = driver.findElement(By.cssSelector("select[name='state']"));
		
		Select state = new Select(dropdown);
		state.selectByVisibleText("District of Columbia");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='zip']")).sendKeys("20009");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[value='no']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("textarea[name='comment']")).sendKeys("Have no idea what the heck this is");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[onclick='resetForm();']")).click();
		Thread.sleep(1000);
		driver.quit();
		
		
	}

}
