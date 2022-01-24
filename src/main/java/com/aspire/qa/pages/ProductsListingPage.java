package com.aspire.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

public class ProductsListingPage extends SeleniumBase {
	
	
	@FindBy(xpath= "//button[contains(text(),'Create')]")
	WebElement create_button;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement search_product_field;
	
	@FindBy(xpath= "//i[@class = 'o_searchview_icon fa fa-search']")
	WebElement search_button;
	
	@FindBy(xpath= "//a[@title = 'Applications']")
	WebElement applications;
	
	

			
			
			// Initialization of elements
			public ProductsListingPage() {
				PageFactory.initElements(driver, this);
			}

			// verify Product menu item
			public boolean verifyCreateButtonIsDisplayed() {
				return create_button.isDisplayed();

			}

						
			//click Products
			public CreateProductPage clickCreateButton() {
				if(verifyCreateButtonIsDisplayed())
				{
				 create_button.click();
				 
				 return new CreateProductPage();
				}
				
				else
				{
					return null;
				}
			}
			
			public void searchProduct(String productName)
			{
				search_product_field.sendKeys(productName);
				search_button.click();
			}
			
			public void clickProduct(String productName, String salesprice, String internalRef)
			{
				verifyProductDetails(productName, salesprice, internalRef);
			}
			
			
			public void verifyProductDetails(String productName, String salesprice, String internalRef)
			{
				searchProduct(productName);
				driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+salesprice+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+internalRef+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]")).click();
				
			}
			
			public ApplicationsHomePage gotoHomePage()
			{
				applications.click();
				return new ApplicationsHomePage();
			}
			
			
			

}
