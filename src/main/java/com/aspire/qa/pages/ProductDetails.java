package com.aspire.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

public class ProductDetails extends SeleniumBase {

	@FindBy(xpath= "//button[contains(text(),'Edit')]")
	WebElement edit_button;
	
	public ProductDetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	public EditProduct clickEditbutton()
	{
		edit_button.click();
		return new EditProduct();
	}
	
	public void verifyProductDetails(String productName, String salesprice, String internalRef)
	{
		ProductsListingPage p = new ProductsListingPage();
		p.searchProduct(productName);
		driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]")).isDisplayed();
		driver.findElement(By.xpath("//span[contains(text(),'"+salesprice+"')]")).isDisplayed();
		driver.findElement(By.xpath("//span[contains(text(),'"+internalRef+"')]")).isDisplayed();
		driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]")).click();
		
	}

}
