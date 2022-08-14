package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pinpage
{
	
	@FindBy(id="pin") private WebElement PIN;
	@FindBy(xpath="//button[@type='submit']") private WebElement ContinueButton;
	
	public pinpage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void sendPin(String Pin) 
	{
		PIN.sendKeys(Pin);
	}
	
	public void ClickOnContinue() 
	{
		ContinueButton.click();
	}

}
