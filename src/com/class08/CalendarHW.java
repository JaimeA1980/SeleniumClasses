package com.class08;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHW {
//	1.Open chrome browser
//	2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
//	3.Login into the application   user:Syntax PW:Syntax123!
//	4.Select Leave List
//	5.Select from December 1, 2019 until January 31, 2020
//	6.Check only Pending approval
//	7.Click on Search
//	8.Validate “No Records Found” is displayed
//	9.Quit the browser
	public static final String HW3_URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth";
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(HW3_URL);
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.linkText("Leave")).click();
	driver.findElement(By.linkText("Leave List")).click();
	
	
	driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//option[text()='Dec']")).click();
	
	driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
	driver.findElement(By.xpath("//option[text()='2019']")).click();
	
	Thread.sleep(2000);
	
	List<WebElement>cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	for (WebElement cell:cells) {
		if (cell.getText().equals("1")) {
			cell.click();
			break;
		}
		
	}
	driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//option[text()='Jan']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//option[text()='2020']")).click();
	
	Thread.sleep(2000);
	List<WebElement> cells2=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	for(WebElement cell2:cells2) {
		if (cell2.getText().equals("31")) {
			cell2.click();
			break;
		}
	}
	driver.findElement(By.id("btnSearch")).click();
	Thread.sleep(1000);
	String result = driver.findElement(By.xpath("//td[text()='No Records Found']")).getText();  //boolean should have been used to verify
	System.out.println(result+" is displayed.");
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File screen=ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screen,new File("screenshots/HW/NRF.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	Thread.sleep(1000);
	driver.quit();
}
}
