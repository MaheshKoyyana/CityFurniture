package learning;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;

public class LoginPageTest extends Base {
	
		public WebDriver driver;
		public String loginUrl;
		
		@BeforeTest		
		public void setup() throws IOException
		{
			driver = initializeDriver();
			driver.manage().window().maximize();
			loginUrl=prop.getProperty("loginurl");
		}
		

		@Test
		public void loginTest()
		{
			driver.get(loginUrl);
			LoginPageObject lp = new LoginPageObject(driver);
			lp.getUsername().sendKeys("kmaheshmec@gmail.com");
			lp.getPassword().sendKeys("Q@1weasdzxc");
			lp.getLogin().click();
			Actions a = new Actions(driver);
			a.moveToElement(lp.getMyLogin()).build().perform();
			lp.getSignOut().click();
	
			
		}
		
		@Test
		public void validateEmail()
		{
			
			driver.get(loginUrl);
			LoginPageObject lp = new LoginPageObject(driver);
			lp.getUsername().sendKeys("abc");
			lp.getPassword().sendKeys("abc");
			lp.getLogin().click();
			Assert.assertEquals(lp.getUsernameError().getText(), "Please enter a valid email address. For example johndoe@domain.com.");
		}
		
		@Test
		public void validateEmptyPassword()
		{
			driver.get(loginUrl);
			LoginPageObject lp = new LoginPageObject(driver);
			lp.getUsername().sendKeys("kmaheshmec@gmail.com");
			lp.getLogin().click();
			Assert.assertEquals(lp.getEmptyPasswordError().getText(), "This is a required field.");
		}
		@Test
		public void validateEmptylogin()
		{
			driver.get(loginUrl);
			LoginPageObject lp = new LoginPageObject(driver);
			lp.getLogin().click();
			Assert.assertEquals(lp.getEmptyUsernameError().getText(), "This is a required field.");
			Assert.assertEquals(lp.getEmptyPasswordError().getText(), "This is a required field.");
		}
		
		
		@Test
		public void validatePassword()
		{
			driver.get(loginUrl);
			LoginPageObject lp = new LoginPageObject(driver);
			lp.getUsername().sendKeys("kmaheshmec@gmail.com");
			lp.getPassword().sendKeys("abcdefg");
			lp.getLogin().click();
			Assert.assertEquals(lp.getPasswordError().getText(), "Invalid login or password.");
		}
		
		
		@AfterTest
		public void tearDown()
		{
			driver.close();
		}
		
		
	
}
