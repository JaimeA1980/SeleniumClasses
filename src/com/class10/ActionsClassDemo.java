package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ActionsClassDemo extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);
		Actions act = new Actions(driver);
		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		act.keyDown(Keys.SHIFT).sendKeys("hello").perform();
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		
		//to perform mouse or keyboard operation we need to have an Object on the action
		
		//identifiy an element on whci to perform mouse click
		WebElement loginBtn=driver.findElement(By.cssSelector("input#btnLogin"));
		//clicking on the mouse and to complete the action we need to call perform();
		//do right click
		Thread.sleep(5000);
		act.moveToElement(loginBtn).contextClick().perform();
		Thread.sleep(5000);
		act.moveToElement(loginBtn).click().perform();
		//to perform double click
		//act.moveToElement(loginBtn).doubleClick().perform();
		Thread.sleep(5000);
		//hover over the element
		WebElement pimlink = driver.findElement(By.linkText("PIM"));
		act.moveToElement(pimlink).perform();
		WebElement add = driver.findElement(By.linkText("Add Employee"));
		act.moveToElement(add).click().perform();  // or act.click(add).perform();
		//act.keyDown(Keys.SHIFT).sendKeys("hello").perform(); //--> if you perform this on txt box
		//it will hold shift key and type hello in upper
		
		
		
		
		
		Thread.sleep(10000);
		driver.quit();
	}
	

}
