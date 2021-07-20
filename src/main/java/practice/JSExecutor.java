package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import testbase.TestBase;

public class JSExecutor extends TestBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = getDriver("chrome");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://html.com/input-type-file/");
		WebElement element = driver.findElement(By.xpath("//input[@type='file' and @name='fileupload']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String DomainName = (String) js.executeScript("return document.domain;"); //rerurns domain name of current site
		System.out.println(DomainName);
		String url = js.executeScript("return document.URL;").toString();
		System.out.println(url);
		String TitleName = js.executeScript("return document.title;").toString();
		System.out.println(TitleName);
		js.executeScript("window.location = 'http://demo.guru99.com/'"); //works like driver.manage().navigate()
		
		//scroll down
		js.executeScript("window.scrollBy(0,600)");
		
		//click an element
		js.executeScript("arguments[0].click();", element);
		
		//Set an Alert
		 js.executeScript("alert('Welcome to Guru99');");   
		 
		 
		 //highlight an element
		 js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",element);
	  	  
		//draw boarder around the element
		 js.executeScript("argument[0].style.boarder='3px solid red'", element);
		 
		 //set background color
		 js.executeScript("argument[0].style.backgroundColor='"+element.getCssValue("backgroundColor")+"'", element);
	}

}
