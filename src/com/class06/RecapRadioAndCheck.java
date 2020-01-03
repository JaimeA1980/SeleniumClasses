package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RecapRadioAndCheck extends CommonMethods {
	public static void main(String[] args) {
		
		setUp("chrome", "http:jiravm.centralus.cloudapp.azure.com:8081/basic-checkbox-demo.html");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		//List<WebElement> allChBoxes = driver.findElement(By.xpath("//input[@class='cb1-element']"));
		//for (WebElement el:allChBoxes) {
			
		//}
		//JUST PULL FROM GIT HUB SMH
	}

}
