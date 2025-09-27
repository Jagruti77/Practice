package SeleniumF.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	 //Globally -> WebDriver Driver 
	WebDriver driver;
	
	//Constructor(WebDriver driver)
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
      //WebElements
	@FindBy(id = "userEmail")                 //driver.findElement(By.id("userEmail")).sendKeys("sharmajagruti@gmail.com");
	 WebElement Email;
	
	@FindBy(id = "userPassword")   //driver.findElement(By.id("userPassword")).sendKeys("J@123456$j");
	WebElement PasswordEle;
	
	@FindBy(id = "login")   
	WebElement Login;
	
	@FindBy(css = "div[class*='flyInOut']")
	WebElement error;
	
	//ActionMethod 
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductCatalog loginapp(String email, String paswrd)
	{
		Email.sendKeys(email);
		PasswordEle.sendKeys(paswrd);
		Login.click();
		ProductCatalog productcatalog = new ProductCatalog(driver);
		return productcatalog;
	}
	
	public String ErrorMsg()
	{
		
     waitForElementToAppear(error);
     return error.getText(); 
 	 
	}
}
