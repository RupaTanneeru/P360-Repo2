package PageObjects;

import static Utils.WebDriverManager.getDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SalesActivityPage {
	private WebDriver driver;
	
	public SalesActivityPage(){
		driver = getDriver();
		PageFactory.initElements(driver, this);
	}
}
