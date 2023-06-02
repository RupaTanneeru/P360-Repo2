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

import PageObjects.AppsDashboardPage;

public class AppsDashboardPageVerifications {
	private WebDriver driver;
	AppsDashboardPage appsDashboardPage;
	
	public AppsDashboardPageVerifications() {
		this.driver = getDriver();
		appsDashboardPage = new AppsDashboardPage();
	}
	
	public void verifyDarkModeEnabled() {
		Boolean value = driver.findElement(By.cssSelector(".flex-grow.order-first.mr-3")).isEnabled();
		if(value == true) {
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue(false);
		}
	}
	
	
	public void verifyTextOnAppsPage()throws InterruptedException{
//		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-header[text='Apps']"));
//		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
//		String text = shadowRoot1.findElement(By.tagName("h1")).getText();
//		Assert.assertEquals(text,"Apps");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-header[text='Apps']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		By searchSelector = By.cssSelector("ps-header[text='Apps']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSelector));
		String text = shadowRoot1.findElement(By.cssSelector("h1")).getText();
		Assert.assertEquals(text,"Apps");
		
	}
	public void verifyEdgeLink()throws InterruptedException{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://pentanaelearning.mygo1.com/login" );
		
	}
}
