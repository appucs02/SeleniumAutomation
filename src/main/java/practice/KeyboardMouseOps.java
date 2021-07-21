package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import testbase.TestBase;

public class KeyboardMouseOps extends TestBase{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = getDriver("chrome");
	/*	driver.get("https://www.spicejet.com/");
		
		Thread.sleep(3000);
		Actions act = new Actions(driver);
//		WebElement e1 = driver.findElement(By.xpath("//div[@id='draggable']"));
//		WebElement e2= driver.findElement(By.id("draggable"));
		
		WebElement element =driver.findElement(By.xpath("//a[@id='highlight-addons']"));
		
		act.moveToElement(element).build().perform();
//		act.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='Visa Services']")).click();
		Thread.sleep(10000);
		System.out.println(driver.getTitle());*/
		
		Actions act = new Actions(driver);
		driver.navigate().to("https://jqueryui.com/droppable/");
		Thread.sleep(2000);
		driver.switchTo().frame(0); //entering the frame
		WebElement e1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement e2= driver.findElement(By.id("draggable"));
		
		act.dragAndDrop(e1, e2).build().perform();
		
		driver.switchTo().defaultContent(); //exiting the frame
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//a[text()='Accordion']")).click();
		
		WebElement target = driver.findElement(By.xpath("//p[@class='desc' and text()='Displays collapsible content panels for presenting information in a limited amount of space.']"));
		if(target.isDisplayed()) {
			System.out.println("We are there wher we need to be");
		}
		
		driver.quit();
	
	
	
	}

}
