package stepDefinitions;

import PageActions.UserAdminPageActions;
import PageObjects.UserAdminPage;
import PageVerifications.UserAdminPageVerifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAdminFilterSteps {
	UserAdminPage userAdminPage;
	UserAdminPageActions userAdminPageActions;
	UserAdminPageVerifications userAdminPageVerifications;
	
	public UserAdminFilterSteps() {
	userAdminPage = new UserAdminPage();
	userAdminPageActions = new UserAdminPageActions();
	userAdminPageVerifications = new UserAdminPageVerifications();
}

	@When("User clicks User Admin App")
	public void User_clicks_User_Admin_App() {
		userAdminPageActions.clickUserAdminBtn();
	}
	@Then("Page is Redirected to User Admin App")
	public void Page_is_Redirected_to_User_Admin_App()throws InterruptedException {
		userAdminPageVerifications.verifyUserAdminTabTitle();
	}
	@When("User Clicks on Filter Button")
	public void User_Clicks_on_Filter_Button() throws InterruptedException {	
		userAdminPageActions.clickFilterButton();
	}
	@And("user Enters Company Name {string}")
	public void user_Enters_Company_Name_(String companyName) throws InterruptedException {
		userAdminPageActions.enterCompanyName(companyName);
	}
	@And("Enters Branch Name {string}")
	public void Enters_Branch_Name(String branchName) throws InterruptedException {
		userAdminPageActions.enterBranchName(branchName);
		userAdminPageActions.clickApplyButton();
		
	}

	@Then("User Verifies the Company Name {string}")
	public void User_Verifies_the_Company_Name(String companyName ) throws InterruptedException  {
		userAdminPageActions.clickUser();
		userAdminPageActions.clickOrgStruc();
		userAdminPageVerifications.verifyCompanyName(companyName);
		
		
	}
	@Then("User Verifies the Branch Name {string}")
	public void User_Verifies_the_Branch_Name(String branchName ) throws InterruptedException  {
		userAdminPageVerifications.verifyBranchName(branchName);
	}
}