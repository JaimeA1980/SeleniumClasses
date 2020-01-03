package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class TestCase1 extends CommonMethods{
//	TC 2: Radio Buttons Practice  
//	Open chrome browser
//	Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
//	Click on “Input Forms” links
//	Click on “Radio Buttons Demo” links
//	Click on any radio button in “Radio Button Demo” section.
//	Verify correct checkbox is clicked
//	Click on any radio button in “Group Radio Buttons Demo” section.
//	Verify correct checkbox is clicked
//	Quit browser
	public static final String JIRA_URL="http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", JIRA_URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		
		WebElement male = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input"));
		if (!male.isSelected()) {
			male.click();
			if(male.isSelected()) {
				System.out.println("Correct option is selected");
			}else {
				System.err.println("Unable to click male option");
			}
		}
		WebElement female = driver.findElement(By.xpath("//input[@value='Female'and@name='gender']"));
		if (!female.isSelected()) {
			female.click();
			if	(female.isSelected()) {
				System.out.println("Female option is selected");
			}else {
				System.err.println("Unable to flick female option");
			}
			Thread.sleep(2000);
			driver.close();
		}
		
		
		
	}

}
