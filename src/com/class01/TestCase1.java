package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
//	TC 1: Amazon Page Title Verification: 
//		Open chrome browser
//		Go to “https://www.amazon.com/”
//		Verify Title “Amazon.com: Online Shopping 
//		for Electronics, Apparel, Computers, Books, DVDs & more” is displayed

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		final String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		
		driver.get("https://www.amazon.com/");
		String actualTitle = driver.getTitle();
		
		if (expectedTitle.contentEquals(actualTitle)) {
			System.out.println("The actual and expected title matched");
		}else {
			System.err.println("Actual and expected did not match");
		}
	}
}
