@createUser
Feature: User Administration App Create Users

Scenario: Verify admin is able to create user
	Given User signs in to application with email "Icon.Vergara@automationqa.com" and password "Welcome@1"
  Then User is able to Sign in successfully
  When User is able to see the User Administration button
  And User clicks the User Administration button
	Then User is able to access the User Administration app
	When User clicks New user button
	Then User is redirected to New user page
	When User enters new full name
	And User enters new email
	And User enters job title "QA"
	And User enters role "user"
	And User clicks continue
	Then User is redirected to Selected companies and branches page
	When User selects "QAAutomationS02"
	And User clicks save button
	Then Notification that user has been created is shown
 