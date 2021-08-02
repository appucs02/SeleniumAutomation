package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import testbase.TestBase;
import testpages.*;
import utilities.Util;

public class RegressionSuite extends TestBase{
	LoginPage login;
	HomePage home;
	TasksPage task;
	CreateNewCustomer newCustomer;
	@BeforeMethod(alwaysRun=true)
	void setup() throws IOException {
		logger.info("Setting up for Test Execution on driver");
		prop = getProperties("config.properties");
		driver = getDriver(prop.getProperty("browserName"));
		driver.get(prop.getProperty("URL"));
	}
	

	@Test(groups= {"SanityTests","Regression"})
	void TC001_getPageTitle() {
		Assert.assertEquals(driver.getTitle(), "TIME - Login");
		System.out.println("hello world");
	}
	
	@Test(groups= {"Regression"})
	void TC002_logintoApp() {
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.name("pwd")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("loginButton")).click();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");

	}
	
	@Test(groups= {"SmokeTests"})
	void TC003_loginadfasd() {
		login = new LoginPage(driver);
		login.loginToApp();
	}
	@Test(groups= {"Regression"})
	void TC004_createTask() {
		logger.info("******Starting createTask Method ********* " );
		login = new LoginPage(driver);
		home= new HomePage(driver);
		task = new TasksPage(driver);
		newCustomer = new CreateNewCustomer(driver);
		
		login.loginToApp();
		home.clickTasksTab();
		task.AddNewCustomer();
		newCustomer.CreateCustomerData("Sudheer", "I work in Virtusa");
		newCustomer.verifyCustomer("Sudheer");
		/*home=new HomePage(driver);
		home.logoutFromApp();
		Util.waitForElementVisibility(login.txtUserName);
		
		Assert.assertTrue(login.txtUserName.isDisplayed(),"user did not log out successfully");
		*/
		logger.info("******Starting createTask Method ********* " );
	}
	
	@AfterMethod(alwaysRun=true)
	void tearDown() {
		driver.quit();
	}
}
