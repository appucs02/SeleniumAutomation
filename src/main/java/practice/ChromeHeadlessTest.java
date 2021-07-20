package practice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessTest {

	public static void main(String[] args) {
		// Headless Testing works on Chrome version > 60 on windows and >59 on Mac
		// window size should be 1400,800

		System.setProperty("webdriver.chrome.driver", "F:\\\\Java/JavaWorkSpace/FreeCRMCucumberBDDFramework/src/main/java/drivers/chromedriver.exe");
		ChromeOptions chrOptions = new ChromeOptions();
		chrOptions.addArguments("window-size=1400,800");

		//set default download path

		// Setting new download directory path
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Use File.separator as it will work on any OS
		prefs.put("download.default_directory",
		System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");

		// Adding cpabilities to ChromeOptions

		chrOptions.setExperimentalOption("prefs", prefs);
		WebDriver driver =  new ChromeDriver(chrOptions);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://google.co.in/");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Testing");

		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@role='option']"));

		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());	
		}

		for(int i=0;i<options.size();i++) {
			if(options.get(i).getText().equals("testing tools")) {
				options.get(i).click();
				break;
			}
		}

		System.out.println(driver.getTitle());


	}

}
