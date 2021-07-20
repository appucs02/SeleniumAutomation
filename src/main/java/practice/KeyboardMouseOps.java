package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import testbase.TestBase;

public class KeyboardMouseOps extends TestBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
		Action seriesofActions = act.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).contextClick().build();
		seriesofActions.perform();
		act.doubleClick();
		act.sendKeys("hello world");
		act.dragAndDrop(element, element);
		
	
	
	
	}

}
