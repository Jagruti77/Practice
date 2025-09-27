package SeleniumF.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class Order extends AbstractComponent {
	WebDriver driver;
	public Order(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= ("//tr/td[2]"))
	List<WebElement> orderitems;
	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = orderitems.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

}
}
