package stepDefinitions;

import static Utils.WebDriverManager.closeDriver;
import static Utils.WebDriverManager.getDriver;

import java.io.IOException;
import java.sql.Timestamp;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class HookSteps {
	
	@Before
	public void beforeScenario() {
		getDriver();
	}
	
	@After
	public void afterScenario() {
		closeDriver();
	}
	
	@AfterStep
	public void captureExceptionImage(Scenario scenario) {
		if(scenario.isFailed()) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String timeMillis = Long.toString(timestamp.getTime());
			
			byte[] screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotFile, "image/png", timeMillis);
		}
	}
	
}
