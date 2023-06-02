@FilterApp
Feature: Filter Search Functionality

  Scenario Outline: Search User Using Filter 
	Given User signs in to application with email "carl.malubag@pentanasolutions.com" and password "Password123#"
  When User clicks User Admin App
  Then Page is Redirected to User Admin App
  When User Clicks on Filter Button
  And  user Enters Company Name "test"
  And  Enters Branch Name "test3a"
  Then User Verifies the Company Name "test"
  Then User Verifies the Branch Name "test3a"
     
     
     
