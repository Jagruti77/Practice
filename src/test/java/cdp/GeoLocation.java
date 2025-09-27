package cdp;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.emulation.Emulation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();// here used ChrDriver as webdriver can't exposed cdp related methods and implementations
		
		DevTools devtools = driver.getDevTools();//create object of DevTools by using Driver.getDevtools class
		
		devtools.createSession();
		
		devtools.send(Emulation.setGeolocationOverride(
                Optional.of(17.0),  // latitude
                Optional.of(78.0),  // longitude
                Optional.of(1.0)    // accuracy
, Optional.empty(),Optional.empty(),Optional.empty(), Optional.empty()
        ));

	driver.get("https://www.google.com");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(140));
 System.out.println("ster");
	//It will load webpages in spainish language as those coordinates rae given
		
		
	}
}
