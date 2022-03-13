package org.test.rerun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class B {
	@Test
	private void testB1() {
		Assert.assertTrue(false);
		System.out.println("TestB1");
	}
	@Test
	private void testB2() {
		System.out.println("TestB2");
	}
	@Test
	private void testB3() {
		System.out.println("TestB3");
	}
}
