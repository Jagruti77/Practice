package cdp;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.fetch.Fetch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkInterceptURLMocking {

	 @SuppressWarnings("deprecation")
	public static void main(String[] args) {
	 WebDriverManager.chromedriver().setup();
     ChromeDriver driver = new ChromeDriver();

     // Create DevTools session
     DevTools devTools = driver.getDevTools();
     devTools.createSession();
     devTools.send(Fetch.enable(Optional.empty(), Optional.empty())); //Fetch domain is used
     devTools.addListener(Fetch.requestPaused(), request -> //lambda expression is used
     {
    	 
    	 if(request.getRequest().getUrl().contains("=shetty"))
    	 {
    	String MockedURL= request.getRequest().getUrl().replace("=shetty", "=BadGuy");
    	   System.out.println(MockedURL); //we got the URL and send the mocked URL now
    	   
    	   devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(MockedURL),Optional.of(request.getRequest().getMethod()),
    			   request.getRequest().getPostData(), request.getResponseHeaders(), java.util.Optional.empty()));
    	 }
    		
    	 else
    	 {
    		 devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(),Optional.empty(),Optional.empty(), Optional.empty(),
    				 Optional.empty()));
    	 }
    	   });
     driver.get("https://rahulshettyacademy.com/angularAppdemo/");
     driver.findElement(By.className("btn-primary")).click();
	 }
}
