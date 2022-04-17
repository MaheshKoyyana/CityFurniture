package learning;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;

public class HomePageTest extends Base {
	
		public WebDriver driver;
	
		@BeforeTest
		public void setup() throws IOException
		{
			driver = initializeDriver();
			driver.manage().window().maximize();
		}

		@Test
		public void homePageNavigation() throws IOException
		{
			
			String url=prop.getProperty("url");
			driver.get(url);
			
			HomePageObject hp = new HomePageObject(driver);
			Actions a= new Actions(driver);
			a.moveToElement(hp.getMyaccount()).build().perform();
			a.moveToElement(hp.getSignIn()).click().build().perform();
			Assert.assertTrue(hp.getLoginHeader().isDisplayed());
			
		}
		
		@AfterTest
		public void tearDown()
		{
			driver.close();
		}
		
		
	
}
