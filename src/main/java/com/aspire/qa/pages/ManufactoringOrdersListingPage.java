package com.aspire.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

public class ManufactoringOrdersListingPage extends SeleniumBase{
	
	@FindBy(xpath= "//button[contains(text(),'Create')]")
	WebElement create_button;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement search_order_field;
	
	@FindBy(xpath= "//i[@class = 'o_searchview_icon fa fa-search']")
	WebElement search_button;
	
	@FindBy(xpath= "//a[@title = 'Applications']")
	WebElement applications;
	
	

			
			
			// Initialization of elements
			public ManufactoringOrdersListingPage() {
				PageFactory.initElements(driver, this);
			}

			// verify Product menu item
			public boolean verifyCreateButtonIsDisplayed() {
				return create_button.isDisplayed();

			}

						
			//click Products
			public ManufactoringCreateOrderPage clickCreateButton() {
				if(verifyCreateButtonIsDisplayed())
				{
				 create_button.click();
				 
				 return new ManufactoringCreateOrderPage();
				}
				
				else
				{
					return null;
				}
			}
			
			public void searchProduct(String productName)
			{
				search_order_field.sendKeys(productName);
				search_button.click();
			}
			
			public void clickOrder(String productName, String salesprice, String internalRef)
			{
				verifyOrderDetails(productName, salesprice, internalRef);
			}
			
			
			public void verifyOrderDetails(String productName, String salesprice, String internalRef)
			{
				searchProduct(productName);
				
			}
			
			public ApplicationsHomePage gotoHomePage()
			{
				applications.click();
				return new ApplicationsHomePage();
			}
			

}
