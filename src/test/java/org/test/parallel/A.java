package org.test.parallel;
import org.testng.annotations.Test;
public class A {
	@Test
	private void testA1() {
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
