package SeleniumF.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcomponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
      WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
	    this.driver = driver;
	   PageFactory.initElements(driver, this);
	}

	
	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(xpath = "//button/span")
	List<WebElement> ReqOption;

	@FindBy(css = ".action__submit")
	WebElement submitbtn;

	public ConfirmationPage SelectOption()
	{
	Country.sendKeys("Ind");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfAllElements(ReqOption));

	 for(WebElement element: ReqOption)
	 {
		 if(element.getText().equalsIgnoreCase("India"))
		 {
		 element.click();
			 break;
}
	 }
	 submitbtn.click();
	 ConfirmationPage confirmationpage= new ConfirmationPage(driver);
	return confirmationpage;
	}
}
	
		 
	 

	