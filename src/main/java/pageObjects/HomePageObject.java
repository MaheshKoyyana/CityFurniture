package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {

	WebDriver driver;
	
	By myAccount = By.cssSelector("div span[class*='my-account-item']");
	By signIn =	By.linkText("Sign In");
	By loginHeader = By.cssSelector("div[class='page-title cf-title-lg'] h1");
	
	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getMyaccount()
	{
		return driver.findElement(myAccount);
	}
	
	public WebElement getSignIn()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getLoginHeader()
	{
		return driver.findElement(loginHeader);
	}
	
	
	
}
