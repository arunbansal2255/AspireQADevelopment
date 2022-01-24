package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

public class EditProduct extends SeleniumBase{

	@FindBy(xpath= "//span[contains(text(),'Update Quantity')]")
	WebElement update_quantity;
	
	@FindBy(xpath= "//button[contains(text(),'Create')]")
	WebElement create_button;
	
	public EditProduct()
	{
		PageFactory.initElements(driver, this);
	}
	
	//click Update quantity Button
	public void clickUpdateQuantity()
	{
		update_quantity.click();
	}
}
