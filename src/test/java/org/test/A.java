package org.test;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class A {
	
	
	@BeforeGroups("smoke")
	

	@Test
	private void testA1() {
		System.out.println("TestA1");
	}

	@Test(dependsOnMethods="testA1")
	private void testA2() {
		System.out.println("TestA2");
	}

	@Test
	private void testA3() {
		System.out.println("TestA3");
	}

}
