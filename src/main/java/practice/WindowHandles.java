package practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import testbase.TestBase;
import utilities.Util;

public class WindowHandles extends TestBase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver=getDriver("chrome");
		driver.get("https://www.google.com/");
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> itr = windowHandles.iterator();
		String parenetWindow = itr.next();
		String childWindow = itr.next();
		
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		Thread.sleep(3000);
		
//		driver.switchTo().window(parenetWindow).close();
		
		List<WebElement> lst = driver.switchTo().window(parenetWindow).findElements(By.xpath("//a"));
		
		for(int i=0;i<lst.size();i++) {
			
			System.out.println(lst.get(i).getText());
		}
		
		WebDriver childDriver =driver.switchTo().window(childWindow);
		childDriver.getTitle();
		childDriver.close();
		driver.quit();
	}

}
