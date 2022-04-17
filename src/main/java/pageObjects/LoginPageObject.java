package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	WebDriver driver;
	
	By userName = By.xpath("//input[@name='login[username]']");
	By password =	By.id("pass");
	By login = By.xpath("//div[@class='col-2']//button[@title='Login']");
	By errorUsername = By.id("advice-validate-email-email");
	By emptyPass = By.xpath("//div[@id='advice-required-entry-pass']");
	By emptyUsername = By.xpath("//div[@id='advice-required-entry-email']");
	By errorPassword = By.cssSelector("ul[class='messages'] span");
	By forgotlink	= By.linkText("Forgot Your Password?");
	By afterLoginAccount = By.cssSelector("div[class*='myAccountLabel']");
	By signOut = By.linkText("Sign Out");
	
	public LoginPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getUsername()
	{
		return driver.findElement(userName);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getUsernameError()
	{
		return driver.findElement(errorUsername);
	}
	public WebElement getEmptyPasswordError()
	{
		return driver.findElement(emptyPass);
	}
	public WebElement getEmptyUsernameError()
	{
		return driver.findElement(emptyUsername);
	}
	public WebElement getPasswordError()
	{
		return driver.findElement(errorPassword);
	}
	public WebElement getForgotLink()
	{
		return driver.findElement(forgotlink);
	}
	public WebElement getMyLogin()
	{
		return driver.findElement(afterLoginAccount);
	}
	public WebElement getSignOut()
	{
		return driver.findElement(signOut);
	}

}
