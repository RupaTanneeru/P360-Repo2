package GenericActions;

import static Utils.WebDriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.FileReaderManager;

public class GenericPageWaits {
	private WebDriver driver;
	private final int EXPLICIT_WAIT_DEFAULT = 180;
	
	public GenericPageWaits() {
		this.driver = getDriver();
	}
	
	public void delay() {
        delay(1);
    }
    
    public void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void waitElementVisible(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_DEFAULT));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitElementVisible(WebElement element, int waitseconds) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitElementVisible(SearchContext element, By selector, int waitseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
        if (selector != null && element == null) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
        }
        else if (selector != null && element != null) {
            wait.until(ExpectedConditions.visibilityOf(element.findElement(selector)));
        }
        else {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(selector)));
        }
    }
    
    public void waitElementVisible(By selector) {
        waitElementVisible(null, selector, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waitElementVisible(SearchContext element, By selector) {
        waitElementVisible(element, selector, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waitElementVisible(By selector, int waitseconds) {
        waitElementVisible(null, selector, waitseconds);
    }
    
    public void waitElementNotVisible(SearchContext element, By selector, int waitseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
        if (selector != null && element == null) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
        }
        else if (selector != null && element != null) {
            wait.until(ExpectedConditions.invisibilityOf(element.findElement(selector)));
        }
        else {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(selector)));
        }
    }
    
    public void waitElementNotVisible(By selector) {
        waitElementNotVisible(null, selector, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waitElementNotVisible(SearchContext element, By selector) {
        waitElementNotVisible(element, selector, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waitElementNotVisible(By selector, int waitseconds) {
        waitElementNotVisible(null, selector, waitseconds);
    }
    
    public void waiteElementToBeClickable(WebElement element, By selector, int waitseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
        if (selector != null) {
            wait.until(ExpectedConditions.elementToBeClickable(selector));
        }
        else if (element != null) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }
    
    public void waiteElementToBeClickable(By selector) {
        waiteElementToBeClickable(null, selector, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waiteElementToBeClickable(By selector, int waitseconds) {
        waiteElementToBeClickable(null, selector, waitseconds);
    }
    
    public void waiteElementToBeClickable(WebElement element) {
        waiteElementToBeClickable(element, null, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waiteElementToBeClickable(WebElement element, int waitseconds) {
        waiteElementToBeClickable(element, null, waitseconds);
    }
    
    public void waitElementTextToBePresent(WebElement element, By selector, String text, int waitseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
        if (selector != null) {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(selector, text));
        }
        else if (element != null) {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        }
    }
    
    public void waitElementTextToBePresent(By selector, String text) {
        waitElementTextToBePresent(null, selector, text, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waitElementTextToBePresent(By selector, String text, int waitseconds) {
        waitElementTextToBePresent(null, selector, text, waitseconds);
    }
    
    public void waitElementTextToBePresent(WebElement element, String text) {
        waitElementTextToBePresent(element, null, text, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waitElementTextToBePresent(WebElement element, String text, int waitseconds) {
        waitElementTextToBePresent(element, null, text, waitseconds);
    }
    
    public void waitValueToBePresentBy(By selector, String value, int waitseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
        wait.until(ExpectedConditions.textToBePresentInElementValue(selector, value));
    }
    
    public void waitElementValueToBePresent(By selector, String value) {
        waitElementTextToBePresent(null, selector, value, EXPLICIT_WAIT_DEFAULT);
    }
    
    public void waitForWindowNumToBe(int tabs, int waitseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
        wait.until(ExpectedConditions.numberOfWindowsToBe(tabs));
    }
    
    public void waitPageTitle(String title, int waitseconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitseconds));
        wait.until(ExpectedConditions.titleIs(title));
    }
   
    public void setImplicitWait() {
        setImplicitWait((int)FileReaderManager.getInstance().getConfigReader().getImplicitWait());
    }
    
    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    
}
