package Utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverManager {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	public static DriverType driverType;

	public static WebDriver getDriver() {
		if(webDriver.get() == null) {
			webDriver.set(createDriver());
		}
		return webDriver.get();
	}

	private static WebDriver createDriver() {
		WebDriver driver = null;
//		String driverDirectory = FileReaderManager.getInstance().getConfigReader().getDriverDirectory();
		
		switch (getDriverType()) {
		case FIREFOX:
//			String firefoxDriverName = FileReaderManager.getInstance().getConfigReader().getFirefoxDriverName();
//			System.setProperty("webdriver.gecko.driver",driverDirectory + firefoxDriverName);
//			System.setProperty("webdriver.gecko.driver","C:\\selenium-drivers\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			firefoxOptions.addArguments("start-maximized");
			driver = new FirefoxDriver();
			break;
			
		case CHROME:
//			String chromeDriverName = FileReaderManager.getInstance().getConfigReader().getChromeDriverName();
//			System.setProperty("webdriver.chrome.driver", driverDirectory + chromeDriverName);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			chromeOptions.addArguments("--remote-allow-origins=*","start-maximized");
			
			if(FileReaderManager.getInstance().getConfigReader().getHeadless().equals("true")) {
				chromeOptions.addArguments("--headless=new");
			}
			
			driver = new ChromeDriver(chromeOptions);
			break;
			
		case EDGE:
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			edgeOptions.addArguments("start-maximized");
			driver = new EdgeDriver();
			
		default:
			break;
		}
		 
		return driver;
	}

	public static void closeDriver() {
		webDriver.get().quit();
		webDriver.remove();
	}
	
	private static DriverType getDriverType() {
		DriverType driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		return driverType;
	}
}
