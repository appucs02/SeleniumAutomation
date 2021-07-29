package practice;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testbase.TestBase;

public class ParametersDemo extends TestBase {
	
	@Test
	
	@Parameters({"CustomerName","CustPAN","BrowserName","Url"})

	void ShowCustDetails(String custName, String custPan,String brName, String Url) {
		driver = getDriver(brName);
		driver.get(Url);
		System.out.println("Customer name is:"+custName );
		System.out.println("Customer PAN is:"+custPan );
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
	

}
