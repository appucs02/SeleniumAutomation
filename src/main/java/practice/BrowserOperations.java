package practice;

import testbase.TestBase;

public class BrowserOperations extends TestBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = getDriver("chrome");
		//Hit url
		driver.get("https://demo.actitime.com/login.do");
		driver.navigate().to("https://google.co.in");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.manage().window();
		
		//Switch to
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
		driver.switchTo().frame("myframe");
		driver.switchTo().defaultContent();

		driver.switchTo().alert(); //pops
		driver.switchTo().activeElement();
		
		System.out.println(driver.getTitle());
		driver.getPageSource();
		driver.getCurrentUrl();
		
		//window handles
		driver.getWindowHandle();
		driver.getWindowHandles();
		
		//browser closures
		
		driver.close(); //closes the current session/window/tab
		driver.quit(); //quits driver itself
		
	}

}
