package SeleniumF.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportValidation {

	ExtentSparkReporter spark;
	@BeforeTest
	public static ExtentReports getconfig()
	{
		//specify the path for report 
		String path = System.getProperty("user.dir") + "\\reports\\index.html"; //it will specify path until project level - user.dir
	     ExtentSparkReporter reporter = new ExtentSparkReporter(path); //once path of report is set, give report name , document title and other config
	     reporter.config().setReportName("Automation results");
	     reporter.config().setDocumentTitle("UI Automation Results");
	     //Attach reporter to extent reports -> set inside report details by setSusteminfo
	     ExtentReports  extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester", "Jagruti");
	     return extent;
	} 
	
	
	//example of report generation
	//@Test
/*	public void sample()
	{
		   ExtentTest test= extent.createTest("Initial demo"); //whenever we create test, it creates new object so we are defifning here ExtentTest test 
		            WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.getTitle();
		 extent.flush();
		 System.out.println("hello");
	}*/
	     
}
