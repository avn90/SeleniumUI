package utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BrowserUtility extends Constants 
{

	public WebDriver driver;
	String browserName = "Chrome";
	
	@BeforeSuite
	public void browserSetup() throws IOException
	{
		if (browserName.equalsIgnoreCase("FireFox")) {

			System.setProperty("webdriver.gecko.driver", GECKODRIVERPATH);
			driver = new FirefoxDriver();
		}

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", CHROMEDRIVERPATH);
			driver = new ChromeDriver();
		}

		if (browserName.equalsIgnoreCase("IE")) 
		{

		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Report.NewHTMLReportsGenerate(REPORTFILEPATH);
	}
	
	@AfterSuite
	public void closeBrowser() {
		//driver.quit();
		//Report.HTMLReportsEnd();
	}
	
}
