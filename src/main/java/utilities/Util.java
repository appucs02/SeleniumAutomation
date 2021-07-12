package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

public class Util extends TestBase{
	//SendKeys Method
	public static void setText(WebElement element,String objName,String strValue) {
		try {
			waitForElementVisibility(element); //waiting x seconds
			if(element.isDisplayed()) {
				element.sendKeys(strValue);
			}else {
				logger.info("WebElement is not found for "+objName);
			}

		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}

	//Clicks
	public static void clickElement(WebElement element , String objName) {
		try {
			waitForElementTobeClickable(element);
			if(element.isDisplayed()) {
				element.click();
			}
			else {
				logger.info("Element is not clickable or not present on the current page for Object "+objName);
			}

		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}

	//Wait Methods
	public static void waitForElementVisibility(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,45);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(!element.isDisplayed())
				logger.info("Expected Element is not displayed on current Page");
		}catch(ElementNotVisibleException e) {
			logger.info(e.getMessage());
		}


	}

	public static void waitForAlert() {
		try {

			WebDriverWait wait = new WebDriverWait(driver,45);
			wait.until(ExpectedConditions.alertIsPresent());//pops
		}catch(Exception e) {
			logger.info(e.getMessage());
		}

	}

	public static void waitByLocator(By strLocator) {
		try {

			WebDriverWait wait = new WebDriverWait(driver,45);
			wait.until(ExpectedConditions.presenceOfElementLocated(strLocator));
		}catch(Exception e) {
			logger.info(e.getMessage());
		}

	}

	public static void waitForElementTobeClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,45);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) {
			logger.info(e.getMessage());
		}

	}
	public static void waitForElementSelection(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,45);
			wait.until(ExpectedConditions.elementToBeSelected(element));
		}catch(Exception e) {
			logger.info(e.getMessage());
		}

	}

}
