package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testbase.TestBase;
import utilities.Util;

public class AlertsDemo extends TestBase{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = getDriver("chrome");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(3000);
			
		driver.findElement(By.xpath("//input[@value='Sign in' and @type='submit']")).click();
		
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept(); //accept the alert 
		driver.findElement(By.xpath("//input[@value='Sign in' and @type='submit']")).click();
		Thread.sleep(10000);
		alt.dismiss();
		
		alt.sendKeys("enter this in textbox in popup");
		driver.quit();
		
	}

}
