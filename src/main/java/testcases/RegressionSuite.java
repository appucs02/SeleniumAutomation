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
	@BeforeClass
	void setup() throws IOException {
		logger.info("Setting up for Test Execution on driver");
		prop = getProperties("config.properties");
		driver = getDriver(prop.getProperty("browserName"));
		driver.get(prop.getProperty("URL"));
	}
	

	@Test
	void getPageTitle() {
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		System.out.println("hello world");
	}
	
	@Test
	void logintoApp() {
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.name("pwd")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("loginButton")).click();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");

	}
	
	@Test
	void loginadfasd() {
		login = new LoginPage(driver);
		login.loginToApp();
	}
	@Test
	void createTask() {
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
		home=new HomePage(driver);
		home.logoutFromApp();
		Util.waitForElementVisibility(login.txtUserName);
		
		Assert.assertTrue(login.txtUserName.isDisplayed(),"user did not log out successfully");
		
		logger.info("******Starting createTask Method ********* " );
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
