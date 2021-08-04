package testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.*;

import testbase.TestBase;
import testpages.*;
import utilities.Util;


public class TasksTests extends TestBase {
	
	LoginPage login;
	HomePage home;
	TasksPage task;
	CreateNewCustomer newCustomer;
	
	@BeforeMethod
	void setup() throws IOException {
		logger.info("Initializing driver and all prerequisites");
		driver= getDriver("chrome");
		prop = getProperties("config.properties");
		driver.get(prop.getProperty("URL"));
		login = new LoginPage(driver);
		login.loginToApp();
	}
	
	@DataProvider(name="getTasksData")
	Iterator<Map<String,String>> getTasksData() {
	 	ArrayList<Map<String,String>> lstData=Util.getDataFromExcel("ActiTimeData.xlsx", "TasksData");
	 	
	 	return lstData.iterator();
	}
	
	@Test(dataProvider="getTasksData")
	void createCustomer(Iterator<Map<String,String>> iterator) {
		logger.info("******Starting createTask Method ********* " );
		
		while(iterator.hasNext()) {
			
			HashMap<String,String> data = (HashMap<String, String>) iterator.next();
			home= new HomePage(driver);
			task = new TasksPage(driver);
			newCustomer = new CreateNewCustomer(driver);
			
			home.clickTasksTab();
			task.AddNewCustomer();
			newCustomer.CreateCustomerData(data.get("custName"), data.get("custDescreption"));
			newCustomer.verifyCustomer(data.get("custName"));
		}
		logger.info("******Starting createTask Method ********* " );
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}
}
