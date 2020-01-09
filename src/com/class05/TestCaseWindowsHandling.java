package com.class05;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseWindowsHandling {
//	1.Open chrome browser
//	2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
//	3.Click on “Javascript Alerts” link
//	4.Click on “Window Popup Modal” link
//	5.Click on the “ Follow On Instagram” button
//	6.Verify title of the page is “Syntax Technologies (@syntaxtechs) • Instagram photos and videos” 
//	7.Click on the “Like us On Facebook ” button
//	8.Verify title of the page is “Go to Facebook Home” 
//	9.Quit the browser NOTE: Selenium execution could be too fast, please use Thread.sleepTest Case
	public static final String WH_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(WH_URL);
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Window Popup Modal")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Follow On Instagram")).click();
		Set <String> allWindowsID= driver.getWindowHandles();
		Iterator <String> iD=allWindowsID.iterator();
		String parentId = iD.next();
		
		String childId = iD.next();
		
		if (!iD.equals(parentId)) {
			driver.switchTo().window(childId);
			driver.manage().window().maximize();
			System.out.println("Name of Instragram child window is: "+driver.getTitle());
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(parentId);
		}
		Thread.sleep(1000);
		driver.findElement(By.linkText("Like us On Facebook")).click();
		Set<String> allWindowsID2=driver.getWindowHandles();
		Iterator<String>iD2=allWindowsID2.iterator();
		String parentId2 = iD2.next();
		String childId2 = iD2.next();
		if (!iD2.equals(parentId2)) {
			driver.switchTo().window(childId2);
			driver.manage().window().maximize();
			System.out.println("Name of FaceBook child window is: "+driver.getTitle());
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(parentId2);
		}
		Thread.sleep(2000);
		driver.quit();
		
		
		
	
		
		
	}

}
