package PageVerifications;

import static Utils.WebDriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.LoginPage;

public class LoginPageVerifications {
	private WebDriver driver;
	LoginPage loginPage;
	
	public LoginPageVerifications() {
		driver = getDriver();
		loginPage = new LoginPage();
	}
	
	public void verifySignInSuccessful() throws InterruptedException {
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-button[icon='menu']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		String text = shadowRoot1.findElement(By.cssSelector("span[part='text']")).getText();
		Assert.assertEquals(text, "Menu");
	}
	
	public void verifySignOut() {
		String text = loginPage.SignInText.getText();
		Assert.assertEquals(text,"Sign in");
	}
	
	public void verifyTextOnAppsPage() {
		WebElement shadowHost1 = driver.findElement(By.cssSelector("ps-header[text='Apps']"));
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
		String text = shadowRoot1.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(text,"Apps");
	}
}
