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
import org.testng.Assert;

import abstractcomponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	//Get all products
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products; //return products list
	}
	
	//Get product by name
	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductList().stream().filter(product-> //Call above method to get product list and store in list and apply for loop
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;//return product
	}
	
	//Add product to cart
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);//call above method to get product by name
		prod.findElement(addToCart).click();//click on add to cart button
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	   
	}
	
	
	
	
	

}
