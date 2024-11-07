package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
public class PersonalInfo {
	
	private WebDriver driver;
	
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement PostalCode1;
	
	@FindBy(id="continue")
	private WebElement checkout2;
	
	public PersonalInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void sendDetails(String fname,String lname, String PC) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		PostalCode1.sendKeys(PC);
		checkout2.click();
		
	}
	
	
	
	
	
	 
	
	

}
