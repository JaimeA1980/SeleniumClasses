package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC1RadioButtons {
//	1.Open chrome browser
//	2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
//	3.Click on “Input Forms” links
//	4.Click on “Checkbox Demo” links
//	5.Click on checkbox inside a single demo section
//	6.Verify checkbox has been clicked successfully
//	7.Click on all checkboxes 1 by 1 in Multiple Checkbox Demo section.
//	8.Quit browserTest Case
	public static final String PRACTICE_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(PRACTICE_URL);
		
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		Thread.sleep(2000);
		WebElement box = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
		if (!box.isSelected()) {
			box.click();
		}	
		Thread.sleep(2000);
		List<WebElement> gCB=driver.findElements(By.xpath("//input[@class='cb1-element']"));
		
		if(!gCB.isEmpty()) {
			Iterator<WebElement> loop = gCB.iterator();
			while(loop.hasNext()) {
				loop.next().click();
			}
			Thread.sleep(2000);
		driver.close();
		}
		
		
		
		
		
	}
	

}
