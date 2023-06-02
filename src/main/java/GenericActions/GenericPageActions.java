package GenericActions;

import static Utils.WebDriverManager.getDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GenericPageActions {
	private WebDriver driver;
	
	public GenericPageActions () {
		this.driver = getDriver();
	}
	
	public void clickByCoordinates(WebElement elem, int pixfromleft, int pixfromtop) {
        Actions builder = new Actions(driver);
        builder.moveToElement(elem, pixfromleft, pixfromtop).click().build().perform();
    }
    
    public void clickByElemCoordinates(WebElement element) throws Exception {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
    
    public void clickCheckbox(WebElement checkbox, boolean check) {
        if (checkbox.isSelected() != check) {
            Actions actions = new Actions(driver);
            actions.moveToElement(checkbox).click().build().perform();
        }
    }
    
    public void doubleClick(WebElement elem) {
        Actions builder = new Actions(driver);
        builder.moveToElement(elem).doubleClick().build().perform();
    }
    
    public void dragAndDrop(WebElement moveelem, WebElement toelem) {
    	Actions builder = new Actions(driver);
    	builder.clickAndHold(moveelem).moveToElement(toelem).release(toelem).build().perform();
    }
    
    public void dragAndDrop2(WebElement moveelem, WebElement toelem) {
        Actions builder = new Actions(driver);
        builder.dragAndDrop(moveelem, toelem);
    }
    
    public void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).release().build().perform();
    }
    
    public void hoverTo(WebElement elem) {
    	Actions builder = new Actions(driver);
    	builder.moveToElement(elem).build().perform();
    }
    
    public void sendKeysToPage(Keys key) throws Exception {
        Actions action = new Actions(driver);
        action.sendKeys(new CharSequence[] { (CharSequence)key }).build().perform();
    }
    
    public void clearInputBySendKeys(WebElement element) throws Exception {
    	clickUsingJS(element);
        String crtlA = Keys.chord(new CharSequence[] { (CharSequence)Keys.CONTROL, "a" });
        element.sendKeys(new CharSequence[] { String.valueOf(crtlA) + Keys.DELETE });
    }
    
    public String getCurrentDate(String format) {
        return getCurrentDate(format, 0L, 0L, 0L);
    }
    
    public String getCurrentDate(String format, long addDays, long addMonths, long addYears) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime ldt = LocalDateTime.now();
        if (addDays != 0L) {
            ldt = LocalDateTime.now().plusDays(addDays);
        }
        else if (addMonths != 0L) {
            ldt = LocalDateTime.now().plusMonths(addMonths);
        }
        else if (addYears != 0L) {
            ldt = LocalDateTime.now().plusYears(addYears);
        }
        return formatter.format(ldt);
    }
    
    public void backspace(WebDriver driver, WebElement elem) {
        backspace(driver, elem, 0);
    }
    
    public void backspace(WebDriver driver, WebElement elem, int slength) {
        String tstring = elem.getAttribute("value");
        if (slength == 0) {
            slength = tstring.length();
        }
        for (int i = slength; i >= 0; --i) {
            elem.sendKeys(new CharSequence[] { (CharSequence)Keys.BACK_SPACE });
        }
        elem.click();
    }
    
    public void clickUsingJS(WebElement element) {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
