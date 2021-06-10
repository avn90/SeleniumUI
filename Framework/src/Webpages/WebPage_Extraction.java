package Webpages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constants;

public class WebPage_Extraction extends Constants{

private WebDriver driver;
	
	List<WebElement> noofextractedwords;
	public WebPage_Extraction(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public String[] ExtractedWords() throws InterruptedException
	{
		//  System.out.println((driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div[2]")).getText()));
		
		WebDriverWait w= new WebDriverWait(driver,100);
		w.pollingEvery(1,TimeUnit.SECONDS);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]")));
	
			
		  noofextractedwords=driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/div"));
		  
		  System.out.println("Number of Keyword Extracted : "+noofextractedwords.size()/2);
		  
		  int words=noofextractedwords.size()/2;
		 
		  String s[]=new String[words+1];
		  
		  s[0] = String.valueOf(words);
		  
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  
		  int j=1;
		  
		  for (Iterator<WebElement> i = noofextractedwords.iterator(); i.hasNext();) 
		  {
			WebElement webElement = (WebElement) i.next();
			WebElement webElement1 = (WebElement) i.next();
			
			s[j]=webElement.getText();
		//	System.out.println(s[j]);
			
			
			js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",webElement1,"style","display: block;");
			
			Thread.sleep(100);
			try
			{
				System.out.println(s[j]+"   : "+(webElement1.getText())); //findElement(By.tagName("p"))
			}
			catch(NoSuchElementException e)
			{
				System.out.println(webElement.getText()+"   : Definition not available");
			}
			js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",webElement1,"style","display: none;");
			System.out.println();
			
			
			
			j++;
			
		  }
		 
		 
		 return s; 
		  
		  
	}
	public void Booklink() throws InterruptedException
	{
		
			System.out.println(noofextractedwords.get(10).getText());
			noofextractedwords.get(10).click();
			Thread.sleep(10000);
			try
			{
			System.out.println("Number of recommendation : "+driver.findElements(By.xpath("//*[@class='book-title-head']")).size());
			System.out.println("Link for book : "+driver.findElements(By.xpath("//*[@class='book-title-head']")).get(0).getText());
			
			WebElement e= driver.findElement(By.className("media-body"));
			
			Thread.sleep(3000);
			
			System.out.println("Chapter title : "+(e.findElements(By.tagName("a")).get(0).getText()));
			e.findElements(By.tagName("a")).get(0).click();
			Set <String> win = driver.getWindowHandles();
			
			for (String string : win) {
			
				driver.switchTo().window(string);
				System.out.println("Book URL : "+driver.getCurrentUrl());
				System.out.println("Page Title : "+driver.getTitle());
			
			}
			
			
			
			System.out.println(win.toString());
			}
			catch(NoSuchElementException e)
			{
				System.out.println("We could not find relevant Book Chapter(s) for the keyword");
			}
			
			
	}
	public void BackToDashboard() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		driver.navigate().back();
		
		
	}
		
	
}
