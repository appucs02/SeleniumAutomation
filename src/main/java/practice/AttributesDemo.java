package practice;

import java.io.IOException;

import org.testng.annotations.Test;

public class AttributesDemo {
	@Test(enabled=false)
	void createCustomer() {
		
	}
	
	@Test(enabled=true)
	void createTimetracker() {
		
	}
	
	@Test(expectedExceptions={Exception.class})
	void createInfo() {
		/*home.login();
		tasks.createCustomer();*/
	}
	
	@Test(dependsOnMethods="createInfo", ignoreMissingDependencies=true)
	void display() {
		
	}
	
	@Test(invocationCount=2)
	void show() {
		System.out.println("Show Method");
	}
	
	//dataprovider,parameters,priority
}
