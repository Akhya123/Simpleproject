package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LastPage {
	
private WebDriver driver;
	
	@FindBy(id="finish")
	private WebElement finish;
	@FindBy(tagName="h2")
	private WebElement validation;
	
	
	
	public LastPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
   @Test
   public void ClickFinish() {
	
	finish.click();
}
   
   @Test
   public String returnString() {
	   
	   return validation.getText();
   }
	
	
	

}
