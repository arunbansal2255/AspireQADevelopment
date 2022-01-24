package com.aspire.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aspire.qa.utility.TestUtil;

public class SeleniumBase {

	public static WebDriver driver;
	public static Properties property;

	public SeleniumBase() {
		try {
			property = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\91816\\eclipse-workspace\\AspireQADevelopment\\src\\main\\java\\com\\aspire\\qa\\config\\config.properties");
			property.load(fis);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initialization() {
		String browser = property.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//deleting all cookies
		driver.manage().deleteAllCookies();
		
		//define page load timeout
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		
		//defining implicityly wait
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		
		//open the url by using get method
		driver.get(property.getProperty("url"));
	}

}
