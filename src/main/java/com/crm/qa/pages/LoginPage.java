package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory - Object Repository:
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signUpbtn;
	
	@FindBy(xpath = "//a[@class='navbar-brand']/img")
	WebElement crmLogo;
	
	// How will you initialize your page factory?
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	

}
