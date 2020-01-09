package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class TestCaseVerifyElementIsPresent extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1.Open chrome Browser
		 * 2.go to "https://the-internet.herokuapp.com/"
		 * 3.click on "Click on the "Dynamic Loading" link
		 * 4.click on "Example 1..." and click on "Start"
		 * 5.Verifiy element with text "Hello World!" is displayed
		 * 6.close the browser
		 */
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		
		boolean welcome =driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed();
		
		if(welcome) {
			System.out.println("Hello World! is displayed");
		}else {
			System.out.println("It does not exist");
		}
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}
