package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {
	public static Logger logger;
	public static WebDriver driver;
	public static Properties prop;
	public static String relativePath =System.getProperty("user.dir");
	
	public TestBase() {
		logger=Logger.getLogger("ACTI TIME Logger");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	public static Properties getProperties(String strFilename) throws IOException {
		String strPath = relativePath + "/src/test/java/resources/configuration/"+strFilename;
		FileInputStream fi = new FileInputStream(strPath);
		prop = new Properties();
		prop.load(fi);
		fi.close();
		return prop;
	}
	
	public static WebDriver getDriver(String brwName) {
		try {
			if(brwName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",relativePath + "/src/test/java/resources/browserDrivers/chromedriver.exe");
				driver = new ChromeDriver();
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
