package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		// system is a class. setPropert(); is a static method

		// Key value
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// http -->hypertext transfer protocol (s=source)
		driver.get("http://www.google.com");

		Thread.sleep(2000);

		// browser navigation commands

		// it will navigate to a given url
		driver.navigate().to("http://www.syntaxtechs.com");
		// it will navigate back
		driver.navigate().back();
		// it will navigate one step forward.
		driver.navigate().forward();

		String actualTitle = driver.getTitle();

		driver.close();
		// driver

	}
}
