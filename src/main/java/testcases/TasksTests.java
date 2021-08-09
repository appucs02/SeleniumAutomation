package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
	Object[] getTasksData() {
		List<Map<String,String>> lstData=Util.getDataFromExcel("ActiTimeData.xlsx", "TasksData");
		int count = lstData.size();
	/*	Object[] obj = new Object[count];

		Iterator<Map<String,String>> itr = lstData.iterator();*/
		int i=0;
//		String name = Method.this.getName();
		//Advanced usage
		Stream<Map<String,String>> stream = lstData.stream().filter(data->data.containsValue("TC001"));
		Iterator<Map<String,String>> itr = stream.iterator();
		Object[] obj= new Object[(int) lstData.stream().filter(data->data.containsValue("TC001")).count()];
		while(itr.hasNext()) {
			obj[i++]= itr.next();
		}
		return obj;
	}

	@Test(dataProvider="getTasksData")
	void TC001_CreateCustomer(Map<String,String> data) {
		logger.info("******Starting createTask Method ********* " );
		home= new HomePage(driver);
		task = new TasksPage(driver);
		newCustomer = new CreateNewCustomer(driver);

		home.clickTasksTab();
		task.AddNewCustomer();
		newCustomer.CreateCustomerData(data.get("custName"), data.get("custDescreption"));
		newCustomer.verifyCustomer(data.get("custName"));

		logger.info("******Starting createTask Method ********* " );
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}
	
	@AfterTest
	void afterTest() {
		System.out.println("All Test Cases Executed");
	}
}
