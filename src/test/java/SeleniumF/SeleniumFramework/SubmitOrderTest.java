package SeleniumF.SeleniumFramework;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import InitialConfigurationCode.BaseTest;
import SeleniumF.pageobjects.CartPage;
import SeleniumF.pageobjects.CheckOutPage;
import SeleniumF.pageobjects.ConfirmationPage;
import SeleniumF.pageobjects.LoginPage;
import SeleniumF.pageobjects.Order;
import SeleniumF.pageobjects.ProductCatalog;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{
	String productName= "Laptop";
	@Test(dataProvider = "getData")
	public void submitOrder(String email, String pwrd, String item) throws IOException, InterruptedException
	{
		
		String ExpMsg = "THANKYOU FOR THE ORDER.";
	
	ProductCatalog productcatalog= page.loginapp(email, pwrd);
	 List<WebElement> products= productcatalog.getProductList();
     productcatalog.addProductToCart(item);
   CartPage cartpage =  productcatalog.goToCartPage();
    Boolean match =  cartpage.VerifyProductDisplay(item);
    Assert.assertTrue(match);
    CheckOutPage checkoutpage = cartpage.goToCheckout();
   ConfirmationPage confirmationpage =  checkoutpage.SelectOption(); 
      String actualmsg =  confirmationpage.getConfirmationMsg();
      System.out.println(actualmsg);
   Assert.assertEquals(actualmsg, ExpMsg);
}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"sharmajagruti@gmail.com", "J@123456$j", "Laptop"}};
	}
	

}
