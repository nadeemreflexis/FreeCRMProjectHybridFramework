package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
	}
	
	@Test(priority = 1)
	public void validateHomePagetitleTest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority = 2)
	public void validateUserlabelTest() {
		boolean flag = homepage.ValidateHomepageuserLabel(prop.getProperty("labelName"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void clickOnContactsLink() {
		contactspage = homepage.clickOnContactsLink();
	}
	
	@Test(priority = 4)
	public void clickOnDealsLink() {
		dealspage = homepage.clickOnDealsLink();
	}
	
	@Test(priority = 5)
	public void clickOnTasksLink() {
		taskspage = homepage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
