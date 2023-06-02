package PageActions;

import static Utils.WebDriverManager.getDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericActions.GenericPageWaits;
import PageObjects.UserAdminPage;

public class UserAdminPageActions {

	private WebDriver driver;
	UserAdminPage userAdminPage;
	public static String date;
	public static String randomLabel;
	public static String name = "TestAutomation";
	GenericPageWaits pageWaits;
	
	public UserAdminPageActions() {
		this.driver = getDriver();
		userAdminPage = new UserAdminPage();
		LocalDateTime dateToday = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMddyy");
		date = dateToday.format(dateFormat);
		randomLabel = "_"+ date + "_" + userAdminPage.generateRandomInt(0, 10000, 4);
		pageWaits = new GenericPageWaits();
	}
	
	public void clickSaveBtn() {
		userAdminPage.getSaveBtn().click();
	}
	
	public void clickUserAdminBtn() {
		userAdminPage.getUserAdminBtn.click();
	}
	
	public void clickUserAdminSearchBar() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-input[type='search']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		By searchSelector = By.cssSelector("input[type='search']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSelector));
		shadowRoot1.findElement(searchSelector).click();
		Thread.sleep(5000);
	}
	
	public void enterSearchText(String searchText) throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
		WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
		searchBar.sendKeys(searchText + Keys.RETURN);
		
		//Wait for search loader
		By loader = By.xpath("//section//p[text()='Loading']");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		Thread.sleep(3000);
	}
	
	public void clickNewUserBtn() {
		userAdminPage.getNewUserBtn.click();
	}
	
	public void enterFullName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(userAdminPage.getFullNameTxtbox));
		userAdminPage.getFullNameTxtbox.sendKeys(name + randomLabel);
	}
	
	public void enterEmail() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(userAdminPage.getEmailTxtbox));
		userAdminPage.getEmailTxtbox.sendKeys(name + randomLabel + "@email.com");
	}
	
	public void enterJobTitle(String jobtitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(userAdminPage.getJobTitleTxtbox));
		userAdminPage.getJobTitleTxtbox.sendKeys(jobtitle);
	}
	
	public void enterRole(String role) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(userAdminPage.getRoleTxtbox));
		userAdminPage.getRoleTxtbox.sendKeys(role);
	}
	
	public void enterCountryCode(String countrycode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(userAdminPage.getCountryCodeTxtbox));
		userAdminPage.getCountryCodeTxtbox.sendKeys(countrycode);
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(userAdminPage.getPhoneNumberTxtbox));
		userAdminPage.getPhoneNumberTxtbox.sendKeys(phoneNumber);
	}
	
	public void clickContinueBtn() {
		userAdminPage.getContinueBtn().click();
	}
	
	public void tickCheckBox(String checkBoxLabel) {
		WebElement checkbox = driver.findElement(By.xpath("//ps-input[@type='checkbox' and label='"+checkBoxLabel+"']//input"));
		checkbox.click();
	}
	
	public void clickFilterButton() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-button[text='Filter']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		By searchSelector = By.cssSelector("button[part='button']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSelector));
		shadowRoot1.findElement(searchSelector).click();
		Thread.sleep(5000);
	}
	
	public void enterCompanyName(String companyName) throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='text']")));
		WebElement searchBar = driver.findElement(By.cssSelector("input[type='text']"));
		searchBar.sendKeys(companyName);
		searchBar.sendKeys(Keys.ENTER);
	}
		
	public void clickApplyButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-button[text='Apply']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		By searchSelector = By.cssSelector("button[part='button']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSelector));
		
		shadowRoot1.findElement(searchSelector).click();
		Thread.sleep(5000);
	}
	public void clickUser() throws InterruptedException
	{
		userAdminPage.userBtn.click();
		Thread.sleep(1000);
	}
	
	public void enterBranchName(String branchName) throws InterruptedException{
		userAdminPage.branchTxt.sendKeys(branchName);
		Thread.sleep(1000);

	
	}	
	
	public void clickOrgStruc() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-tabs[classes='sticky top-0']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		WebElement element  = shadowRoot1.findElement(By.cssSelector("section"));
		WebElement element1 = element.findElement(By.cssSelector("section > button:nth-child(2)"));
		element1.click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSelector));

	}
	
	public void clickEdgeBtn() throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ps-nbutton/kbd[text()='E']/following-sibling::button")));
		Thread.sleep(1000);
		userAdminPage.edgeBtnUser.click();
	}
	
	public void clickPermissions() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-tabs[classes='sticky top-0']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		WebElement element  = shadowRoot1.findElement(By.cssSelector("section"));
		WebElement element1 = element.findElement(By.cssSelector("section > button:nth-child(4)"));
		element1.click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSelector));		
	}
	
	public void clickWorkSheet() throws InterruptedException{
		userAdminPage.workSheetBtn.click();
		Thread.sleep(2000);
	}
	
	public void enableAccountingGP() throws InterruptedException{
		userAdminPage.AccountGPButton.click();
		Thread.sleep(1000);
	}
	public void enableActualDelivery() throws InterruptedException{
		userAdminPage.ActualDeliveryButton.click();
		Thread.sleep(1000);
	}
	
	public void disableAccountingGP() throws InterruptedException{
		userAdminPage.AccountGPButtonOff.click();
		Thread.sleep(1000);
	}
	public void disableActualDelivery() throws InterruptedException{
		userAdminPage.ActualDeliveryButtonOff.click();
		Thread.sleep(1000);
	}
	
	public void clickBack() throws InterruptedException{
		userAdminPage.BackButton.click();
		Thread.sleep(2000);
	}
	
	public void clickActions() throws InterruptedException{
		userAdminPage.ActionButton.click();
		Thread.sleep(2000);
	}
	
	public void clickresetPermission() throws InterruptedException {
		userAdminPage.resetPermissions.click();
		Thread.sleep(2000);
	}
	public void clickReset() throws InterruptedException {
		userAdminPage.resetBtn.click();
		Thread.sleep(2000);
	}
	
	public void clickAccountant() throws InterruptedException {
		userAdminPage.accountantBtn.click();
		Thread.sleep(2000);
	}
}
