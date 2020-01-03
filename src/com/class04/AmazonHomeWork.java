package com.class04;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomeWork {
	public static final String AMAZON_URL = "http://amazon.com/";

	public static void main(String[] args) throws InterruptedException {
//		1.Open chrome browser
//		2.Go to “http://amazon.com/”
//		3.Verify how many department options available.●Print each department ●Select Computers
//		4.Quit browser
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(AMAZON_URL);

		WebElement depts = driver.findElement(By.cssSelector("select[id='searchDropdownBox']"));

		Select dept = new Select(depts);
		List<WebElement> deptSize = dept.getOptions();
		int totaldepts = deptSize.size();
		System.out.println("Number of department options is: " + totaldepts);

		Iterator<WebElement> deptList = deptSize.iterator();
		while (deptList.hasNext()) {
			System.out.println(deptList.next().getText());

		}

		Thread.sleep(1000);
		dept.selectByVisibleText("Computers");
		Thread.sleep(1000);
		String comp = depts.getAttribute("value");

		if (comp.equals("search-alias=computers")) {
			System.out.println("Computers selected");
		} else {
			System.err.println("Computers not selected");
		}
		Thread.sleep(1000);
		driver.close();
	}
}
