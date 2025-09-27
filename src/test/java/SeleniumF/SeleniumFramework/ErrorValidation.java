package SeleniumF.SeleniumFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import InitialConfigurationCode.BaseTest;
import InitialConfigurationCode.Retry;
import SeleniumF.pageobjects.ProductCatalog;


public class ErrorValidation extends BaseTest {
	@Test
	public void ErrorValidationtest() throws InterruptedException
	{
	ProductCatalog productcatalog= page.loginapp("sharmajagruti@gmail.com", "J@123456$j");
	        Thread.sleep(3000);
	       String msg = page.ErrorMsg();
	       
	       Assert.assertEquals(msg, "Incorrect email or password.");
	
	
}
}
