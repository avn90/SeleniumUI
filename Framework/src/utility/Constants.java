package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants 
{
	
	public String GECKODRIVERPATH = "src\\browserdriver\\geckodriver.exe";
	
	public String CHROMEDRIVERPATH = "D:\\Softwares\\chromedriver.exe";
	
	public String AUTOMATIONURL = "https://scriptinator-qa.springernature.app/";
	
	public String ExtractionPageUrl = AUTOMATIONURL+"recommendation";
	
	public static String filename = "D:\\Scriptinator\\Input And Report Activity.xlsx";
	
	public String Dumpfilefolder = "D:\\Scriptinator\\Automation Folder\\";
	
	static DateFormat currentDateAndTime = new SimpleDateFormat("dd-MMM-yyyy__hh.mm.ssaa");	
	public static String REPORTFILEPATH = "D:\\ExtentReport\\Scriptinator"+ currentDateAndTime.format(new Date()) + ".html";
	
	public int timeoutinminute = 5;
	
	public int NoOfFilestobeprocess= 3;
	
	public String username = "admin";

	public String password = "admin@321";
	
	
}
