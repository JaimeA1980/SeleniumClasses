package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TCVerifyElementIsClickableHW {
	public static final String VEC_URL = "https://the-internet.herokuapp.com";
	public static void main(String[] args) throws InterruptedException {
//		1.Open chrome browser
//		2.Go to “https://the-internet.herokuapp.com/”
//		3.Click on “Click on the “Dynamic Controls” link
//		4.Select checkbox and click Remove
//		5.Click on Add button and verify “It's back!” text is displayed
//		6.Close the browser
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(VEC_URL);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Add']")));
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		String message = driver.findElement(By.xpath("//p[@id='message']")).getText();
		if(message.isEmpty()) {
			System.out.println("Fail");
		}else {
			System.out.println("Pass");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
