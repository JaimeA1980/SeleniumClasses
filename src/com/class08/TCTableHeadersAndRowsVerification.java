package com.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class TCTableHeadersAndRowsVerification extends CommonMethods {

	public static void main (String[] args) throws InterruptedException {
		setUp("chrome","http://166.62.36.207//syntaxpractice");
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		System.out.println("Rows tally is: "+rows.size());
		
		List <WebElement> cols=driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));
		System.out.println("Columns tally is: "+cols.size());
		
		System.out.println("Printing column headers--------------------------------------------------------------");
		Iterator<WebElement> colsIt=cols.iterator();
		while(colsIt.hasNext()) {
			WebElement column = colsIt.next();
			System.out.println(column.getText());
		}
		System.out.println("Printing row data-----------------------------------------------------------------------");
		for(WebElement row:rows) {
			System.out.println(row.getText());
		}
		System.out.println("Printing data cell by cell using enhanced for loop---------------------------------------------------------------");
		
		List <WebElement> cells =driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td"));
		for(WebElement cell:cells) {
		String cellData= cell.getText();
		System.out.println(cellData);
		}	
		System.out.println("Printing data cell by cell using for loop--------------------------------------------------------------------------");
		for(int i=1; i<=rows.size(); i++) { //controlling rows
			for (int y=1; y<=cols.size(); y++) {//controlling cols
			String cellText=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td["+y+"]")).getText();
			System.out.println(cellText);
			}
			
		}
		Thread.sleep(2000);
		driver.close();
	}
}
