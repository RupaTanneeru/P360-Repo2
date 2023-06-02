package GenericActions;

import static Utils.WebDriverManager.getDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.FileReaderManager;

public class GenericBrowserActions {
	private WebDriver driver;
	GenericPageWaits genericPageWaits;
	
	public GenericBrowserActions() {
		this.driver = getDriver();
		genericPageWaits = new GenericPageWaits();
	}
	
	 public void closeBrowser() {
        driver.quit();
    }
    
    public void openInNewTab(WebElement link) {
        link.sendKeys(new CharSequence[] { Keys.CONTROL + "t" });
        driver.get(link.getAttribute("href"));
    }
    
    
    public void switchFrame(WebElement frame) {
        driver.switchTo().frame(frame);
    }
    
    public void switchFrame() {
        driver.switchTo().defaultContent();
    }
    
    public void switchTab(String urlpart) {
        try {
            List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            for (String tab : tabs) {
                driver.switchTo().window(tab);
                if (driver.getCurrentUrl().contains(urlpart)) {
                    return;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void switchTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window((String)tabs.get(tabNumber));
    }
    public void launchBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitWait()));
		driver.get(FileReaderManager.getInstance().getConfigReader().getURL());
	}
    
    public void navigateToURL(String newurl) {
        driver.get(newurl);
    }
    
    public void closeTab(String urlpart) {
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (driver.getCurrentUrl().contains(urlpart)) {
                driver.close();
                genericPageWaits.delay();
                break;
            }
        }
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window((String)tabs.get(0));
    }
    
    public void returnToDefaultTab() {
        driver.switchTo().defaultContent();
    }
    
    public void acceptAlertPopUp() {
        driver.switchTo().alert().accept();
    }
    
    public void dismissAlertPopUp() {
        driver.switchTo().alert().dismiss();
    }
    
    public void refreshBrowser() {
        driver.navigate().refresh();
        genericPageWaits.delay();
    }
    
    public void navigateBackOnce() {
        driver.navigate().back();
        genericPageWaits.delay();
    }
    
    public void resizeWebDriver(int width, int height) throws Exception {
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
    }
    
}
