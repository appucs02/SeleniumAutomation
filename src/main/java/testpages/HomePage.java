package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utilities.Util;

public class HomePage extends TestBase {
	@FindBy(id="container_tasks")
	WebElement tabTasks;
	
	@FindBy(xpath="//a[@href='/logout.do' and @class='logout']")
	WebElement btnLogout;
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTasksTab() {
		Util.clickElement(tabTasks, "Task Tab");
	}
	
	public void logoutFromApp() {
		Util.clickElement(btnLogout, "Logout Button");
	}
}
