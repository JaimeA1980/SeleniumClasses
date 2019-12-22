package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
	public static void main(String[] args) {
//		TC 2: Syntax Page URL Verification: 
//			Open chrome browser
//			Navigate to “https://www.syntaxtechs.com/”
//			Navigate to “https://www.google.com/”
//			Navigate back to Syntax Technologies Page
//			Refresh current page
//			Verify url contains “Syntax”

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://www.syntaxtechs.com");
		
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().refresh();
		
		
		
		
		
	}

}
