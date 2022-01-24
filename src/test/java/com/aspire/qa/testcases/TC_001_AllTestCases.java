package com.aspire.qa.testcases;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aspire.qa.base.SeleniumBase;
import com.aspire.qa.pages.ApplicationsHomePage;
import com.aspire.qa.pages.CreateProductPage;
import com.aspire.qa.pages.InventoryPage;
import com.aspire.qa.pages.LoginPage;
import com.aspire.qa.pages.ManufactoringOrdersListingPage;
import com.aspire.qa.pages.ProductsListingPage;



public class TC_001_AllTestCases extends SeleniumBase {

	LoginPage loginpage;
	ApplicationsHomePage apphomepage;
	InventoryPage inventory;
	ProductsListingPage products ;
	CreateProductPage createProduct;
	ManufactoringOrdersListingPage mol;
	
	
	
	public TC_001_AllTestCases() {
		// to load the config property
		super();
	}

	@BeforeTest
	public void setup() {
		// initialize the browser by calling initialization method
		initialization();

		// initialization of element by calling constructor
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void step1_login_webapplication() {
		// Fetch the login details from config
		apphomepage = loginpage.loginUser(property.getProperty("username"), property.getProperty("password"));
	}
	
	@Test(priority = 2, dependsOnMethods = "step1_login_webapplication")
	public void step2_naviagte_inventory_page() {
		inventory = apphomepage.clickInventory();
	}
	
	@Test(priority = 3,  dependsOnMethods = "step2_naviagte_inventory_page")
	public void step3_create_product() {
		
		inventory.selectProductMenuItem();
		
		products = inventory.selectProductSubMenuItem();
		
		createProduct = products.clickCreateButton();
		
		createProduct.createProduct("Arun Test product", "All",
				"INTREFARUN", "PRODUCTBAR1212", "20", "10", "Dozens", "Dozens", "internal notes Arun");
		
		
		
		
	}
	
	@Test(priority = 4, dependsOnMethods = "step3_create_product")
	public void step4_update_product_qty() {
		// Fetch the login details from config
		
		products = inventory.selectProductSubMenuItem();
		products.clickProduct("Arun Test product", "20", "INTREFARUN");
		
		
	}
	
	@Test(priority = 5, dependsOnMethods = "step4_update_product_qty")
	public void step5_navigate_to_home() {
		
		apphomepage = products.gotoHomePage();		
	}
	
	@Test(priority = 6, dependsOnMethods = "step5_navigate_to_home")
	public void step6_create_manufacturing_order() {
		
		
		apphomepage = products.gotoHomePage();		
		mol = apphomepage.clickManufacturing();
		
	}
	

	@AfterTest
	public void teardown() {

		// close the browser
		driver.quit();
	}

}
