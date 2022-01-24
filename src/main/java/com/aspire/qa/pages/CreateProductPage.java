package com.aspire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

public class CreateProductPage extends SeleniumBase {
	
	//initialize the page elements by calling Page factory method in constructor
		public CreateProductPage()
		{
			PageFactory.initElements(driver,this);
		}

	@FindBy(xpath="//input[@id='o_field_input_930']")
	WebElement product_name;
	
	@FindBy(xpath="//select[@id='o_field_input_934']")
	WebElement product_type;
	
	@FindBy(xpath="//select[@id='o_field_input_936']")
	WebElement internal_reference;
	
	@FindBy(xpath="//select[@id='o_field_input_937']")
	WebElement barcode;
	
	@FindBy(xpath="//select[@id='o_field_input_938']")
	WebElement sales_price;
	
	@FindBy(xpath="//select[@id='o_field_input_939']")
	WebElement cost;
	
	@FindBy(xpath="//select[@id='o_field_input_940']")
	WebElement unit;
	
	@FindBy(xpath="//select[@id='o_field_input_941']")
	WebElement purchase_unit;
	
	@FindBy(xpath="//select[@id='o_field_input_978']")
	WebElement internal_notes;
	
	@FindBy(xpath= "//button[contains(text(),'Save')]")
	WebElement save_button;
	
	
	public void createProduct(String productName, String productType,
			String internalReference, String productBarcode, String saleprice, 
			String costPrice, String productUnit, String purchaseUnit, String internalNotes)
	{
		product_name.sendKeys(productName);
		product_type.sendKeys(productType);
		internal_reference.sendKeys(internalReference);
		barcode.sendKeys(productBarcode);
		sales_price.sendKeys(saleprice);
		cost.sendKeys(costPrice);
		unit.sendKeys(productUnit);
		purchase_unit.sendKeys(purchaseUnit);
		internal_notes.sendKeys(internalNotes);
		save_button.click();
		
		
		
	}
	
}
