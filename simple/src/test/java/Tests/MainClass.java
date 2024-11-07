package Tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddToCartPage;
import pages.CheckOut;
import pages.LastPage;
import pages.LoginPage;
import pages.PersonalInfo;
import utilities.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import configuration.ConfigReader;



public class MainClass {

	private WebDriver driver;
	ExcelUtil excel ;
	Screenshot screenshot;
	
	@BeforeClass
	public void setUp() {
		
		ConfigReader CR=new ConfigReader();
		String Bname =CR.getprop("browser");
		System.out.println(Bname);
	if(Bname.equalsIgnoreCase("chrome")) {
			
			
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				
				System.out.println("inside chrome");
				System.out.println("inside chrome1");
				
				
		
			
		}
		
		else {
			
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(CR.getprop("app"));
		//WebDriverManager.chromedriver().setup();
     	//WebDriver driver= new ChromeDriver();
		//driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		excel = new ExcelUtil();
		screenshot = new Screenshot(driver);
			
	}
	
	
	@Test
	public void login() throws Exception {
	LoginPage loginpage=new LoginPage(driver);
//	Map<String,String> mapExcel = excel.getData(1);
//	String user = mapExcel.get("User");
//	String pwd = mapExcel.get("pwd");
	loginpage.LoginClick("standard_user","secret_sauce");
	screenshot.TakeSS("LoginPage");
	//loginpage.LoginClick(user,pwd);
	
	}
	
	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) throws Exception {
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			screenshot.TakeSS(result.getName());
		}
	}
	
	@Test
	public void EndofthePage() throws Exception {
		
		AddToCartPage addtocart=new AddToCartPage(driver);
		addtocart.clickbutton2();
		CheckOut chk = new CheckOut(driver);
		chk.ClickCheckout();
		PersonalInfo pi = new PersonalInfo(driver);
		Map<String,String> mapExcel =excel.getData(1);
		String fname = mapExcel.get("Firstname");
		String lname = mapExcel.get("Lastname");
		String pc = mapExcel.get("PostalCode");
		
		pi.sendDetails(fname, lname, pc);
		LastPage lp= new LastPage(driver);
		lp.ClickFinish();
		System.out.println(lp.returnString());
		
	}
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			// Locate and enter username
//	            WebElement usernameField = driver.findElement(By.id("user-name"));
//	            usernameField.sendKeys("standard_user");
//	         // Locate and enter password
//	            WebElement passwordField = driver.findElement(By.id("password"));
//	            passwordField.sendKeys("secret_sauce");
//	         // Locate the login button and click
//	            WebElement loginButton = driver.findElement(By.id("login-button"));
//	            loginButton.click();
	            
	            //page 2
//	            WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
//	            addToCart.click();
//	            WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
//	            cartLink.click();
	            
	            //page3
//	            WebElement checkout = driver.findElement(By.id("checkout"));
//	            checkout.click();
//	            
	            //page4
//	            WebElement firstNmae = driver.findElement(By.id("first-name"));
//	            firstNmae.sendKeys("Akhya");
//	            WebElement lastName = driver.findElement(By.id("last-name"));
//	            lastName.sendKeys("Akhya");
//	            WebElement PostalCode = driver.findElement(By.id("postal-code"));
//	            PostalCode.sendKeys("560098");
//	            WebElement checkout1 = driver.findElement(By.id("continue"));
//	            checkout1.click();
//	            Thread.sleep(3000);
	            
	            //page 5
	            
	          //div[contains(text(),'Sauce Labs Backpack')]
//	            
//	            Assert.assertEquals((driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText()), "Sauce Labs Backpack");
//	            WebElement finish = driver.findElement(By.id("finish"));
//	            finish.click();
//	            
//	            //page 6
//	            System.out.println(driver.findElement(By.tagName("h2")).getText());	 
//	          //  System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText());	 
//	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
			
			
		
		@AfterClass
		public void Teardown(){
			 if (driver != null) {
			driver.quit();
			 }
			
		}
			
			
		}
		
		
		

	


