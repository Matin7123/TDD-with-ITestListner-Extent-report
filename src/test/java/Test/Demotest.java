package Test;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import pages.Baseclass;
import pages.PomPages;
import pages.UtilityClass;

public class Demotest extends Baseclass
{
	
	public ExtentHtmlReporter htmlreporter ;
	public ExtentReports extent;
	public ExtentTest test;   
	PomPages ps;
	SoftAssert as = new SoftAssert();

	
	
		@BeforeClass
		public void openbrowser() throws EncryptedDocumentException, InterruptedException, IOException 
		{
				
			initilizebrowser(UtilityClass.property_file("Browsername"));
			ps=new PomPages(driver);
		
			// Set up Extent Reports
		}
	
		
		@BeforeTest
		public void configureExtentReport ()
		{
			htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myreport.html");
			htmlreporter.config().setDocumentTitle("Automation Report"); //title
			htmlreporter.config().setReportName("Functional report");
			htmlreporter.config().setTheme(Theme.DARK);
	  
			extent = new ExtentReports();
			extent.attachReporter(htmlreporter);
			extent.setSystemInfo("Hostname", "LocalHost");
			extent.setSystemInfo("OS", "Windows11");
			extent.setSystemInfo("Tester Name ", "Matin");
			extent.setSystemInfo("browser", "chrome");
				
		}
		
		@Test(priority = 1)
		public void verifyHeadline() throws EncryptedDocumentException, IOException
		{
			  test=extent.createTest("verifyHeadline");
			  String text = ps.scroll();
			  as.assertEquals(text, UtilityClass.TestData(0, 1));
		}
		
		@Test(priority = 2)
		public void verifyfirstname() throws EncryptedDocumentException, IOException 
		{
			
			  test=extent.createTest("verifyfirstname");
	
			
			  ps.enterfirstname(UtilityClass.TestData(0, 0));
			  String firstnametext = ps.getFirstname();
			  as.assertEquals(firstnametext, UtilityClass.TestData(0, 0), "First name Testcase passed");
			  ps.enterlastname(UtilityClass.TestData(1, 0));
	    }
		
		@Test(priority = 3)
		public void verifyEmail() throws EncryptedDocumentException, IOException
		{
			
			test=extent.createTest("email");

			ps.enteremail(UtilityClass.TestData(2, 0));
			String getmailtext = ps.getEmail();
			as.assertEquals(getmailtext, UtilityClass.TestData(2, 0), "Email testcase passed");
		}
		
		@Test(priority = 4)
		public void verifyDateOfBirth() throws EncryptedDocumentException, IOException, InterruptedException 
		{
			test=extent.createTest("verifyDateOfBirth");

			ps.entermobile(UtilityClass.TestData(3, 0));
			ps.enterdateofbirth();
		
			String dateofbirth = ps.getdateofbirth();
		
			as.assertEquals(dateofbirth, UtilityClass.TestData(4, 0), "date of birth test case passed");
		}
		
		@Test(priority = 5)
		public void verifySubject() throws EncryptedDocumentException, IOException, InterruptedException 
		{
			test=extent.createTest("verifySubject");
			
			ps.entersubject(UtilityClass.TestData(5, 0));
			ps.clickHobies();
			String verifytext = ps.gettextsubject();
			as.assertEquals(verifytext, UtilityClass.TestData(5, 0));
		}
		
		@Test(priority = 6)
		public void submitForm() throws InterruptedException 
		{
			ps.clickHobies();
		}
		
	
		@AfterTest
		public void endReport() 
		{
			extent.flush();
		}
		
		
        @AfterMethod
        public void tearDown(ITestResult result) throws IOException 
        {
        	
				if(result.getStatus()==ITestResult.FAILURE) 
				{
					test.log(Status.FAIL,"Failed Test Case : "+result.getName());
					test.log(Status.FAIL,"Failed Test Case : "+result.getThrowable());
			
					String screenshotPath=UtilityClass.getscreenshot(driver, result.getName());
					test.addScreenCaptureFromPath(screenshotPath);
				}
				else if(result.getStatus()==ITestResult.SUCCESS) 
				{
					test.log(Status.PASS,"Passed Test Case : "+result.getName());
				}
        }
        
        
		@AfterClass	
        public void closeBrowser() throws InterruptedException 
        {  
			    Thread.sleep(3000);
				driver.quit();
        }
		

}
	

