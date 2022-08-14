package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 
{
	
	@FindBy(id="userid") private WebElement UserId;	
	@FindBy(id="password") private WebElement Password;
	@FindBy(xpath="//button[@type='submit']") private WebElement LoginButton;

	public loginpage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		
	}

	public void sendUserID(String UN) 
	{
		UserId.sendKeys(UN);
	}

	public void sendPassword(String PWD) 
	{
		Password.sendKeys(PWD);
	}

	public void ClickOnLogin() 
	{
		LoginButton.click();
	}

}
