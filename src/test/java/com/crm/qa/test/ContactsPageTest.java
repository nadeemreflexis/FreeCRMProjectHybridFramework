package com.crm.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;

	String sheetName = "contacts";

	// Before every test case - launch the browser and login in
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
		contactsPage = homepage.clickOnContactsLink();
	}

	//Execute test case
	@Test(priority = 1)
	public void validateContactsLabel() {
		boolean flag = contactsPage.validateContactsLabel();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void validateSigleContactSelection() {
		Assert.assertTrue(contactsPage.ContactsSelection("Nadeem Zaya"));
	}

	@Test(priority = 3)
	public void validateMultipleContactSelection() {
		Assert.assertTrue(contactsPage.ContactsSelection("Nadeem Zaya"));
		Assert.assertTrue(contactsPage.ContactsSelection("Shalini Soni"));
	}

	@DataProvider
	public Object[][] getContactsData() throws IOException {
		Object[][] data =TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getContactsData")
	public void createNewContacts(String Title,String FirstName,String LastName,String Company) {
		homepage.clickOnNewContactsLink();
		contactsPage.createNewContact(Title,FirstName,LastName,Company);	
	}

	// after test case execution close the browser
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
