package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddToCartPage {
	
	private WebDriver driver;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement addToCart;
	
	@FindBy(className ="shopping_cart_link")
	private WebElement cartLink;
	

	public AddToCartPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@Test
	public void clickbutton1() {
		
		addToCart.click();
		System.out.println("inside click1");
		
	}
	
	@Test
	public void clickbutton2() {
		
		cartLink.click();
		System.out.println("inside click2");
	}
	
	
	

}
