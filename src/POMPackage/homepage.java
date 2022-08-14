package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage 
{
	@FindBy(xpath="//span[@class='user-id']") private WebElement UserIdtext;
	@FindBy(xpath="//a[@target='_self']") private WebElement ClickOnLogout;
	
	public homepage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidationCheck() 
	{
		
		String actText = UserIdtext.getText();
		return actText;
			
		
	}
	public void ClickOnlogout() throws InterruptedException
	{
		UserIdtext.click();
		Thread.sleep(1000);
		ClickOnLogout.click();
		
	}

}
