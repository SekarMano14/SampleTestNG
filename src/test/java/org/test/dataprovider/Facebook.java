package org.test.dataprovider;

import java.util.Date;

import org.base.BaseClass;
import org.pages.LoginPage;
import org.pages.RegistrationPage;
import org.testng.annotations.*;

public class Facebook extends BaseClass {
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

	@Test(dataProvider = "reg", dataProviderClass = Datas.class)
	private void test1(String fname, String lname) {
		launchUrl("https://www.facebook.com/");
		RegistrationPage r = new RegistrationPage();
		btnClick(r.getBtnCreate());
		fillTextBox(r.getTxtFirstname(), fname);
		fillTextBox(r.getTxtlastname(), lname);
		btnClick(r.getBtnSignUp());
		System.out.println("Test1");
	}

	@Test(dataProvider = "login", dataProviderClass = Datas.class)
	private void test3(String user, String pass) {
		launchUrl("https://www.facebook.com/");
		LoginPage l = new LoginPage();
		fillTextBox(l.getTxtUserName(), user);
		fillTextBox(l.getTxtPassword(), pass);
		btnClick(l.getBtnLogin());
		System.out.println("Test3");
	}

	@Test
	private void test2() {
		System.out.println("Test2");
	}

}
