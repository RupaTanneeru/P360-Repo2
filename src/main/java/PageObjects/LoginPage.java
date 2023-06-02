package PageObjects;

import static Utils.WebDriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utils.FileReaderManager;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(){
		driver = getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='Username']")
	public WebElement getEmailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	public WebElement getPasswordTextbox;

	@FindBy(xpath = "//*[text()='Sign in']/parent::button")
	public WebElement getSignInBtn;

	@FindBy(xpath = "//*[text()='Continue']/parent::button")
	public WebElement getContinueBtn;
	
	@FindBy(tagName = "li")
	public WebElement errorMsg;

	@FindBy(css = "ps-button[icon='user']")
	public WebElement shadowHost;

	@FindBy(tagName = "h1")
	public WebElement SignInText;
	
	
	public static ExtentReports getExtent() {
		String path = System.getProperty("user.dir")+ "\\reports\\reports.html";
		ExtentSparkReporter reporter= new  ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Pentana360 Automation");
		reporter.config().setTheme(Theme.DARK);
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Icon Vergara");
		return extent;
	}
}

