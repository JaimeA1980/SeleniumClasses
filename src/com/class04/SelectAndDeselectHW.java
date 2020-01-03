package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAndDeselectHW {
//	5.Open chrome browser
//	6.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
//	7.Click on “Input Forms” links
//	8.Click on “Select Dropdown List” link
//	9.Select value from “Select List Demo” section
//	10.Verify value has been selected
//	11.Select 4 options from “Multi Select List Demo”
//	12.Deselect 1 of the option from the dd
//	13.Quit browser
	public static final String SD_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(SD_URL);
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Select Dropdown List")).click();
		
		WebElement day = driver.findElement(By.id("select-demo"));
		Select select = new Select(day);
		List<WebElement> days = select.getOptions();
		for (WebElement dias : days) {
			String diaDeSemana = dias.getText();
			if (diaDeSemana.equals("Sunday")) {
				dias.click();
				System.out.println(dias.isSelected());
			}
		}
		Thread.sleep(1000);
		WebElement states = driver.findElement(By.cssSelector("select#multi-select"));
		Select select2 = new Select(states);
		
		select2.selectByVisibleText("California");
		select2.selectByVisibleText("Florida");
		select2.selectByVisibleText("New Jersey");
		select2.selectByVisibleText("New York");
		Thread.sleep(2000);
		select2.deselectByVisibleText("New Jersey");

		Thread.sleep(1000);
		driver.close();
	}

}
