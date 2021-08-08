package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(id = "first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(id = "surname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	@CacheLookup
	WebElement saveBtn;
	// for saveBtn we are getting 3 elements for one xpath out of which 2 are not visible and 1 is visible so it should work
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateContactsLabel() {
		return ContactsLabel.isDisplayed();
	}
	
	public boolean ContactsSelection(String name) {
		WebElement checkbox =driver.findElement(By.xpath("//form[@id='vContactsForm']/table/tbody/tr/td[2]/a[contains(text(),'"+name+"')]/"
				+ "parent::td/parent::tr/td/input"));
		checkbox.click();
		return checkbox.isSelected();
	}
	
	public void createNewContact(String title,String ftName,String ltName,String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		//Its not compulsory that we only use page factory, we can use findElement also in POM
		select.selectByValue(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
}
