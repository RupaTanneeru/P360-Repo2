package stepDefinitions;

import GenericActions.GenericBrowserActions;
import PageActions.AppsDashboardPageActions;
import PageActions.LoginPageActions;
import PageObjects.LoginPage;
import PageVerifications.AppsDashboardPageVerifications;
import PageVerifications.LoginPageVerifications;
import PageVerifications.SalesActivityPageVerifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectAppSteps {	

	LoginPage loginPage;
	LoginPageActions loginPageActions;
	LoginPageVerifications loginPageVerifications;
	GenericBrowserActions genericBrowserActions;
	AppsDashboardPageActions appsDashboardPageActions;
	AppsDashboardPageVerifications appsDashboardPageVerifications;
	SalesActivityPageVerifications salesActivityPageVerifications;
	public SelectAppSteps()
	{
		loginPage = new LoginPage();
		loginPageActions = new LoginPageActions();
		loginPageVerifications = new LoginPageVerifications();
		appsDashboardPageActions = new AppsDashboardPageActions();
		appsDashboardPageVerifications = new AppsDashboardPageVerifications();
		genericBrowserActions = new GenericBrowserActions();
		salesActivityPageVerifications = new SalesActivityPageVerifications();
	}
	
	 @When("User Navigates to Home Page")
	    public void User_navigates_to_home_page() throws Throwable {
		  loginPageVerifications.verifySignInSuccessful();
	 }
	 @And("User clicks on Menu Icon")
	    public void User_clicks_on_Menu_Icon() throws Throwable {
		 appsDashboardPageActions.clickMenu();
	    }
	 
	 @And("Clicks on Apps tab")
	    public void Clicks_on_Apps_tab() throws Throwable {
		 appsDashboardPageActions.clickApps();
		 
	    }

	 @Then("User is redirected to Applications")
	    public void User_is_redirected_to_Applications() throws Throwable {
		 appsDashboardPageVerifications.verifyTextOnAppsPage();
	 	}
	 
	 @When("User Clicks on a Application")
	    public void User_Clicks_on_a_Application() throws Throwable {
		 appsDashboardPageActions.clickSAL();
	 }
	 
	 
	 @Then("User Redirects to the Application Page")
		public void User_Redirects_to_the_Application_Page() throws Throwable {
		 salesActivityPageVerifications.verifyTextOnSALPage();	 	
		 	
	 }
	 
}	 
