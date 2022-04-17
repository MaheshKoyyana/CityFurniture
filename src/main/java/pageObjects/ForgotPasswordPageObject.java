package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageObject {

	WebDriver driver;
	
	By email = By.id("email_address");
	By submit =	By.xpath("//button[@class='button']");
	By goBack = By.xpath("//p[@class='back-link']//a");
	By txtHeader = By.xpath("//div[@class='page-title']//h1");
	By errorUser = By.xpath("//div[@class='validation-advice']");
	
	public ForgotPasswordPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmailAddress()
	{
		return driver.findElement(email);
	}
	
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	
	public WebElement getBack()
	{
		return driver.findElement(goBack);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(txtHeader);
	}
	public WebElement getUsernameError()
	{
		return driver.findElement(errorUser);
	}
	
}
