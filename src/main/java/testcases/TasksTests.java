package testcases;

import org.testng.annotations.*;

public class TasksTests {
	@BeforeClass
	void beforeClass() {
		System.out.println("BeforeClass Method from TasksTests Class");
	}
	@Test
	void test() {
		System.out.println("Test from TaskTest Class");
	}
	@AfterClass
	void beforeAfter() {
		System.out.println("AfterClass Method TasksTests Class");
	}
	
}
