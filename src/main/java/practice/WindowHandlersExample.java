package practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testbase.TestBase;

public class WindowHandlersExample extends TestBase{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver=getDriver("chrome");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		WebElement element = driver.findElement(By.xpath("//a[text()='Good PopUp #3']"));
		
		element.click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parentwindow = it.next();
		System.out.println("parent window id "+ parentwindow);
		String childWindow = it.next();
		System.out.println("Child window id "+childWindow);		
		
		driver.switchTo().window(childWindow);
		Thread.sleep(10000);
		System.out.println("Child Window titile is "+driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentwindow);
		System.out.println("Parent Window titile is "+driver.getTitle());
		driver.quit();
	}

}
