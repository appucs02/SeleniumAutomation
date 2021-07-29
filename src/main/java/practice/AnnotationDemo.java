package practice;

import java.io.IOException;

import org.testng.annotations.*;

import testbase.TestBase;

public class AnnotationDemo extends TestBase {
	@BeforeSuite
	void beforeSuite() throws IOException {
		prop = getProperties("config.properties");
		System.out.println("BeforeSuite Method");
	}
	
	@BeforeTest
	void beforeTest() {
		System.out.println("BeforeTest Method");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("BeforeClass Method");
	}
	
	@Test
	void TC001() {
		System.out.println(prop.getProperty("URL"));
	}
	
	@Test
	void TC002() {
		System.out.println(prop.getProperty("browserName"));
	}
	
	@AfterClass
	void beforeAfter() {
		System.out.println("AfterClass Method");
	}
	
	@AfterTest
	void afterTest(){
		System.out.println("AfterTest Method");
	}
	@AfterSuite
	void afterSuite() {
		System.out.println("After Method");
	}
}
