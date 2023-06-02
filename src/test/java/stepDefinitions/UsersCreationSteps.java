package stepDefinitions;

import PageActions.UserAdminPageActions;
import PageObjects.UserAdminPage;
import PageVerifications.UserAdminPageVerifications;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersCreationSteps {
	UserAdminPage userAdminPage;
	UserAdminPageActions userAdminPageActions;
	UserAdminPageVerifications userAdminPageVerifications;
	
	
	public UsersCreationSteps() {
		userAdminPage = new UserAdminPage();
		userAdminPageActions = new UserAdminPageActions();
		userAdminPageVerifications = new UserAdminPageVerifications();
	}
	
	@When("User clicks New user button")
	public void user_clicks_new_user_button() {
		userAdminPageActions.clickNewUserBtn();
	}
	@Then("User is redirected to New user page")
	public void user_is_redirected_to_new_user_page() {
		userAdminPageVerifications.verifyUserIsInNewUserPage();
	}
	@When("User enters new full name")
	public void user_enters_full_name() {
		userAdminPageActions.enterFullName();
	}
	
	@When("User enters new email")
	public void user_enters_new_email() {
		userAdminPageActions.enterEmail();
	}
	
	@When("User enters job title {string}")
	public void user_enters_job_title(String string) {
		userAdminPageActions.enterJobTitle(string);
	}
	@When("User enters role {string}")
	public void user_enters_role(String string) {
		userAdminPageActions.enterRole(string);
	}
	@When("User clicks continue")
	public void user_clicks_continue() {
		userAdminPageActions.clickContinueBtn();
	}
	@Then("User is redirected to Selected companies and branches page")
	public void user_is_redirected_to_selected_companies_and_branches_page() {
		userAdminPageVerifications.verifyUserCreationSelectCompaniesAndBranches();
	}
	@When("User selects {string}")
	public void user_selects(String string) {
		userAdminPageActions.tickCheckBox(string);
	}
	@When("User clicks save button")
	public void user_clicks_save_button() {
		userAdminPageActions.clickSaveBtn();
	}
	@Then("Notification that user has been created is shown")
	public void notification_that_user_has_been_created_is_shown() {
		userAdminPageVerifications.verifyUserIsCreated();
	}
}
