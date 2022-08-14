package BasePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
	protected WebDriver driver;
	public void openbrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\chromedriver.exe");
	    driver = new ChromeDriver();
		
	    driver.get("https://kite.zerodha.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
	}
	
	public void closebrowser() 
	{
		driver.close();
	}

}
