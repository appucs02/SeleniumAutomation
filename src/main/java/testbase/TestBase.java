package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {
	public static Logger logger;
	public static WebDriver driver;
	public static Properties prop;
	public static String strRelativePath =System.getProperty("user.dir");
	
	public TestBase() {
		logger=Logger.getLogger("ACTI TIME Logger");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	public static Properties getProperties(String strFilename) throws IOException {
		String strPath = strRelativePath + "/src/test/java/resources/configuration/"+strFilename;
		FileInputStream fi = new FileInputStream(strPath);
		prop = new Properties();
		prop.load(fi);
		fi.close();
		return prop;
	}
	
	public static WebDriver getDriver(String brwName) {
		try {
			if(brwName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", strRelativePath+"/src/test/java/resources/BrowserDrivers/chromedriver.exe");
				ChromeOptions options= new ChromeOptions();
//				options.addArguments("window-size=1400,800");
				
				Map<String,String> preferences = new HashMap<String,String>();
				preferences.put("download.default_directory", strRelativePath+"\\src\\test\\java\\resources\\Downloads");
				options.setExperimentalOption("prefs", preferences);
				
				driver= new ChromeDriver(options);
			}
			else if(brwName.equalsIgnoreCase("ie") || brwName.equalsIgnoreCase("internetexplorer")) {
				System.setProperty("webdriver.ie.driver", strRelativePath+"/src/test/java/resources/BrowserDrivers/ieDriver.exe");
				driver= new InternetExplorerDriver();
			} else if(brwName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecho.driver", strRelativePath+"/src/test/java/resources/BrowserDrivers/gechodriver.exe");
				driver= new FirefoxDriver();
			} 
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
