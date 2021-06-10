package utility;

public class Report 
{/*
	public static ExtentReports HTMLReports;
	public static com.aventstack.extentreports.ExtentTest TestCase;
/*	
	public static void NewHTMLReportsGenerate(String FilePath)
	{
		HTMLReports = new ExtentReports(FilePath);
	}
	
	public static void HTMLReportsTestCaseName(String TestCaseName, String TestCaseDescription)
	{
		TestCase = HTMLReports.startTest(TestCaseName, TestCaseDescription);
	}

	public static void HTMLReportsExecutionLogPass(String StepsDetails)
	{
		TestCase.log(LogStatus.PASS, StepsDetails);
	}
	
	public static void HTMLReportsExecutionLogFail(String StepsDetails)
	{
		TestCase.log(LogStatus.FAIL, StepsDetails);
	}
	
	public static void HTMLReportsEnd()
	{
		HTMLReports.endTest(TestCase);
	}
	
	public static void HTMLReportsflush()
	{
		HTMLReports.flush();
	}
	
	/*public static void HTMLReportsParentsTestCase()
	{
		ExtentTest parent = HTMLReports.startTest("Parent");
	}
	
	public static void HTMLReprotsChildTestCase(String Info)
	{
		ExtentTest child1 = HTMLReports.startTest("Child 1");
		child1.log(LogStatus.INFO, Info);
	}*/
	}
