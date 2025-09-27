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

public class SubmitOrderTest2 extends BaseTest{
	String productName= "Laptop";
	String ExpMsg = "THANKYOU FOR THE ORDER.";
	@Test(dataProvider = "getData")
	public void submitOrder(String email, String pwrd, String productname) throws IOException, InterruptedException
	{
	
	//Login
	ProductCatalog productcatalog= page.loginapp(email, pwrd);
	//Product Catalog
	 List<WebElement> products= productcatalog.getProductList();
     productcatalog.addProductToCart(productname);
     //Cart Page
   CartPage cartpage =  productcatalog.goToCartPage();
    Boolean match =  cartpage.VerifyProductDisplay(productname);
    Assert.assertTrue(match);
    CheckOutPage checkoutpage = cartpage.goToCheckout();
    //Checkout page
    ConfirmationPage confirmationpage =  checkoutpage.SelectOption();
    //Confirmation page
	 String actualmsg =  confirmationpage.getConfirmationMsg();
      System.out.println(actualmsg);
   Assert.assertEquals(actualmsg, ExpMsg);
}
	@Test(dependsOnMethods={"submitOrder"})
	public void CheckOrder() throws InterruptedException
	{
		ProductCatalog productcatalog= page.loginapp("sharmajagruti@gmail.com", "J@123456$j");
		Order orderpage	= productcatalog.OrderButton();
		Boolean match= orderpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"sharmajagruti@gmail.com", "J@123456$j", "Laptop"}};
	}
}
