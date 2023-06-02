package stepDefinitions;


import GenericActions.GenericBrowserActions;
import PageActions.LoginPageActions;
import PageObjects.LoginPage;
import PageVerifications.LoginPageVerifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginLogoutSteps {
	LoginPage loginPage;
	LoginPageActions loginPageActions;
	LoginPageVerifications loginPageVerifications;
	GenericBrowserActions genericBrowserActions;

	public LoginLogoutSteps() {
		loginPage = new LoginPage();
		loginPageActions = new LoginPageActions();
		loginPageVerifications = new LoginPageVerifications();
		genericBrowserActions = new GenericBrowserActions();
	}
	
	@Given("User signs in to application with email {string} and password {string}")
	public void user_signs_in_to_application(String email,String password) throws Throwable {
		genericBrowserActions.launchBrowser();
		loginPageActions.enterEmail(email);
		loginPageActions.clickContinueBtn();
		loginPageActions.enterPassword(password);
		loginPageActions.signIn();
	}
	
	@Given("User is on Sign in page")
	public void user_is_on_sign_in_page() throws Throwable {
		genericBrowserActions.launchBrowser();
		Thread.sleep(2000);
	}

	@When("User enters email {string}")
	public void user_enters_username_something(String email) throws Throwable {
		loginPageActions.enterEmail(email);
	}

	@And("User clicks Continue button")
	public void user_clicks_continue_button() throws Throwable {
		loginPageActions.clickContinueBtn();;
	}
	
	@And("User enters password {string}")
	public void user_enters_password_something(String password) throws Throwable {
		loginPageActions.enterPassword(password);
	}

	@And("Clicks on Sign In button")
	public void clicks_on_sign_in_button() throws Throwable {
		loginPageActions.signIn();
	}
	@Then("User is able to Sign in successfully")
	public void user_is_able_to_sign_in_successfully() throws Throwable {
		loginPageVerifications.verifySignInSuccessful();
	}

	@When("User clicks on User Icon")
	public void user_clicks_on_user_icon() throws Throwable {
		loginPageActions.clickUserIcon();
	}

	@And("Clicks on Sign Out option")
	public void clicks_on_sign_out_option() throws Throwable {
		loginPageActions.signOut();
	}

	@Then("User is able to Sign Out of application")
	public void user_is_able_to_sign_out_of_application() throws Throwable {
		loginPageVerifications.verifySignOut();
	}

}

