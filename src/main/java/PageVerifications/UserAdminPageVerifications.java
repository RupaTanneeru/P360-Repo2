package PageVerifications;

import static Utils.WebDriverManager.getDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import GenericActions.GenericPageWaits;
import PageActions.UserAdminPageActions;
import PageObjects.UserAdminPage;

public class UserAdminPageVerifications {
	private WebDriver driver;
	UserAdminPage userAdminPage;
	UserAdminPageActions userAdminPageActions;
	GenericPageWaits pageWaits;
	
	public UserAdminPageVerifications() {
		this.driver = getDriver();
		userAdminPage = new UserAdminPage();
		userAdminPageActions = new UserAdminPageActions();
		pageWaits = new GenericPageWaits();
	}
	
	public void verifyUserAdminBtnVisibility(Boolean expectedVisibility) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(userAdminPage.getUserAdminBtn));
		Boolean actualVisibility;
		actualVisibility = userAdminPage.getUserAdminBtn.isDisplayed();
		Assert.assertEquals(actualVisibility, expectedVisibility);
	}
	
	public void verifyUserAdminTabTitle() throws InterruptedException {
		/*There are two expected titles because the title changes when the page fully loads, but we don't know when that will be
		* so we just check either one of these titles are displayed for the verification to pass
		* This is just a temporary solution
		*/
		Thread.sleep(5000);
		String expectedTitle1 = "Users";
		String expectedTitle2 = "UserAdministration";
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	    driver.close();
	    driver.switchTo().window(tabs.get(1));
		String actualTitle = driver.getTitle();
		boolean isPass = false;
		if(actualTitle.equals(expectedTitle1) || actualTitle.equals(expectedTitle2)) {
			isPass=true;
		}else {
			isPass=false;
		}
		
		Assert.assertEquals(isPass, true);
	}
	
	public void verifySearchResultNameExists(String expectedTextName) throws InterruptedException {
		//Check if the name that you are looking for exist in the result, using a particular search criteria
		
		List<WebElement> results = driver.findElements(By.xpath("(//li//p[@class='break-all whitespace-normal'])"));
		for(int i=0; i<results.size(); i++) {
			if(results.get(i).getText().contains(expectedTextName)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", results.get(i));
				Thread.sleep(500); 
				Assert.assertTrue(results.get(i).getText().contains(expectedTextName));
				break;
			}
			
			if(i==results.size()-1) {
				Assert.fail("User not found");
			}
		}
	}
	
	public void verifySearchResultNameNotExists(String expectedTextName) throws InterruptedException {
		//Check if the name that you are looking for exist in the result, using a particular search criteria
		//Expected result: user should not be found
		
		List<WebElement> results = driver.findElements(By.xpath("(//li//p[@class='break-all whitespace-normal'])"));
		for(int i=0; i<results.size(); i++) {
			if(results.get(i).getText().contains(expectedTextName)) {
				System.out.println("User found at " + i);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", results.get(i));
				Thread.sleep(500); 
				Assert.fail("User found");
				break;
			}
		}
	}
	
	public void verifyUserIsInNewUserPage() {
		String expectedTitle = "New user";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void verifyUserIsCreated() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By notification = By.cssSelector("ps-notification[text='"+userAdminPageActions.name+ userAdminPageActions.randomLabel+" has been created.']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(notification));
		WebElement notificationElem = driver.findElement(notification);
		Assert.assertTrue(notificationElem.isDisplayed());
	}
	
	public void verifyUserCreationSelectCompaniesAndBranches() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By header = By.xpath("//h1[text()='Select companies and branches']");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(header));
		WebElement headerElem = driver.findElement(header);
		Assert.assertTrue(headerElem.isDisplayed());
	}
	
	public void verifyCompanyName(String expectedCompanyName) throws InterruptedException 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(userAdminPage.getCompanyTxt));
		String searchBarTxt = userAdminPage.getCompanyTxt.getText();
		Assert.assertEquals(searchBarTxt.toLowerCase(),expectedCompanyName.toLowerCase());
	}	
	
	public void verifyBranchName(String expectedBranchName) throws InterruptedException 
	{
		pageWaits.waitElementVisible(userAdminPage.getBranchTxt);
		String searchBarTxt = userAdminPage.getBranchTxt.getText();
		Assert.assertEquals(searchBarTxt.toLowerCase(),expectedBranchName.toLowerCase());
	}
	
	public void verifyEdgeLinkUser()throws InterruptedException{
		driver.close();
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://pentanaelearning.mygo1.com/login" );	
	}
	public void verifyPermissionPage() throws InterruptedException 
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Permissions']")));
		WebElement searchBar = driver.findElement(By.xpath("//h2[text()='Permissions']"));
//		String text = searchBar.getText();
		Assert.assertTrue(searchBar.isDisplayed());

	}
	public void verifyAccountGPButtonStatus() throws InterruptedException {
	userAdminPage.getAccountGPButtonStatus.getAttribute("checked");
	Thread.sleep(2000);
	}
	
	public void verifyActualDeliveryDateStatus() throws InterruptedException {
	userAdminPage.getActualDeliveryDateStatus.getAttribute("checked");
	Thread.sleep(2000);
	}
}
