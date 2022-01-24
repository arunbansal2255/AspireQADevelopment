package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

public class ApplicationsHomePage extends SeleniumBase {

	// find Manufacturing field
	@FindBy(xpath = "//div[contains(text(),'Manufacturing')]")
	WebElement manufacturing;

	// find Inventory field
	@FindBy(xpath = "//div[contains(text(),'Inventory')]")
	WebElement inventory;

	// Initialization of elements
	public ApplicationsHomePage() {
		PageFactory.initElements(driver, this);
	}

	// verify inventory icon
	public boolean verifyInventory() {
		return inventory.isDisplayed();

	}

	// verify manufacturing icon
	public boolean verifyManufacturing() {
		return manufacturing.isDisplayed();

	}
	
	//click Manufacturing
	public ManufactoringOrdersListingPage clickManufacturing() {
	
		 manufacturing.click();
		 return new ManufactoringOrdersListingPage();
		 
	}
	
	//click inventory
	public InventoryPage clickInventory() {
		 inventory.click();
		 return new InventoryPage();

	}
	
	
}
