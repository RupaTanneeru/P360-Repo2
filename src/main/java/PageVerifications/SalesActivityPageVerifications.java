package PageVerifications;


import static Utils.WebDriverManager.getDriver;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.LoginPage;

public class SalesActivityPageVerifications {
	private WebDriver driver;
	LoginPage loginPage;
	
	
	public SalesActivityPageVerifications() {
		driver = getDriver();
		loginPage = new LoginPage();
	}
	
	public void verifyTextOnSALPage()throws InterruptedException
	{ 
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-header[text='Sales Activity Log']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		By searchSelector = By.cssSelector("ps-header[text='Sales Activity Log']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSelector));
		String text = shadowRoot1.findElement(By.cssSelector("h1")).getText();
		Assert.assertEquals(text,"Sales Activity Log");
	}
	
}
