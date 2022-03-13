package org.test.cross;

import org.testng.annotations.Test;

public class C {

	@Test
	private void testC1() {
		System.out.println("TestC1");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void testC2() {
		System.out.println("TestC2");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void testC3() {
		System.out.println("TestC3");
		System.out.println(Thread.currentThread().getId());
	}
}
