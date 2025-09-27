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

import SeleniumF.pageobjects.CartPage;
import SeleniumF.pageobjects.LoginPage;
import SeleniumF.pageobjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		String productName= "IPHONE 13 PRO";
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	LoginPage page = new LoginPage(driver);//pass driver to page object class
	page.goTo();
	page.loginapp("sharmajagruti@gmail.com" , "J@123456$j");
	
	ProductCatalog productcatalog = new ProductCatalog(driver);
    List<WebElement> products= productcatalog.getProductList();
     productcatalog.addProductToCart(productName);
     productcatalog.goToCartPage();

   
   
   
}
}

