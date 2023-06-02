@EdgeLink
Feature: Filter Search Functionality

  Background:  
	Given User signs in to application with email "carl.malubag@pentanasolutions.com" and password "Password123#"
  Then User Navigates to Home Page
  
  Scenario: Verify user is able to click Edge Link in Home Page
  When User Clicks on Edge Link 
  Then User is redirected to Elearning Portal 
  
	Scenario: Verify user is able to click Edge Link in Home Page
  When User clicks the User Administration button
	And User clicks on Edge Link in User Admin App
	Then User is redirected to Elearning Portal in UserApp 
     
     
     
