package Scenario;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BrowserUtility;
import utility.WebPageObjectRepo;

public class Multiplefiles extends BrowserUtility{

	WebPageObjectRepo objPageObjRepo;
	int NoOfFiles=1;

	@Test(priority = 0)
	public void multiplefilescenario() throws InterruptedException, IOException 
	{
		objPageObjRepo = new WebPageObjectRepo(driver);
		
		objPageObjRepo.excelobject().setup();
		
		
		
		objPageObjRepo.login().launchURL();
		
		if(!objPageObjRepo.login().login())
		{
				Assert.fail("Incorrect user Name or Password");
		}
	
		NoOfFiles=objPageObjRepo.excelobject().getNumberOfRows();
		
	//	NoOfFiles = NoOfFilestobeprocess;
		
		for (int row = 1; row <= NoOfFiles;row++)
		{
			String Cellvalues[]=objPageObjRepo.excelobject().cellvalues(row);
			
			if(Cellvalues[0]=="")
			{
				break;
			}
						
			String status = objPageObjRepo.dashboard().uploadNotes(Cellvalues[0],Cellvalues[1]);
			
			switch(status)
			{
				case "Success" : String values[] = objPageObjRepo.extraction().ExtractedWords();
			
								 objPageObjRepo.excelobject().pushNoOfKeywords(row,values);
		
							     objPageObjRepo.extraction().BackToDashboard();
							 
							     break;
							     
							     
				case "Timeout" : objPageObjRepo.excelobject().pushNoOfKeywords(row,"Timeout");
								 
								 driver.navigate().refresh();
								 
								 break;
								 
				 				 
					 default   : objPageObjRepo.excelobject().pushNoOfKeywords(row,status);
				 
								 driver.navigate().refresh();

								 break;
 			}
			
		}
			objPageObjRepo.excelobject().savefile();
		
		//objPageObjRepo.extraction().Booklink();
	}
}
