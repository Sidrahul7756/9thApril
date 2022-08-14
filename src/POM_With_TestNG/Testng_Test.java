
package POM_With_TestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng_Test {
	WebDriver driver;
	 File myfile;
	 Sheet mysheet;
	 loginpage login;
	 pinpage pin;
	 homepage home;
	@BeforeClass
	public void launchkite() throws EncryptedDocumentException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://kite.zerodha.com/");
	    driver.manage().window().maximize();
	    myfile=new File("C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\Parameter.xlsx");
	    mysheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
	    login=new loginpage(driver);
	    pin=new pinpage(driver);
	    home=new homepage(driver);

	}

	@BeforeMethod
	public void login() 
	{
		login.sendUserID(mysheet.getRow(0).getCell(0).getStringCellValue());
		login.sendPassword(mysheet.getRow(0).getCell(1).getStringCellValue());
		login.ClickOnLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		pin.sendPin(mysheet.getRow(0).getCell(2).getStringCellValue());
		pin.ClickOnContinue();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}

	@Test
	public void maincase()
	{
		String actualText = home.ValidationCheck();
		String exptText = mysheet.getRow(0).getCell(0).getStringCellValue();
		Assert.assertEquals(actualText, exptText,"TC fail when does not match");

	}
	
	
	@AfterMethod
	public void logout() throws InterruptedException 
	{
		home.ClickOnlogout();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		
	}
	
	@AfterClass
	public void close() 
	{
		driver.close();
	}
	
}
