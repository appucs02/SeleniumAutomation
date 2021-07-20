package testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utilities.Util;

public class LoginPage extends TestBase {
	@FindBy(id="username")
	public WebElement txtUserName;
	
	By userName1 = By.id("myid");
//	driver.findElement(userName1);
	
	
	@FindBy(xpath="//input[@name='pwd']")
	WebElement txtPassword;
	
	@FindBy(id="loginButton")
	WebElement btnLogin;

	public LoginPage(WebDriver driver){
		this.driver=driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	

	public void setUserName() {
		Util.setText(txtUserName, "User Name", prop.getProperty("userName"));
	}
	
	public void setPassword(){
		Util.setText(txtPassword, "Password", prop.getProperty("password"));
	}
	
	public void clickLoginBtn() {
		Util.clickElement(btnLogin,"Login Button");
	}
	
	public void loginToApp() {
		this.setUserName();
		this.setPassword();
		this.clickLoginBtn();
	}
	
}
