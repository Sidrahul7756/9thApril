package UtilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utilitynew 
{
	
	public static String datareadPropertyFile(String Key) throws IOException
	{
	   Properties prop=new Properties();
	   
	   FileInputStream myfile=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace3\\Automation\\Myproperty.properties");
	   
	   prop.load(myfile);
	   
	   String value = prop.getProperty(Key);
	   
	   return value;
	}
	
	

	public static void waits(WebDriver driver,int time) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}
}
