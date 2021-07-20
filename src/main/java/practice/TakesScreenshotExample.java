package practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testbase.TestBase;

public class TakesScreenshotExample extends TestBase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		driver= getDriver("chrome");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.gmail.com/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\user\\Desktop\\xyz.png"));
		driver.close();
		driver.quit();
		
	}

}
