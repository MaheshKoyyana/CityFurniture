package learning;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
	    prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\kmahe\\eclipse-workspace\\CityFurniture\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("driver"));
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	
	}

}
