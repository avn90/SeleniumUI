package utility;

import org.openqa.selenium.WebDriver;

import Webpages.WebPage_Dashboard;
import Webpages.WebPage_Extraction;
import Webpages.WebPage_Login;

public class WebPageObjectRepo 
{
	private WebDriver driver;
	public WebPageObjectRepo (WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	WebPage_Login loginPage;
	WebPage_Dashboard dashboardPage;
	WebPage_Extraction extractionPage;
	ExcelFileUtility excelutility;
	
	public WebPage_Login login()
	{
		if(loginPage==null)
			loginPage = new WebPage_Login(driver);
		
		return loginPage;
	}
	public WebPage_Dashboard dashboard()
	{
		if(dashboardPage==null)
			dashboardPage = new WebPage_Dashboard(driver);
		
		return dashboardPage;
	}
	public WebPage_Extraction extraction()
	{
		if(extractionPage==null)
			extractionPage = new WebPage_Extraction(driver);
		
		return extractionPage;
	}
	public ExcelFileUtility excelobject()
	{
		if(excelutility==null)
			excelutility = new ExcelFileUtility();
		
		return excelutility;
	}
		

}
