package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features ={"src\\test\\resources\\FeatureFiles"} ,
		tags = "", 
		glue = {"stepDefinitions"} ,
		monochrome = true ,
		dryRun = false,
		plugin = {"pretty","html:target/result.html"})

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
