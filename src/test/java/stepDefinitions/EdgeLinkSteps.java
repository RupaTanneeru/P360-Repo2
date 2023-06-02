package stepDefinitions;

import GenericActions.GenericBrowserActions;
import PageActions.AppsDashboardPageActions;
import PageActions.LoginPageActions;
import PageActions.UserAdminPageActions;
import PageObjects.LoginPage;
import PageVerifications.AppsDashboardPageVerifications;
import PageVerifications.LoginPageVerifications;
import PageVerifications.UserAdminPageVerifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EdgeLinkSteps {
	
	LoginPage loginPage;
	LoginPageActions loginPageActions;
	LoginPageVerifications loginPageVerifications;
	GenericBrowserActions genericBrowserActions;
	AppsDashboardPageActions appsDashboardPageActions;
	AppsDashboardPageVerifications appsDashboardPageVerifications;
	UserAdminPageActions userAdminPageActions;
	UserAdminPageVerifications userAdminPageVerifications;
	public EdgeLinkSteps()
	{
		loginPage = new LoginPage();
		loginPageActions = new LoginPageActions();
		loginPageVerifications = new LoginPageVerifications();
		appsDashboardPageActions = new AppsDashboardPageActions();
		appsDashboardPageVerifications = new AppsDashboardPageVerifications();
		genericBrowserActions = new GenericBrowserActions();
		userAdminPageActions = new UserAdminPageActions();
		userAdminPageVerifications = new UserAdminPageVerifications();
	}
	 
	 @When("User Clicks on Edge Link")
	    public void User_Clicks_on_Edge_Link() throws Throwable {
		 appsDashboardPageActions.clickEdge();	
	 }
	 
	 @Then("User is redirected to Elearning Portal")
	    public void User_is_redirected_to_Elearning_Portal() throws Throwable {
		 appsDashboardPageVerifications.verifyEdgeLink();	
	 }
	 
	 @And("User clicks on Edge Link in User Admin App")
	    public void User_clicks_on_Edge_Link_in_User_Admin_App() throws Throwable {
		 userAdminPageActions.clickEdgeBtn();	
		 Thread.sleep(2000);
	 }
	 
	 @Then("User is redirected to Elearning Portal in UserApp")
	    public void User_is_redirected_to_Elearning_Portal_in_UserApp() throws Throwable {
		 userAdminPageVerifications.verifyEdgeLinkUser();	
	 }
	 
	
	
	
	
	
	
	
	
	
	
	

}
