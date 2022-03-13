package org.test.groups;

import java.util.Date;

import org.base.BaseClass;
import org.pages.LoginPage;
import org.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class FacebookAssert extends BaseClass {
	@BeforeClass
	private void beforeClass() {
		launchBrowser("Chrome");
		implicitWait(10);
		System.out.println("Before Class");
	}

	@AfterClass
	private void afterClass() {
		quit();
		System.out.println("After Class");
	}

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Test Starts-------- " + new Date());
		System.out.println("Before Method");
	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("Test Ends-------- " + new Date());
		System.out.println("After Method");
	}

	@Test
	private void test1() {
		launchUrl("https://www.facebook.com/");
		RegistrationPage r = new RegistrationPage();
		btnClick(r.getBtnCreate());
		fillTextBox(r.getTxtFirstname(), "Manoj");
		fillTextBox(r.getTxtlastname(), "Kumar");
		btnClick(r.getBtnSignUp());
		System.out.println("Test1");
	}

	@Test
	private void test3() throws InterruptedException {
		launchUrl("https://www.facebook.com/");
		// verify url
		Assert.assertTrue(getCurrentUrl().contains("facebook"), "Verify the url");

		LoginPage l = new LoginPage();
		// verify username
		fillTextBox(l.getTxtUserName(), "manoj@gmail.com");
		Assert.assertEquals(getAttribute(l.getTxtUserName()), "Mano@gmail.com", "Verify username");

		// verify password
		fillTextBox(l.getTxtPassword(), "getTxtPassword");
		Assert.assertEquals(getAttribute(l.getTxtPassword()), "getTxtPassword", "Verify Password");

//		verify login valid or invalid
		btnClick(l.getBtnLogin());
		Thread.sleep(5000);
		Assert.assertTrue(getCurrentUrl().contains("privacy"), "verify valid login or Invalid");
		System.out.println("I am In Invalid page");
		System.out.println("Test3");
	}

	@Test
	private void test2() {
		System.out.println("Test2");
	}

}
