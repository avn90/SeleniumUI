package Webpages;

import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import utility.Constants;

public class WebPage_Dashboard extends Constants{

private WebDriver driver;
	
	public WebPage_Dashboard(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "subject-area")
	WebElement Subject;
	
	@FindBy(css = "input[value='text']")
	WebElement btn_inputKeywords;
	
	@FindBy(css = "input[value='upload']")
	WebElement btn_uploadNote;
		
	@FindBy(id = "source_file")
	WebElement file;
	
	@FindBy(id = "input-keywords")
	WebElement inputKeywords;
	
	@FindBy(name = "language-option")
	WebElement language;
	public String uploadNotes(String filename, String filesubject) throws InterruptedException
	{
		  try
		  {
		  Select sub= new Select(Subject);
		  sub.selectByVisibleText(filesubject);
		  }
		  catch(Exception e)
		  {
			  return "Subject not found";
		  }
		 
		  try
		  {
		  
			  file.sendKeys(Dumpfilefolder+filename);
			  Thread.sleep(2000);
		  	  driver.findElement(By.id("isauthenticated")).click();
	
		  }
		  catch(Exception e)
		  {
			  return "file not found";
		  }
		  System.out.println("Processing");
		  Date d1=Calendar.getInstance().getTime();
		  Date d2=d1;
		  int diff=0;
		  
		  while((d2.getTime() - d1.getTime())/(60*1000) % 60 < timeoutinminute)
		  {
			  
			  try
			  {
				  
				  if((driver.getCurrentUrl().equalsIgnoreCase(ExtractionPageUrl) ||(driver.findElement(By.xpath("//*[@id=\"error-msg\"]")).isDisplayed()) || driver.findElement(By.xpath("//*[@id=\"flash-alert\"]"))!=null))
				  {
					  break;
				  }
			  }
  			  catch(NoSuchElementException e)
			  {
			
			  }
			  
			  d2=Calendar.getInstance().getTime();
			  
			  diff = (int) ((d2.getTime() - d1.getTime())/(60*1000) % 60);
		  }
		  

		  
		  if(diff >= timeoutinminute)
	  		  return "Timeout";

		  try
		  {
			  if(driver.getCurrentUrl().equalsIgnoreCase(ExtractionPageUrl))
			  		  return "Success";
		  }
		  catch(NoSuchElementException e)
		  {
		  }
		  
		  try
		  {
			  if((driver.findElement(By.xpath("//*[@id=\"error-msg\"]")).isDisplayed()))
			  		  return driver.findElement(By.xpath("//*[@id=\"error-msg\"]")).getText();
		  }
		  catch(NoSuchElementException e)
		  {
		  }
		  
		  try
		  {
			  if(driver.findElement(By.xpath("//*[@id=\"flash-alert\"]"))!=null)
			  {	  //System.out.println(driver.findElement(By.xpath("//*[@id=\"flash-alert\"]")).getText());
			        return driver.findElement(By.xpath("//*[@id=\"flash-alert\"]")).getText();
			  }
	      }
		  catch(NoSuchElementException e)
		  {
		  }
		
		  return "";
		 
		
	}
	
	public void InputKeywords() throws InterruptedException
	{
		  btn_inputKeywords.click();
		
		  Select sub= new Select(Subject);
		  sub.selectByVisibleText("Life Sciences");
		
		  Select lang= new Select(language);
		  lang.selectByVisibleText("English");
		
		  
		  inputKeywords.sendKeys("DNA, Brain, Heart, Lungs, Legs, Bones, Liver, Kidney");
		  Thread.sleep(3000);
		  
		  
		  
//		  Robot r= new Robot();
//		  r.keyPress(KeyEvent.VK_ENTER);
//		  r.keyRelease(KeyEvent.VK_ENTER);
		  
		  driver.findElement(By.id("isauthenticated")).click();
		  
	}
}
