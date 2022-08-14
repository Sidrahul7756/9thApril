package UtilityPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilitypac 
{
	
	public static String datareadexcel(int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
	   File myfile=new File("C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\Parameter.xlsx");
	    org.apache.poi.ss.usermodel.Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
	   
	   String value = mysheet.getRow(rowno).getCell(cellno).getStringCellValue();
	   return value;
	   
	}
	
	public static void captureshot(WebDriver driver, String TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\New folder\\TC"+TCID+"jpg");
		FileHandler.copy(src, dest);
			
	}

	public static void waits(WebDriver driver,int time) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}
}
