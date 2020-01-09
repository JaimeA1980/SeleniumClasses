package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseDeleteEmployee {
//	1.Open chrome browser
//	2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
//	3.Login into the application  U:admin PW: Hum@nhrm123
//	4.Add Employee
//	5.Verify Employee has been added
//	6.Go to Employee List
//	7.Delete added Employee
//	8.Quit the browser
	public static final String DE_URL = "http://166.62.36.207/humanresources/symfony/web/index.php/auth";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(DE_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//b[text()='PIM']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys("El");
		driver.findElement(By.id("lastName")).sendKeys("Huaso");
		String empIDNum = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();

		boolean empProfile = driver.findElement(By.xpath("//div[@id='profile-pic']")).isDisplayed();

		if (empProfile) {
			System.out.println(empIDNum + " is this individuals employee number");
		} else {
			System.err.println("Could not create new employee profile");
		}
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		boolean found = false;
		while (!found) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
			for (int i = 1; i <= rows.size(); i++) {
				String rowsText = rows.get(i).getText();
				if (rowsText.contains(empIDNum)) {
					found = true;
					driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + (i + 1) + "]/td[1]")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("btnDelete")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("dialogDeleteBtn")).click();
					System.out.println(empIDNum+" has been successfully deleted");
					break;
				}

			}
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		
		driver.quit();
	}

}
