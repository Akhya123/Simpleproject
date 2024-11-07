package configuration;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	public ConfigReader() {
		
		prop = new Properties();
		try {
		FileInputStream input = new FileInputStream("C:\\Users\\AKHYAK\\eclipse-workspace\\simple\\src\\test\\resources\\config.properties");
		prop.load(input);
		
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	}
		
		
		public String getprop(String key)
		{
			
			return prop.getProperty(key);
		}
		
		
		
		
		
	}


