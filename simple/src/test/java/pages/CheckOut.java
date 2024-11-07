package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class CheckOut {
	
	private WebDriver driver;
	
	@FindBy(id="checkout")
	private WebElement checkout;
	
	public CheckOut(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void ClickCheckout()
	{
		checkout.click();
	}
	
	

}
