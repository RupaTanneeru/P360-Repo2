package PageObjects;

import static Utils.WebDriverManager.getDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserAdminPage {
	private WebDriver driver;
	
	public UserAdminPage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='User Administration']/parent::a")
	public WebElement getUserAdminBtn;
	
	@FindBy(xpath = "//span[text()='New user']/parent::button")
	public WebElement getNewUserBtn;
	
	//Users creation page
	@FindBy(xpath = "//label[text()='Full name']/following-sibling::input")
	public WebElement getFullNameTxtbox;
	
	@FindBy(xpath = "//label[text()='Email']/following-sibling::input")
	public WebElement getEmailTxtbox;
	
	@FindBy(xpath = "//label[text()='Job title']/following-sibling::input")
	public WebElement getJobTitleTxtbox;
	
	@FindBy(xpath = "//label[text()='Role']/following-sibling::input")
	public WebElement getRoleTxtbox;
	
	@FindBy(xpath = "//label[text()='Country code']/following-sibling::input")
	public WebElement getCountryCodeTxtbox;
	
	@FindBy(xpath = "//label[text()='Phone number']/following-sibling::input")
	public WebElement getPhoneNumberTxtbox;
	
	@FindBy(xpath = "//*[@id=\"a86a62ac2_a8c950401_content\"]")
	public WebElement orgStructab;
	
	@FindBy(xpath = "//input[@slot='input' and @id='abf74b48a_in']")
	public WebElement companyTxt;
	
	@FindBy(xpath = "//label[text()='Branch']/following-sibling::input")
	public WebElement branchTxt;
	
	@FindBy(xpath = "//button[@id='6c9bd018-e0ce-4f66-99c2-00cad3a5e67a']")
	public WebElement userBtn;
	
	@FindBy(xpath = "//div/ol/li/p")
	public WebElement getCompanyTxt;
	
	@FindBy(xpath = "//p/parent::li/ol/li/p")
	public WebElement getBranchTxt;
	
	@FindBy(xpath = "//div/ps-nbutton/kbd[text()='E']/following-sibling::button")
	public  WebElement edgeBtnUser;
	
	@FindBy(xpath = "//ol/li/button")
	public  WebElement workSheetBtn;
	
	@FindBy(xpath = "//ps-input[@name='accountingGrossProfit' and @label='View']")
	public  WebElement AccountGPButton;
	
	@FindBy(xpath = "//ps-input[@name='actualDeliveryDate' and @label='View']")
	public  WebElement ActualDeliveryButton;
	
	@FindBy(xpath = "//div/ps-button[@icon='arrow_left']")
	public  WebElement BackButton;
	
	@FindBy(xpath = "//div/ps-button/following-sibling::ps-button[@contextmenu='actionsPermissions']")
	public  WebElement ActionButton;
	
	@FindBy(xpath = "//ps-input[@name='accountingGrossProfit' and @label='Off']")
	public  WebElement getAccountGPButtonStatus;
	

	@FindBy(xpath = "//ps-input[@name='actualDeliveryDate' and @label='Off']")
	public  WebElement getActualDeliveryDateStatus;

	@FindBy(xpath = "//ol/li//ps-input[@label='Accountant']")
	public  WebElement accountantBtn;
	

	@FindBy(xpath = "//*[@id=\"actionsPermissions\"]/ps-contextmenuitem[3]")
	public  WebElement resetPermissions;
	
	@FindBy(xpath = "//dialog/footer/ps-button[@text='Reset']")
	public  WebElement resetBtn;
	
	@FindBy(xpath = "//ps-input[@name='accountingGrossProfit' and @label='View']")
	public  WebElement AccountGPButtonOff;
	
	@FindBy(xpath = "//ps-input[@name='actualDeliveryDate' and @label='View']")
	public  WebElement ActualDeliveryButtonOff;
	
	
	
	
	
	
	public WebElement getContinueBtn() {
		WebElement shadowHost = driver.findElement(By.cssSelector("ps-button[text = 'Continue']"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		return shadowRoot.findElement(By.cssSelector("button"));
	}
	
	public WebElement getSaveBtn() {
		WebElement shadowHost = driver.findElement(By.cssSelector("ps-button[text = 'Save']"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		return shadowRoot.findElement(By.cssSelector("button"));
	}
	
	public String generateRandomInt(int min, int max, int length) {
		int number = (int)(Math.random()*(max-min+1)+min);
		String random = String.format("%0" + length +"d", number);
		return random;
	}
}
