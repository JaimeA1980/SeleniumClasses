package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookTaskSunday {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Tujefe");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("DelBarrio");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("elhuaso@email.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("elhuaso@email.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("CandyCane123456");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
