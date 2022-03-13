package org.test.dataprovider;
import org.testng.annotations.*;
public class Sample {
	@BeforeClass
	private void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	private void afterClass() {
		System.out.println("After Class");
	}

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("After Method");
	}

	@Test(priority=-2)
	private void test1() {
		System.out.println("Test1");
	}

	@Test(priority=1,invocationCount=5,enabled=true)
	private void test3() {
		System.out.println("Test3");
	}

	@Test(invocationCount=2,enabled=false)
	private void test2() {
		System.out.println("Test2");
	}

}
