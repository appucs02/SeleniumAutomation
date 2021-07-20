package practice;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import testbase.TestBase;

public class FileUpload extends TestBase{

	public static void main(String[] args) throws InterruptedException {
		driver = getDriver("chrome");
		
		driver.get("https://html.com/input-type-file/");
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.xpath("//input[@type='file' and @id='fileupload']"));
		element.sendKeys("C:\\Users\\91996\\Desktop\\Jquery UI Site.txt");
		
		Thread.sleep(20000);
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
