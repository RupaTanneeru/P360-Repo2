package PageObjects;

import static Utils.WebDriverManager.getDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppsDashboardPage {
	private WebDriver driver;
	
	public AppsDashboardPage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/app-root/layout-outer/appbar-outer/ps-appbar/ps-button")
	public WebElement menuBtn;
	
	@FindBy(xpath = "/html/body/app-root/layout-outer/div/app-drawer/ps-appdrawer/ps-navmenu/ps-navmenuitem")
	public WebElement appBtn;
	
	@FindBy(xpath = "//p[text()='Sales Activity Log']/parent::a")
	public WebElement salBtn;
	
	@FindBy(xpath = "/html/body/app-root/layout-outer/appbar-outer/ps-appbar/div/ps-button[1]")
	public WebElement edgeBtn;
	
	
}
