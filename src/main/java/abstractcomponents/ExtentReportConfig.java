package abstractcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportConfig {

	static ExtentReports extent;
	ExtentSparkReporter spark;
	public static ExtentReports config()
	{
		//specify the path for report 
		String path = System.getProperty("user.dir") + "\\reports\\index.html"; //it will specify path until project level - user.dir
	     ExtentSparkReporter reporter = new ExtentSparkReporter(path); //once path of report is set, give report name , document title and other config
	     reporter.config().setReportName("Automation results");
	     reporter.config().setDocumentTitle("UI Automation Results");
	     //Attach reporter to extent reports -> set inside report details by setSusteminfo
	     extent = new ExtentReports();
	     extent.attachReporter(reporter);
	     extent.setSystemInfo("Tester", "Jagruti");
	     return extent;   //return extent and pass it to Listener
	} 
	
}
