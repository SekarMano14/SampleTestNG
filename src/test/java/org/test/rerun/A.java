package org.test.rerun;


import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(WithoutKnown.class)
public class A {
	@Test
	private void testA1() {
		System.out.println("TestA1");
	}
	@Test
	private void testA2() {
		Assert.assertTrue(false);
		System.out.println("TestA2");
	}
	@Test
	private void testA3() {
		System.out.println("TestA3");
	}
}
