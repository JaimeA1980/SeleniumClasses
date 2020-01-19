package com.class09;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HRMSLogInSiblingTask extends CommonMethods {
	public static void main(String[] args) {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("admin");
		driver.findElement(By.xpath("//div[@id='divPassword']/input")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//div[@id='divLoginButton']/input")).click();
		driver.navigate().back();
		
		//Navigate to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
		//	Login to the application by writing xpath based on “following and preceding siblings”
		
		driver.findElement(By.xpath("//span[text()='Username']/preceding-sibling::input")).clear();

		driver.findElement(By.xpath("//span[text()='Username']/preceding-sibling::input")).sendKeys("admin");
		
	}
}
//I bet she now regrets giving us this problem
