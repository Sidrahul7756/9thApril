package Selenium_Practices;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class brokanlink {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		driver.manage().window().maximize();
        driver.get("https://vctcpune.com/selenium/practice.html");
       Thread.sleep(2000);
       
       List<WebElement> links = driver.findElements(By.xpath("//footer[@id='footerid']//div/li/a"));
       
       for(WebElement link:links)
       {
    	   String url = link.getAttribute("href");
    	   
    	  HttpURLConnection conn =   (HttpURLConnection)new URL(url).openConnection();
    	  
    	  conn.setRequestMethod("Head");
    	  conn.connect();
    	  int resccode = conn.getResponseCode();
    	  
    	  if(resccode>400) 
    	  {
    		  System.out.println("the link name is"+link.getText()+"with response code"+resccode);
    		  Assert.assertTrue(false);
    		  
    	  }
       }

	}

}
