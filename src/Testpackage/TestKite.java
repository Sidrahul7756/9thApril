package Testpackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.Base;
import POMPackage.homepage;
import POMPackage.loginpage;
import POMPackage.pinpage;
import UtilityPackage.Utilitypac;

public class TestKite extends Base
{
	loginpage l;
	pinpage p;
	homepage h;
	@BeforeClass
	public void launchbrowser() 
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
		l.sendUserID(Utilitypac.datareadexcel(0, 0));
		l.sendPassword(Utilitypac.datareadexcel(0, 1));
		l.ClickOnLogin();
		Utilitypac.waits(driver, 1000);
		p.sendPin(Utilitypac.datareadexcel(0, 2));
		p.ClickOnContinue();
		Utilitypac.waits(driver, 1000);
	}
	
  @Test
    public void main_TC() throws EncryptedDocumentException, IOException 
   {
	  String TCID = "123";
	  Assert.assertEquals(h.ValidationCheck(), Utilitypac.datareadexcel(0, 0));
	  
	  Utilitypac.captureshot(driver, TCID);
   }
  
  @AfterMethod
  public void closekite() throws InterruptedException 
  {
	  h.ClickOnlogout();
	  Utilitypac.waits(driver, 1000);
  }
  
  @AfterClass
  public void closewindow() 
  {
	  closebrowser();
	  
  }
}
