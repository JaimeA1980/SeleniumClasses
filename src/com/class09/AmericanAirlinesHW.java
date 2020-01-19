package com.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class AmericanAirlinesHW extends CommonMethods {
//	TC 1: Table headers and rows verification
//
//	Open chrome browser
//	Go to “https://www.aa.com/homePage.do”
//	Enter From and To
//	Select departure as May 14 of 2020
//	Select arrival as November 8 of 2020
//	Verify “Choose flights” text is displayed
//	Take s screenshot of the results
//	Close browser
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.aa.com/homePage.do");
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("IAD");
		driver.findElement(By.xpath("//a[@data-for='reservationFlightSearchForm.destinationAirport']")).click();
		Thread.sleep(1000);
		WebElement countries = driver.findElement(By.cssSelector("select#countryCode"));
		Select select = new Select(countries);
		select.selectByVisibleText("Chile");
		driver.findElement(By.xpath("//a[@id='airport_SCL']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='aa-leavingOn']")).click();
		Thread.sleep(2000);
		boolean flag = false;
		
		while (!flag) {
			String depMonth=driver.findElement(By.xpath("//div[contains(@class,'ui-corner-left')]/div")).getText();
			if (depMonth.equals("May 2020")) {
				List<WebElement> daysOfMonth=driver.findElements(By.xpath("//div[contains(@class, 'ui-corner-left')]/following-sibling::table/tbody/tr/td"));
				for (WebElement days:daysOfMonth) {
					String dayText=days.getText();
					if (dayText.equals("14")) {
						days.click();
						flag = true;
						break;
					}
				}
			}else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
		}
		driver.findElement(By.id("aa-returningFrom")).click();
		flag = false;
		while (!flag) {
			String retMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if(retMonth.equals("November")) {
				List<WebElement>daysOfMonth=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for (WebElement days:daysOfMonth) {
					String dayText=days.getText();
					if(dayText.equals("8")) {
						days.click();
						flag = true;
						break;
					}
				}
			}else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
		}
	}

}
