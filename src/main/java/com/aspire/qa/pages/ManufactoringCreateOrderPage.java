package com.aspire.qa.pages;


import org.openqa.selenium.support.PageFactory;

import com.aspire.qa.base.SeleniumBase;

public class ManufactoringCreateOrderPage  extends SeleniumBase{
	
	//initialize the page elements by calling Page factory method in constructor
			public ManufactoringCreateOrderPage()
			{
				PageFactory.initElements(driver,this);
			}

		

}
