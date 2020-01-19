package com.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class HRMReviewTask extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		int rowsNum = rows.size();
		System.out.println(rowsNum+" rows present");
		for (int i = 1; i<=rowsNum; i++) {
			String names=driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(names);
			if (names.contains("Syntax")){
				driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).click();
				break;
			}else {
				System.err.println("Name not present");
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
//*[@id='resultTable']/tbody/tr