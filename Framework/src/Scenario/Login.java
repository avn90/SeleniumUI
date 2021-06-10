package Scenario;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BrowserUtility;
import utility.WebPageObjectRepo;

public class Login extends BrowserUtility
{
	
	WebPageObjectRepo objPageObjRepo;

	@Test(priority = 0)
	public void loginScriptinator() throws InterruptedException, IOException 
	{
	
		objPageObjRepo = new WebPageObjectRepo(driver);
		
		objPageObjRepo.login().launchURL();
		
		if(!objPageObjRepo.login().login())
		{
				Assert.fail("Incorrect user Name or Password");
		}
		//objPageObjRepo.dashboard().uploadNotes();		
	}
	
	@Test(priority = 1, dependsOnMethods = {"loginScriptinator"})
	public void uploadLectureNotes() throws InterruptedException
	{
		//objPageObjRepo.dashboard().InputKeywords();
	/*	 if(!objPageObjRepo.dashboard().uploadNotes("D:\\Scriptinator\\Subject wise files\\Skript_Grundlagen_der_Informatik.pdf","Life Science"))
		 {
			 Assert.fail("Received error while processing file");
		 }
	*/
	}
	@Test(priority = 2, dependsOnMethods = {"uploadLectureNotes"})
	public void extraction() throws InterruptedException
	{
		objPageObjRepo.extraction().ExtractedWords();
		objPageObjRepo.extraction().Booklink();
		//objPageObjRepo.dashboard().uploadNotes();		
	}
	
	
	
	
}
