package stepDefinitions;

import PageActions.UserAdminPageActions;
import PageObjects.UserAdminPage;
import PageVerifications.UserAdminPageVerifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAdministrationSteps {
	UserAdminPage userAdminPage;
	UserAdminPageActions userAdminPageActions;
	UserAdminPageVerifications userAdminPageVerifications;
	
	
	public UserAdministrationSteps() {
		userAdminPage = new UserAdminPage();
		userAdminPageActions = new UserAdminPageActions();
		userAdminPageVerifications = new UserAdminPageVerifications();
	}
	
	@When("User is able to see the User Administration button")
	public void user_is_able_to_see_the_user_administration_button() {
		userAdminPageVerifications.verifyUserAdminBtnVisibility(true);
	}
	
	@And("User clicks the User Administration button")
	public void user_clicks_the_user_administration_button() {
		userAdminPageActions.clickUserAdminBtn();
	}
	@Then("User is able to access the User Administration app")
	public void user_is_able_to_access_the_user_administration_app() throws InterruptedException {
		userAdminPageVerifications.verifyUserAdminTabTitle();
	}
	
	@When("User searches {string}")
	public void user_searches(String searchText) throws InterruptedException {
		userAdminPageActions.enterSearchText(searchText);
	}
	@Then("Search results displays the user with {string}")
	public void search_results_displays_the_user_with(String expectedTextName) throws InterruptedException {
		userAdminPageVerifications.verifySearchResultNameExists(expectedTextName);
	}
	
	@Then("Search results do not contain the user with {string}")
	public void search_results_do_not_contain_the_user_with(String expectedTextName) throws InterruptedException {
		userAdminPageVerifications.verifySearchResultNameNotExists(expectedTextName);
	}
}
