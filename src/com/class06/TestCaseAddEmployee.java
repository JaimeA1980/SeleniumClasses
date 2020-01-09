package com.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseAddEmployee {
//	1.Open chrome browser
//	2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
//	3.Login into the application  U:admin PW:Hum@nhrm123
//	4.Add Employee
//	5.Log out 
//	6.Quit the browser
	public static final String AE_URL= "http://166.62.36.207/humanresources/symfony/web/index.php/auth";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(AE_URL);
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("welcome")).click();
		WebDriverWait wait2=new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver.quit();
		
		
		
		
	}

}
