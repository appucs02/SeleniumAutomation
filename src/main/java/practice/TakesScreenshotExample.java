package practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import testbase.TestBase;

/*
 * if you have good conditions with Pass
 * for all fail scenario's
 * you can take a screenshot at driver level
 * you can get a screenshot at specific element level
 */
public class TakesScreenshotExample extends TestBase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		driver= getDriver("chrome");
		
		driver.get("https://www.gmail.com/");
		
		
		//Driver Level
		/*TakesScreenshot screenshot = (TakesScreenshot)driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("H:\\sample.png");
		
		FileUtils.copyFile(srcFile, destFile);*/
		
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("H:\\sample.png"));
		
		
		//Element Level
		WebElement element = driver.findElement(By.xpath("//input[@name='identifier']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",element);
		
//		//draw boarder around the element
//		 js.executeScript("argument[0].style.boarder='3px solid red'", element);
//		 
//		 //set background color
//		 js.executeScript("argument[0].style.backgroundColor='"+element.getCssValue("backgroundColor")+"'", element);
		 
		File src = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("H:\\xyz.png"));
		driver.quit();
		
	}

}
