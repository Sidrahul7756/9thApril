package Testpackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePackage.Base;
import BasePackage.BaseNew;
import POMPackage.homepage;
import POMPackage.loginpage;
import POMPackage.pinpage;
import UtilityPackage.Utilitynew;
import UtilityPackage.Utilitypac;
@Listeners(UtilityPackage.Listener.class)
public class TestKiteNew extends BaseNew 
{
	loginpage l;
	pinpage p;
	homepage h;
	@BeforeClass
	public void launchbrowser() throws IOException 
	{
		 openbrowser();
		 l=new loginpage(driver);
		 p=new pinpage(driver);
		 h=new homepage(driver);
		 Utilitypac.waits(driver, 1000);
	}
	
	@BeforeMethod
	public void launchkite() throws EncryptedDocumentException, IOException 
	{
		l.sendUserID(Utilitynew.datareadPropertyFile("UN"));
	    Reporter.log("UserID send", true);
		l.sendPassword(Utilitynew.datareadPropertyFile("PWD"));
		Reporter.log("Password send", true);
		l.ClickOnLogin();
		Reporter.log("login successful", true);
		 Utilitypac.waits(driver, 1000);
		p.sendPin(Utilitynew.datareadPropertyFile("PIN"));
	    Reporter.log("Pin send", true);
		p.ClickOnContinue();
		Reporter.log("Continue process done", true);
		Utilitynew.waits(driver, 1000);
	}
	
  @Test
    public void main_TC() throws EncryptedDocumentException, IOException 
   {
	  String TCID = "123";
	  Assert.assertEquals(h.ValidationCheck(), Utilitynew.datareadPropertyFile("UN1"));
	  Reporter.log("Actual & Expected match", true);
	  
   }
  
  @AfterMethod
  public void closekite() throws InterruptedException 
  {
	  h.ClickOnlogout();
	  Utilitynew.waits(driver, 1000);
  }
  
  @AfterClass
  public void closewindow() 
  {
	  closebrowser();
	  
  }
}
