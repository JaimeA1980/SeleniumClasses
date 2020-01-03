package com.class04;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {
//	1.Open chrome browser
//	2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
//	3.Click on “Input Forms” links
//	4.Click on “Simple Form Demo” links
//	5.Get all input boxes from the page
//	6.Enter “Hello” to each text box
//	7.Close browser
	public static final String HW_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(HW_URL);
		
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Simple Form Demo")).click();
		//driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']")).sendKeys("Hello");
		List<WebElement> gCB=driver.findElements(By.xpath("//input[@class='form-control']"));
		
		if(!gCB.isEmpty()) {
			Iterator<WebElement> loop = gCB.iterator();
			while(loop.hasNext()) {
				loop.next().sendKeys("Hello");
			}
			Thread.sleep(3000);
			driver.close();
		}
	}

}
