package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigFileReader {

	Properties  properties;
	String filepath = "config/Configuration.properties";
	public ConfigFileReader()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Configuration file not found"+filepath);
		}
	}
	
	public DriverType getBrowser()
	{
		String browser = properties.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome")) return DriverType.CHROME;
		else if(browser.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browser.equalsIgnoreCase("edge")) return DriverType.EDGE;
		else if(browser.equalsIgnoreCase("internetexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser not specicified in Configuration.properties file.");
	}
	
	public long getImplicitWait()
	{
		String ImplicitWait = properties.getProperty("ImplicitWait");
		if(ImplicitWait!= null) return Long.parseLong(ImplicitWait);
		else throw new RuntimeException("Implicit  Wait not specified in Configuration.properties file");
	}
	
	public String getURL()
	{
		String URL = properties.getProperty("URL");
		if(URL!= null) return URL;
		else throw new RuntimeException("URL not specified in Configuration.properties file");
	}
	
	public String getChromeDriverName() {
		String chromeDriverName = properties.getProperty("ChromeDriverName");
		if(chromeDriverName!= null) return chromeDriverName;
		else throw new RuntimeException("Chrome Driver Name not specified in Configuration.properties file");
	}
	
	public String getFirefoxDriverName() {
		String firefoxDriverName = properties.getProperty("FirefoxDriverName");
		if(firefoxDriverName!= null) return firefoxDriverName;
		else throw new RuntimeException("Firefox Driver Name not specified in Configuration.properties file");
	}
	
	public String getDriverDirectory() {
		String driverDirectory = properties.getProperty("DriverDirectory");
		if(driverDirectory!= null) return driverDirectory;
		else throw new RuntimeException("Driver Directory not specified in Configuration.properties file");
	}
	
	public String getHeadless() {
		String isHeadless = properties.getProperty("Headless");
		if(isHeadless!= null) return isHeadless;
		else throw new RuntimeException("Headless setting not specified in Configuration.properties file");
	}
}
