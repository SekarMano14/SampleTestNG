package org.test.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A {

	@Test(dataProvider="login")
	private void testA1(String us, String pa) {
		System.out.println("TestA1");
		System.out.println(us);
		System.out.println(pa);
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void testA2() {
		System.out.println("TestA2");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void testA3() {
		System.out.println("TestA3");
		System.out.println(Thread.currentThread().getId());
	}
	
	
	@DataProvider(name="login",indices= {2,3},parallel=true)
	private Object[][] data() {
		Object[][] obj=new Object[][]
				{
			{"mano@gmai.com","87654"},  //0
			{"raj@gmail.com","98765"}, //1
			{"ram@gmail.com","00000"}, //2
			{"suresh@gmail.com","089898"}  //3
				};
		return obj;

	}

}
