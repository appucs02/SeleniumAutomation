package testpages;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath= "//a[@href='/tasks/tasklist.do']")
	WebElement openTask;
	
	@FindBy(xpath="(//input[@placeholder='Start typing name ...'])[1]")
	WebElement searchCust;
	
	@FindBy(xpath="//span[text()='sudheer']")
	WebElement mouseover;
	
	@FindBy(xpath="//div[@class='node customerNode notSelected editable']//div[@class='editButton'][1]")
	WebElement editButton;
	
	
	@FindBy(xpath="//div[text()='ACTIONS'][1]")
	WebElement actionButton;
	
	@FindBy(xpath="//div[@class='dropdownContainer actionsMenu']//div[text()='Delete'][1]")
	WebElement deleteButton;
	
	@FindBy(xpath="//span[text()='Delete permanently']")
	WebElement conformDelete;
	
	//div[@class='customersProjectsPanel']//input[@type='text' and contains(@placeholder,'Start typing name ...')]
	
	//div[@class='filteredContainer']//span[@class='highlightToken']
	//div[@class='filteredContainer']//div[@class='editButton']
	
	//div[@class='actionButton']
	//div[@class='dropdownContainer actionsMenu']//div[@class='title' and text()='Delete'][1]
	
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
	
	public void setsearchCustomerName(String custName) {
		Util.setText(searchCust, "Customer Name", custName);
	}
	public void clickEditButton() {
		Util.clickElement(editButton, "edit button");
	}
	public void clickActionButton() {
		Util.clickElement(actionButton, "action button");
	}
	public void clickdeletebutton() {
		Util.clickElement(deleteButton, "delete button");
	}
	public void clickConformDelete() {
		Util.clickElement(conformDelete, "conform delete");
	}
	
	public void deleteCustomer(String custName) {
		this.setsearchCustomerName(custName);
		Util.mouseOver(driver.findElement(By.xpath("//span[text()='"+custName+"']")));
		this.clickEditButton();
		this.clickActionButton();
		this.clickdeletebutton();
		this.clickConformDelete();
	}
	
}
