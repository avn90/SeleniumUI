package Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.*;

public class WebPage_Login extends Constants
{
	private WebDriver driver;
	
	public WebPage_Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "username")
	WebElement Username;
	
	@FindBy(id = "password")
	WebElement Password;
	
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/form/button")
	WebElement btn_Login;
	
	public void launchURL()
	{
		driver.get(AUTOMATIONURL);
	}
	
	public boolean login() throws InterruptedException
	{
		
			Username.sendKeys(username);
			Password.sendKeys(password);
			btn_Login.click();
			Thread.sleep(3000);
			
			if(driver.findElement(By.xpath("//*[@id=\'content\']/div/div/div[1]")).getText().equalsIgnoreCase("User or Password you enter is incorrect!"))
			{
				return false;
			}
			return true;
			
	}
}
