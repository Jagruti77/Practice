package InitialConfigurationCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import SeleniumF.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LoginPage page;
 //Properties class 
	public void callDriver() throws IOException
	{	
	Properties prop = new Properties();
	FileInputStream FIS = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\abstractcomponents\\Global.properties");
	prop.load(FIS); //here it takes Input stream so we need to convert file to input stream 
	String browsername = prop.getProperty("broswer");
	
	
	//String browsername1 = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("broswer");
	if(browsername.contains("chrome"))
	{
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
	//	if(browsername.contains("headless"))
	//	{
	//		options.addArguments("headless");
	//	}
		
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		
	}
	else if(browsername.equals("firefox"))
	{
	 driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage LaunchApp() throws IOException
	{
		
		callDriver();
	     page = new LoginPage(driver);
		page.goTo();
		return page;
	}

   @AfterMethod(alwaysRun = true)
    public void closeBrowser()
{
driver.close();
}

 //get screenshot on failure
 	public String getScreenshotonFailure(String testCaseName, WebDriver driver) throws IOException
 	{
 		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png"; //path to store SS
        File dest = new File(path);
        FileHandler.copy(src, dest);
        return path;
 	}

}

/*WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();*/


//LoginPage page = new LoginPage(driver);//pass driver to page object class
//page.goTo();
  