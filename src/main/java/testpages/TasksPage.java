package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utilities.Util;

public class TasksPage extends TestBase{
	@FindBy(className="addNewButton")
	WebElement btnAddNew;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	WebElement createNewCustomer;
	
	public TasksPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddNewButton() {
		Util.clickElement(btnAddNew, "+ Add New Button");
	}
	public void clickAddNewCustomer() {
		Util.clickElement(createNewCustomer, "+ New Customer");
	}
	public void AddNewCustomer() {
		
		this.clickAddNewButton();
		this.clickAddNewCustomer();
	}
	
}
