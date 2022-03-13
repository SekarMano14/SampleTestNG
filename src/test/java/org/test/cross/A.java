package org.test.cross;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class A {
	@Parameters({"browsername"})
	@Test
	private void testA1(String browser) {
		System.out.println(browser);
		System.out.println("TestA1");
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

}
