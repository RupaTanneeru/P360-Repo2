@ProfilePermission
Feature: Profile Permission Functionality

  Background: 
	Given User signs in to application with email "carl.malubag@pentanasolutions.com" and password "Password123#"
  When User clicks User Admin App
  Then Page is Redirected to User Admin App
  
  
  Scenario:
  When User Selects An account "Carl-Test"
  And clicks permissions 
  Then User is on Permission Profiles
  When User Clicks on a Permission Profile
  Then worksheet tabs change according Active Profile
