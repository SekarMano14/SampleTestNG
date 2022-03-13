package org.test.parameters;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A {

	@Parameters({"username","password"})
	@Test
	private void testA1(@Optional("Kumar")String user,@Optional("000000")String pass) {
		System.out.println("TestA1");
		System.out.println(user);
		System.out.println(pass);
	}

	@Parameters({"password"})
	@Test
	private void testA2(@Optional("1111")String pass) {
		System.out.println("TestA2");
		System.out.println(pass);
	}

	@Test
	private void testA3() {
		System.out.println("TestA3");
	}

}
