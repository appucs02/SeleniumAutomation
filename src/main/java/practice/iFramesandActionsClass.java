package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import testbase.TestBase;

public class iFramesandActionsClass extends TestBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		driver = getDriver("chrome");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/");;
		
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement element2 = driver.findElement(By.xpath("//*[@id='droppable']"));
		Actions act = new Actions(driver);
		act.clickAndHold(element1).moveToElement(element2).release().build().perform();
		
		driver.close();
	}

}
