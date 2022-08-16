package Selenium_Practices;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[text()='Date']")).click();
        Thread.sleep(2000);
       // driver.findElement(By.xpath("(//div[@class='rb-calendar']//tr)[1]")).getText().contains("May");
        while(!driver.findElement(By.xpath("(//div[@class='rb-calendar']//td)[2]")).getText().contains("Jun 2024")) 
        {
        	driver.findElement(By.xpath("(//div[@class='rb-calendar']//td)[3]")).click();
        	
        }
        
        java.util.List<WebElement> Days = driver.findElements(By.xpath("//td[@class='wd day']"));
        
        for(WebElement day:Days)
        {
        	if(day.getText().equals("10")) 
        	{
        		day.click();
        		break;
        	}
        }
        
   //     List<WebElement> Days = driver.findElements(By.xpath("//td[@class='wd day']"));
        
//        for(WebElement day:Days) 
//        {
//        	if(day.getText().equals("10")) 
//        	{
//        		day.click();
//        		break;
//        	}
//        
//        }
	}

}
