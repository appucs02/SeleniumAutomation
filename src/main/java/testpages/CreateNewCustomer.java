package testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testbase.TestBase;
import utilities.Util;

public class CreateNewCustomer extends TestBase {
	@FindBy(xpath="//input[@class='inputFieldWithPlaceholder newNameField inputNameField' and @type='text']")
	WebElement txtCustomerName;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	WebElement txtDescription;
	
	@FindBy(xpath="//div[@class='emptySelection']")
	WebElement ddCopyProject;

	@FindBy(xpath="//div[text()='Big Bang Company' and @class='itemRow cpItemRow ']")
	WebElement BigCompanyOption;
	@FindBy(xpath="//div[text()='Create Customer']")
	WebElement btnCreateCustormer;
	
	public CreateNewCustomer(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void setCustomerName(String custName) {
		Util.setText(txtCustomerName, "Customer Name", custName);
	}
	
	public void setDescription(String strDescription) {
		Util.setText(txtDescription, "Description", strDescription);
	}
	
	public void clickCopyProjectsElement() {
		Util.clickElement(ddCopyProject, "Copy Projects Dropdown" );
		Util.clickElement(BigCompanyOption, "Big Company Option" );
	}
	
	public void clickCreateCustomer() {
		Util.clickElement(btnCreateCustormer, "Create Customer Button");
	}
	public void CreateCustomerData(String custName,String strDescription ) {
		this.setCustomerName(custName);
		this.setDescription(strDescription);
		this.clickCopyProjectsElement();
		this.clickCreateCustomer();

	}
	
	public void verifyCustomer(String custName) {
		WebElement customer = driver.findElement(By.xpath("//div[@title='"+custName +"']"));
		if(customer.isDisplayed()) {
			logger.info("Customer is created successfully");
		}
		
		Assert.assertEquals(customer.getText(), custName);
	}
}
