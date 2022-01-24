package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

/**
 * @author ArunBansal
 *
 */
public class LoginPage extends SeleniumBase {

	// find email field
	@FindBy(xpath = "//input[@id='login']")
	WebElement email;

	// find email field
	@FindBy(xpath = "//input[@id= 'password']")
	WebElement password;

	// find email field
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement Login_button;
	

	// Initialization of elements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Login method
	public ApplicationsHomePage loginUser(String useremail, String pwd) {
		email.sendKeys(useremail);
		password.sendKeys(pwd);
		Login_button.click();
		return new ApplicationsHomePage();

	}
	
	

}
