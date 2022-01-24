package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

public class InventoryPage extends SeleniumBase {
	
	// find Products menu item
		@FindBy(xpath = "//a[contains(text(),'Products')]")
		WebElement products_menu_item;

		// find product drop down link
		@FindBy(xpath = "//a[@class = 'dropdown-item o_menu_entry_lvl_2']//span[contains(text(),\"Products\")]")
		WebElement product_drop_down_item;
		
		//find Applications on top left 
		@FindBy(xpath = "//a[@title = 'Applications']")
		WebElement applications;
		
		// Initialization of elements
		public InventoryPage() {
			PageFactory.initElements(driver, this);
		}

		// verify Product menu item
		public boolean verifyProductMenuItem() {
			return products_menu_item.isDisplayed();

		}

		// verify Products sub menu item
		public boolean verifyProductDropDownItem() {
			return product_drop_down_item.isDisplayed();

		}
		
		//click Products
		public void selectProductMenuItem() {
			if(verifyProductMenuItem())
			{
			 products_menu_item.click();
			}
		}
		
		//click Products drop down
				public ProductsListingPage selectProductSubMenuItem() {
					if(verifyProductDropDownItem())
					{
						product_drop_down_item.click();
						return new ProductsListingPage();
					}
					
					else
					{
						return null;
					}
				}
		
		

}
