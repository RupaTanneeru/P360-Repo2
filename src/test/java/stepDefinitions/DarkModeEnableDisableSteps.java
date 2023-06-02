package stepDefinitions;

import GenericActions.GenericBrowserActions;
import PageActions.AppsDashboardPageActions;
import PageActions.LoginPageActions;
import PageObjects.LoginPage;
import PageVerifications.AppsDashboardPageVerifications;
import PageVerifications.LoginPageVerifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DarkModeEnableDisableSteps{
	LoginPage loginPage;
	LoginPageActions loginPageActions;
	LoginPageVerifications loginPageVerifications;
	AppsDashboardPageActions appsDashboardPageActions;
	AppsDashboardPageVerifications appsDashboardPageVerifications;
	GenericBrowserActions genericBrowserActions;
	
	public DarkModeEnableDisableSteps(){
		loginPageActions = new LoginPageActions();
		loginPageVerifications = new LoginPageVerifications();
		appsDashboardPageActions = new AppsDashboardPageActions();
		appsDashboardPageVerifications = new AppsDashboardPageVerifications();
		genericBrowserActions = new GenericBrowserActions();
	}
	
	@And("Navigates to Home Page")
	public void navigates_to_home_page() throws Throwable {
		loginPageVerifications.verifySignInSuccessful();
	}

	@When("User clicks on User Icon button")
	public void user_clicks_on_user_icon_button() throws Throwable {
		loginPageActions.clickUserIcon();
	}
	
	@And("clicks on Dark Mode checkbox")
	public void clicks_on_dark_mode_checkbox() throws Throwable {
		appsDashboardPageActions.tickDarkModeCheckbox();
	}

	@Then("Dark Mode gets enabled")
	public void dark_mode_is_enabled() throws Throwable {
		appsDashboardPageVerifications.verifyDarkModeEnabled();
	}
	
	@When("User again clicks on Dark Mode")
	public void User_again_clicks_on_Dark_Mode() throws Throwable {
		appsDashboardPageActions.tickDarkModeCheckbox();
	}
	
	@Then("Dark Mode gets disabled")
	public void dark_mode_gets_disabled() throws Throwable {
		appsDashboardPageVerifications.verifyDarkModeEnabled();
	}

}





