package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import testbase.TestBase;
import utilities.Util;

public class Demo extends TestBase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = getDriver("Chrome");
		
		driver.get("https://www.spicejet.com/");
		WebElement element = driver.findElement(By.id("view_fulldate_id_1"));
//		Util.jsSetText(element, "Depature Date", "23/07");
		
		String strDate = "23-07-2021";
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+strDate+"');", element);
		Thread.sleep(10000);
		System.out.println(element.getAttribute("value"));
		
		driver.quit();
	}

}
