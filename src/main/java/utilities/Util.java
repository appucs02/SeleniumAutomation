package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

	//Alerts
	public static void acceptAlert() {
		try {
			waitForAlert();
			Alert alt= driver.switchTo().alert();
			alt.accept();
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	public static void dismissAlert() {
		try {
			waitForAlert();
			Alert alt= driver.switchTo().alert();
			alt.dismiss();
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	public static String getTextFromAlert() {
		try {
			waitForAlert();
			Alert alt= driver.switchTo().alert();
			return alt.getText();
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
		return "";
	}
	
	public static void setTextIntoAlert(String strValue) {
		try {
			waitForAlert();
			Alert alt= driver.switchTo().alert();
			alt.sendKeys(strValue);
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	//when we have select Tag only
	public static void selectByVisibleText(WebElement element,String strValue) {
		Select slc;
		try {
			waitForElementVisibility(element);
			slc = new Select(element);
			slc.selectByVisibleText(strValue);
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	public static void selectfromListofWebElements(List<WebElement> lstOptions,String strValue) {
		try {
			for(int i=0;i<lstOptions.size();i++) {
				if(lstOptions.get(i).getText().equalsIgnoreCase(strValue)) {
					lstOptions.get(i).click();
					break;
				}
			}
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	public static void jsSetText(WebElement element,String objName,String strValue) {
		
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			waitForElementVisibility(element); //waiting x seconds
			if(element.isDisplayed()) {
				js.executeScript("arguments[0].setAttribute('value','"+strValue+"');", element);
			}else {
				logger.info("WebElement is not found for "+objName);
			}

		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
public static void jsClickElement(WebElement element,String objName) {
		
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			waitForElementVisibility(element); //waiting x seconds
			if(element.isDisplayed()) {
				js.executeScript("arguments[0].click();", element);
			}else {
				logger.info("WebElement is not found for "+objName);
			}

		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}

public static ArrayList<Map<String,String>> getDataFromExcel(String workBookname, String sheetName){
	ArrayList<Map<String,String>> lstData = new ArrayList<Map<String,String>>();
	XLSWorkbookReader xlsReader=null;
	try {
		xlsReader = new XLSWorkbookReader(System.getProperty("user.dir")+"/src/test/java/resources/TestData/"+workBookname);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	int rowCount = xlsReader.getRowCount(sheetName);
	Object[][] objs;
	for(int iRow = 2;iRow<=rowCount;iRow++) {
		Map<String ,String> map = new HashMap<String ,String>();
		for(int iCell=0;iCell<xlsReader.getColumnCount(sheetName);iCell++) {
			String colName = xlsReader.getCellData(sheetName, iCell, 1);
			String cellValue = xlsReader.getCellData(sheetName, iCell, iRow);
			map.put(colName,cellValue);
//			objs[][]=
		}
		lstData.add(map);
	}
	
	return lstData;
	
}
}
