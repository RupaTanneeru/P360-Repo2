package stepDefinitions;

import PageActions.UserAdminPageActions;
import PageObjects.UserAdminPage;
import PageVerifications.UserAdminPageVerifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAdminPermissionsSteps {
	UserAdminPage userAdminPage;
	UserAdminPageActions userAdminPageActions;
	UserAdminPageVerifications userAdminPageVerifications;
	
	public UserAdminPermissionsSteps() {
	userAdminPage = new UserAdminPage();
	userAdminPageActions = new UserAdminPageActions();
	userAdminPageVerifications = new UserAdminPageVerifications();
	}
	
	
	@When("User Selects An account {string}")
	public void User_Selects_An_account(String searchText) throws InterruptedException {
		userAdminPageActions.enterSearchText(searchText);
		userAdminPageActions.clickUser();
	}
	@And("clicks permissions")
	public void clicks_permissions() throws InterruptedException {
		userAdminPageActions.clickPermissions();
	}
	@Then("User is on Permission Profiles")
	public void User_is_on_Permission_Profiles() throws InterruptedException {
		userAdminPageVerifications.verifyPermissionPage();
	}
	@When("User clicks on worksheet enable options")
	public void User_clicks_on_worksheet_enable_options() throws InterruptedException {
		userAdminPageActions.clickWorkSheet();
		userAdminPageActions.enableAccountingGP();
		userAdminPageActions.enableActualDelivery();
	}
	@And("User goes back and click Settings")
	public void User_goes_back_and_click_Settings() throws InterruptedException {
		userAdminPageActions.clickBack();
		
	}
	@And("User clicks Reset Permissions")
	public void User_clicks_Reset_Permissions() throws InterruptedException {
		userAdminPageActions.clickActions();
		userAdminPageActions.clickresetPermission();
		userAdminPageActions.clickReset();
	}
	@Then("the Permissions that have been enabled will be disabled")
	public void the_Permissions_that_have_been_enabled_will_be_disabled() throws InterruptedException {
		userAdminPageActions.clickWorkSheet();
		userAdminPageVerifications.verifyAccountGPButtonStatus();
	}
	

	@And("User goes back and click Worksheet")
	public void User_goes_back_and_click_Worksheet() throws InterruptedException {
		userAdminPageActions.clickBack();
		userAdminPageActions.clickWorkSheet();		
	}
	
	@Then("User can disable worksheet options")
	public void User_can_disable_worksheet_options() throws InterruptedException {
		userAdminPageActions.enableAccountingGP();
		userAdminPageActions.enableActualDelivery();		
	}
	

	

	@When("User Clicks on a Permission Profile")
	public void User_Clicks_on_a_Permission_Profile() throws InterruptedException {
		userAdminPageActions.clickAccountant();
	}
	
	@When("worksheet tabs change according Active Profile")
	public void worksheet_tabs_change_according_Active_Profile() throws InterruptedException {
		userAdminPageActions.clickWorkSheet();
		userAdminPageVerifications.verifyActualDeliveryDateStatus();
	}
	
	
	


	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}