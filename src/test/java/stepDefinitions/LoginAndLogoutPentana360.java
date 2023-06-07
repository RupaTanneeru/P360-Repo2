package stepDefinitions;

import GenericActions.GenericBrowserActions;
import PageActions.LoginPageActions;
import PageVerifications.LoginPageVerifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAndLogoutPentana360 {
	
	
	GenericBrowserActions genericbrowseractions;
	LoginPageActions loginpageactions;
	LoginPageVerifications loginpageverifications;
	
	
	public LoginAndLogoutPentana360()
	{
		genericbrowseractions = new GenericBrowserActions();
		loginpageactions = new LoginPageActions();
		loginpageverifications = new LoginPageVerifications();
	}
	
	
	
	
	@Given("user nevigating to the Penatna360 webapp url")
	public void user_nevigating_to_the_penatna360_webapp_url() throws InterruptedException {
	   
		genericbrowseractions.launchBrowser();
		Thread.sleep(2000);
	   
	}
	
	@And("User enters {string} into Email field")
	public void user_enters_into_email_field(String email) throws InterruptedException {
		
		loginpageactions.enterEmail(email);
	
	}
	
	
	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
	     
		loginpageactions.clickContinueBtn();
	    
	    }
	@And("User enters Password {string} into Password field")
	public void user_enters_password_into_password_field(String password) throws InterruptedException {
	
		loginpageactions.enterPassword(password);
	}
	

	@When("click on signin button")
	public void click_on_signin_button() throws InterruptedException {
	   
		loginpageactions.signIn();
	}

	@Then("User is login into Pentana360 successfully")
	public void user_is_login_into_pentana360_successfully() throws InterruptedException {
	    
		loginpageverifications.verifySignInSuccessful();
	}

	@Given("user clicks on User Icon")
	public void user_clicks_on_user_icon() throws InterruptedException {
	 
		loginpageactions.clickUserIcon();	
	}

	@When("User click on Signout button")
	public void user_click_on_signout_button() throws InterruptedException {
		
		loginpageactions.signOut();
		
	}

	@Then("User should be able to logout successfully from Pentana360 Application")
	public void user_should_be_able_to_logout_successfully_from_pentana360_application() throws InterruptedException {
	   
		loginpageverifications.verifySignOut();
	}

	
	
	
	
	
	
	

}
