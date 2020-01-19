package com.class11;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TCUploadFileAndTakeScreenshot {
//	Navigate to “http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
//		Upload file
//		Verify file got successfully uploaded and take screenshot
	public static final String UFTS_URL = "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(UFTS_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.className("gwt-FileUpload"))
				.sendKeys("C:\\Users\\huaso\\Pictures\\gitRemotepractice.png");
		driver.findElement(By.xpath("//button[text()='Upload File']")).click();
		Alert alert1 = driver.switchTo().alert();
		String alertText = alert1.getText();
			if(alertText.equals("File uploaded!")) {
				System.out.println(alertText);
			} else {
				System.err.println("Something was not done right");
			}
			alert1.accept();	
		TakesScreenshot sc = (TakesScreenshot)driver;
		File screenShot = sc.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File("screenshots/UploadScreenShot/FileUploaded.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
