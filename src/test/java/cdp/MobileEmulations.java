package cdp;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileEmulations {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();// here used ChrDriver as webdriver can't exposed cdp related methods and implementations
		
		DevTools devtools = driver.getDevTools();//create object of DevTools by using Driver.getDevtools class
		
		devtools.createSession();
		devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
	}
}
