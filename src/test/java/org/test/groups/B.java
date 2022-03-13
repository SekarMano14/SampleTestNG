package org.test.groups;

import org.testng.annotations.Test;

public class B {
	@Test(groups= {"smoke", "regression"})
	private void testB1() {
		System.out.println("TestB1");
	}
	@Test(groups= {"sanity", "regression"})
	private void testB2() {
		System.out.println("TestB2");
	}
	@Test(groups="retest")
	private void testB3() {
		System.out.println("TestB3");
	}
}
