package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import InitialConfigurationCode.BaseTest;
import SeleniumF.pageobjects.CartPage;
import SeleniumF.pageobjects.CheckOutPage;
import SeleniumF.pageobjects.ConfirmationPage;
import SeleniumF.pageobjects.LoginPage;
import SeleniumF.pageobjects.ProductCatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimpl extends BaseTest{
	LoginPage page;
	ProductCatalog productcatalog;
	ConfirmationPage confirmationpage;
@Given("I have landed on login page")
public void I_have_landed_on_login_page() throws IOException
{
 page = LaunchApp();
}

@Given("^I have logged with (.+) and (.+)$")
public void Login_with_username_and_password(String username, String password)
{
 productcatalog= page.loginapp(username, password);
}

@When("^I add product (.+) to cart$")
public void add_product_to_cart(String productname) throws InterruptedException
{
	List<WebElement> products= productcatalog.getProductList();
    productcatalog.addProductToCart(productname);
}

@And("^I Checkout (.+) and submit the order$")
public void I_check_out_product_and_submit_order(String productname)
{
	CartPage cartpage =  productcatalog.goToCartPage();
    Boolean match =  cartpage.VerifyProductDisplay(productname);
    Assert.assertTrue(match);
    CheckOutPage checkoutpage = cartpage.goToCheckout();
   confirmationpage =  checkoutpage.SelectOption(); 
}

@Then("{string} msg should be displayed on Confirmation page")
public void msg_should_be_displayed(String msg) throws InterruptedException
{
	String actualmsg =  confirmationpage.getConfirmationMsg();
    System.out.println(actualmsg);
     Assert.assertEquals(actualmsg, msg);
}


}
