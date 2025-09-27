package SeleniumF.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	WebDriver driver;
	
@FindBy(tagName ="h1")
WebElement msg;
	
	ConfirmationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getConfirmationMsg() throws InterruptedException
	{
		Thread.sleep(5000);
	String actualmsg = 	msg.getText();
		return actualmsg;
		//String TYmsg = driver.findElement(By.tagName("h1")).getText();
		 
	}
	
	
}

