package practice;

import org.testng.annotations.Test;

public class PriorityDemo {
	@Test(priority=-20)
	void TC001() {
		
	}
	
	@Test(priority=2)
	void TC003() {
		
	}
	
	@Test(priority=3)
	void TC002() {
		/*home.login();
		tasks.createCustomer();*/
	}
	
	@Test(priority=4)
	void TC004() {
		
	}
	@Test(priority=1)
	void TC005() {
		
	}
	
}
