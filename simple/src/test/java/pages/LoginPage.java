package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LoginPage {

	private WebDriver driver;
	
	@FindBy(id="user-name")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(id = "login-button")
    private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@Test
	public void LoginClick(String Username, String Pwd)
	{
		System.out.println("Inside Login method");
		usernameField.sendKeys(Username);
		System.out.println("after Username");
		passwordField.sendKeys(Pwd);
		loginButton.click();
		
		
	}

}
