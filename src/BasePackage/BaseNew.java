package BasePackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import UtilityPackage.Utilitynew;

public class BaseNew 
{
	 protected static  WebDriver driver;
	public void openbrowser() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\chromedriver.exe");
	    driver = new ChromeDriver();
		
	    driver.manage().window().maximize();
	    
	    driver.get(Utilitynew.datareadPropertyFile("URL"));
	    Reporter.log("Browser is launched", true);
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
	}
	public static void captureshot( String TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Reporter.log("Screenshot is taken", true);
		File dest=new File("E:\\New folder\\TC"+TCID+"jpg");
		FileHandler.copy(src, dest);
			
	}
	
	public void closebrowser() 
	{
		driver.close();
		   Reporter.log("Browser is Closed", true);
	}

}
