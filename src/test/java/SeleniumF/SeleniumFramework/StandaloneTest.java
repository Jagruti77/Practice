package SeleniumF.SeleniumFramework;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumF.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) {
		String str= "IPHONE 13 PRO";
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	LoginPage page = new LoginPage(driver);//pass driver to page object class
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.get("https://rahulshettyacademy.com/client/");
	driver.findElement(By.id("userEmail")).sendKeys("sharmajagruti@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("J@123456$j");
	driver.findElement(By.name("login")).click();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	//get all products

//iterate over elements
/*	List<WebElement> elements= driver.findElements(By.cssSelector("div.col-lg-4 b"));
for(int i = 0; i< elements.size();i++)
{
    String productname = elements.get(i).getText();	
	if(productname.equals("ADIDAS ORIGINAL"))
	{
		driver.findElements(By.cssSelector("button.btn.w-10.rounded")).get(i).click();
		System.out.println(productname);
	}	
	
}*/
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(".mb-3")));
List<WebElement> elements2= driver.findElements(By.cssSelector("div.col-lg-4"));
WebElement product = elements2.stream().filter(s -> s.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findAny().orElse(null);

	product.findElement(By.cssSelector("button.w-10")).click();
	
//wait for product added successfully
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	
	wait1.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//Click on add to cart
	driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	
	//Check items present in Cart is correct 
	List<WebElement> atcproduct = driver.findElements(By.cssSelector(".cartWrap"));

	
Boolean string2 = atcproduct.stream().anyMatch(s-> s.findElement(By.cssSelector("h3")).getText().equals(str));
 
	Assert.assertTrue(string2);
	
	//click on checkout
	driver.findElement(By.xpath("//li[@class ='totalRow']/button")).click();
	
	//
	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
	
	List<WebElement> options = driver.findElements(By.xpath("//button/span"));
 for(WebElement element: options)
 {
	 if(element.getText().equals("India"))
			 {
		 
		 element.click();
		 break;
			 }
 }
 
 driver.findElement(By.cssSelector(".action__submit")).click();
 String TYmsg = driver.findElement(By.tagName("h1")).getText();
 
Assert.assertEquals(TYmsg, "THANKYOU FOR THE ORDER.");
	}



	
	

	

}


