package com.class09;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class HRMReviewTask extends CommonMethods{
	public static void main(String[] args) {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']")).click();
		
		driver.findElement(By.xpath("//table[@id='resultTable']"));
		
	}

}
