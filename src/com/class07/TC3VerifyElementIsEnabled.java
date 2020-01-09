package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC3VerifyElementIsEnabled {
//	1.Open chrome browser
//	2.Go to “https://the-internet.herokuapp.com/”           //input[@type='text']
//	3.Click on “Click on the “Dynamic Controls” link
//	4.Click on enable button
//	5.Enter “Hello” and verify text is entered successfully
//	6.Close the browserTest Case
	
	public static final String VEE_URL = "https://the-internet.herokuapp.com/";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(VEE_URL);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Disable']")));
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");
		
		String text = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
		
		if (text.equals("Hello")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
