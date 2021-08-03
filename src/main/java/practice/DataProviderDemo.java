package practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testbase.TestBase;
import utilities.Util;

public class DataProviderDemo extends TestBase{
	@BeforeMethod(alwaysRun=true)
	void setup() throws IOException {
		logger.info("Setting up for Test Execution on driver");
		prop = getProperties("config.properties");
		driver = getDriver(prop.getProperty("browserName"));
		driver.get("https://www.facebook.com/");
	}

	@DataProvider(name="getFacebookSignOnData")
	public Iterator<Map<String,String>> getTestData() {

		ArrayList<Map<String,String>> lstData =Util.getDataFromExcel("RegistationData.xls","RegistationData");

		Iterator<Map<String,String>> itr = lstData.iterator();
		//		Map<String,String> map = new HashMap<String,String>();
		////		map.put("fname", "sudheer");
		//		map.put("lname", "K");
		return itr;
	}


	@Test(dataProvider="getFacebookSignOnData") //takes Two dimentional array of maps
	void facebookLogin(Iterator<Map<String,String>> itr) {

		while(itr.hasNext()) {
			Map<String,String> data = itr.next();
			driver.findElement(By.xpath("//a[@id='u_0_2']")).click();

			driver.findElement(By.name("firstname")).sendKeys(data.get("fname"));
			driver.findElement(By.name("lastname")).sendKeys(data.get("lname"));
			driver.findElement(By.name("reg_emailzz")).sendKeys(data.get("email"));
			driver.findElement(By.name("reg_passwd__")).sendKeys(data.get("password"));

			Select days = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
			days.selectByVisibleText(data.get("day"));
			Select months = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
			months.selectByVisibleText(data.get("mon"));
			Select years = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
			years.selectByVisibleText(data.get("year"));


			driver.findElement(By.xpath("//label[text()='"+data.get("gender")+"']/following::input[@type='radio' and @name='sex']")).click();	
		}

	}
	@AfterMethod
	void tearDown() {
		driver.quit();
	}
}
