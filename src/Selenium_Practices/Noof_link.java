package Selenium_Practices;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Noof_link {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		driver.manage().window().maximize();
        driver.get("https://vctcpune.com/selenium/practice.html");
       Thread.sleep(2000);

       int count = driver.findElements(By.xpath("(//footer[@id='footerid']//div)[4]/li")).size();
       System.out.println(count);
        java.util.List<WebElement> as = driver.findElements(By.xpath("(//footer[@id='footerid']//div)[4]/li"));
       for(WebElement abc:as) 
       {
    	   System.out.println(abc.getText());
       }
       
       for(int i=0;i<count;i++) 
       {
    	   String pass = Keys.chord(Keys.CONTROL,Keys.ENTER);
    	   driver.findElements(By.xpath("(//footer[@id='footerid']//div)[4]/li/a")).get(i).sendKeys(pass);
    	   Thread.sleep(2000);
       }
       
       Set<String> ids = driver.getWindowHandles();
       java.util.Iterator<String> 
       it = ids.iterator();
       while(it.hasNext()) 
       {
    	   driver.switchTo().window(it.next());
    	  System.out.println(driver.getTitle());
       }

	}

}
