package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageCommands {
	
	public static void main(String[] args) throws InterruptedException {
		

		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		final String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.contentEquals(actualTitle)) {
			System.out.println("The actual and expected title matched. I'm on the right page");
			
		}else {
			System.err.println("The actual and expected title did not match");
		}
		
		System.out.println("***************************************************************************");
		
		String actualUrl=driver.getCurrentUrl();
		
		System.out.println(actualUrl);
		String expectedUrl="https://www.google.com/?gws_rd=ssl";
		
		if(expectedUrl.equals(actualUrl)) {
			System.out.println("Both URL's matched");
		}else {
			System.err.println("Actual and expected are not matched");
		}

		driver.close();
		

	}

}
