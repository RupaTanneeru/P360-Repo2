@adminSearch
Feature: User Administration App

Background:
  Given User signs in to application with email "iconbyl.vergara@pentanasolutions.com" and password "Testing!1234"
  Then User is able to Sign in successfully
  When User is able to see the User Administration button
	And User clicks the User Administration button
	Then User is able to access the User Administration app

Scenario: Verify user is able to search and find user in the User Administration app using name
	When User searches "Icon Vergara"
	Then Search results displays the user with "Icon Vergara"
	
Scenario: Verify user is able to search and find user in the User Administration app using role
	When User searches "QA"
	Then Search results displays the user with "Icon Vergara"
	
Scenario: Verify user is able to search and find user in the User Administration app using email
	When User searches "iconbyl.vergara@pentanasolutions.com"
	Then Search results displays the user with "Icon Vergara"
	
Scenario: Verify user is able to search and not find user in the User Administration app with no matching details
	When User searches "test"
	Then Search results do not contain the user with "Icon Vergara"
 