package Popup;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class iframe {

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SeleniumInstallation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		    driver.manage().window().maximize();
		    driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	        Thread.sleep(2000);
	        //hii
	        //getText method
	        WebElement text = driver.findElement(By.xpath("//h1[text()='Frames Examples in Selenium Webdriver']"));
	        System.out.println(text.getText());
	        
	        //iFrame
	        driver.switchTo().frame("frame1");
	        Thread.sleep(500);
	        driver.findElement(By.tagName("input")).sendKeys("Selenium IFrame");
	        
	        driver.switchTo().frame("frame3");
	        Thread.sleep(500);
	        driver.findElement(By.id("a")).click();
	        Thread.sleep(500);
	        driver.switchTo().parentFrame();
	        
	        Thread.sleep(2000);
	        driver.switchTo().frame("frame2");
	        Thread.sleep(1000);
	        WebElement Animal1 = driver.findElement(By.id("animals"));
	        Select S=new Select(Animal1);
	        Thread.sleep(2000); 
	        S.selectByIndex(2);
	        

	        
	
	}

}
