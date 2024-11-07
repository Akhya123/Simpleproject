package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Screenshot {
	
	private WebDriver driver;
	
	public Screenshot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String TakeSS(String screenshotName) throws IOException
	{
		TakesScreenshot s = (TakesScreenshot)driver;
		File source =s.getScreenshotAs(OutputType.FILE);
		String destination=	System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
		//C:\Users\AKHYAK\eclipse-workspace\simple\target\Screens
		
		 File finalDestination = new File(destination);
		 FileUtils.copyFile(source, finalDestination);
		 return destination;
		 
	}
	
	
		 
		 
		
		
	
}
