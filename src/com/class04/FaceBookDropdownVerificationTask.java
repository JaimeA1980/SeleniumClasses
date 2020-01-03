package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookDropdownVerificationTask {
//	1.Open chrome browser
//	2.Go to “https://www.facebook.com”
//	3.Verify:●month dd has 12 month options●day dd has 31 day options●year dd has 115 year options
//	4.Select your date of birth
//	5.Quit browserTest Case
	public static final String FB_URL = "https://www.facebook.com";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(FB_URL);
		
		WebElement dropdown=driver.findElement(By.cssSelector("select#month"));
		WebElement dropdown2=driver.findElement(By.cssSelector("select#day"));
		WebElement dropdown3=driver.findElement(By.cssSelector("select#year"));
		
		Select month = new Select(dropdown); 
		List<WebElement>msize=month.getOptions();
		int totalmonths = msize.size()-1;
		System.out.println(totalmonths);
		
		Select day = new Select(dropdown2);
		List<WebElement>dsize=day.getOptions();
		int totaldays = dsize.size()-1;
		System.out.println(totaldays);
		
		Select year = new Select(dropdown3);
		List<WebElement>ysize=year.getOptions();
		int totalyears = ysize.size()-1;
		System.out.println(totalyears);
		
		month.selectByVisibleText("Mar");
		day.selectByVisibleText("7");
		year.selectByVisibleText("1980");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
