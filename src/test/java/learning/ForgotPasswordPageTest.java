package learning;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPageObject;
import pageObjects.LoginPageObject;

public class ForgotPasswordPageTest extends Base {
	
		public WebDriver driver;
		public String loginUrl;
		public String forgotPasswordUrl;
				
		@BeforeTest
		public void setup() throws IOException
		{
			driver = initializeDriver();
			loginUrl=prop.getProperty("loginurl");
			forgotPasswordUrl=prop.getProperty("forgotLink");
			driver.get(loginUrl);
			driver.manage().window().maximize();
		}
		

		@Test
		public void clickForgotPassword()
		{
			LoginPageObject lp = new LoginPageObject(driver);
			ForgotPasswordPageObject fp = new ForgotPasswordPageObject(driver);
			lp.getForgotLink().click();
			System.out.println(fp.getHeader().getText());
			Assert.assertTrue(fp.getHeader().isDisplayed());
			
		}
		
		@Test
		public void validateEmailAddress()
		{
			driver.get(forgotPasswordUrl);
			ForgotPasswordPageObject fp = new ForgotPasswordPageObject(driver);
			fp.getEmailAddress().sendKeys("abc");
			fp.getSubmit().click();
			Assert.assertEquals(fp.getUsernameError().getText(), "Please enter a valid email address. For example johndoe@domain.com.");
		}
		
		@Test
		public void validateBackButton()
		{
			driver.get(forgotPasswordUrl);
			ForgotPasswordPageObject fp = new ForgotPasswordPageObject(driver);
			fp.getBack().click();
			LoginPageObject lp = new LoginPageObject(driver);
			Assert.assertTrue(lp.getLogin().isDisplayed());
			
		}
		@Test
		public void validateCorrectEmail()
		{
			driver.get(forgotPasswordUrl);
			ForgotPasswordPageObject fp = new ForgotPasswordPageObject(driver);
			fp.getEmailAddress().sendKeys("abc@gmail.com");
			fp.getSubmit().click();
			LoginPageObject lp = new LoginPageObject(driver);
			Assert.assertTrue(lp.getLogin().isDisplayed());
		}
		
		
		
		
		@AfterTest
		public void tearDown()
		{
			driver.close();
		}
		
		
	
}
