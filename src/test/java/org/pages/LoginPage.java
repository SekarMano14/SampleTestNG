package org.pages;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
//	Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBys({@FindBy(id="email"),
		      @FindBy(xpath="//input[@name='email']")})
	private WebElement txtUserName;
	
	@FindAll({@FindBy(id="pass"),
		      @FindBy(xpath="//input[@name='pass']")})
	private WebElement txtPassword;
	
	@FindBy(name="login")
	private WebElement btnLogin;
	

	public WebElement  getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void login(String name,String pass) {
		fillTextBox(getTxtUserName(), name);
		fillTextBox(getTxtPassword(), pass);
		btnClick(getBtnLogin());
	}
	
	
	
	

}
