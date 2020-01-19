package com.class10;





import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassHW {
	public static final String Action_URL = "https://jqueryui.com";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(Action_URL);

		driver.findElement(By.linkText("Droppable")).click();
		WebElement demoFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(demoFrame);

		Actions act = new Actions(driver);
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropIn = driver.findElement(By.xpath("//div[@id='droppable']"));
		act.dragAndDrop(draggable, dropIn).perform();
		String dropped = dropIn.getText();
		if (dropped.isEmpty()) {
			System.out.println("Fail");
		} else {
			System.out.println("Pass");
		}
		TakesScreenshot test = (TakesScreenshot)driver;
		File actionHW = test.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(actionHW, new File("screenshots/JQueryui/DragAndDrop.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
