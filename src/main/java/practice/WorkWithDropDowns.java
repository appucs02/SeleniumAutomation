package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testbase.TestBase;
import utilities.Util;

public class WorkWithDropDowns extends TestBase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = getDriver("Chrome");
		driver.get("https://output.jsbin.com/osebed/2");
		
		//when you have select Tag
		WebElement element = driver.findElement(By.xpath("//select[@id='fruits']"));
		
		Util.selectByVisibleText(element, "Orange");
		/*Select obj = new Select(element);
		obj.selectByIndex(0);
		obj.selectByIndex(2);
		obj.selectByIndex(3);
		
		obj.deselectByVisibleText("Orange");
		obj.isMultiple(); //
		
		obj.getFirstSelectedOption();
		System.out.println(obj.getAllSelectedOptions());
		
		obj.getOptions();*/
		Thread.sleep(10000);
		
		driver.get("https://jqueryui.com/selectmenu/");
		
		
		List<WebElement> lstOptions=driver.findElements(By.xpath("//ul[@id='salutation-menu']//div[@role='option']"));
		
		Util.selectfromListofWebElements(lstOptions, "Dr.");
		Util.selectfromListofWebElements(lstOptions, "Prof");
		
		
		driver.quit();
	}

}
