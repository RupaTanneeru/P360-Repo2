package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class shadowRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new EdgeDriver();
driver.get("http://watir.com/examples/shadow_dom.html");
//WebElement shadowHost = driver.findElement(By.id("shadow_host"));
//SearchContext shadowRoot = shadowHost.getShadowRoot();
//String text = shadowRoot.findElement(By.cssSelector("#shadow_content > span")).getText();
//System.out.println(text);


//nested shadowroot

WebElement shadowHost1 = driver.findElement(By.id("shadow_host"));
SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
//String text1 = shadowRoot1.findElement(By.cssSelector("#shadow_content > span")).getText();
//System.out.println(text1);



WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("#nested_shadow_host"));
SearchContext shadowRoot2 = shadowHost2.getShadowRoot();
String text2 = shadowRoot2.findElement(By.cssSelector("#nested_shadow_content > div")).getText();
System.out.println(text2);

	}

}
