Feature: Enable/Disable Permission Functionality

  Background: 
	Given User signs in to application with email "carl.malubag@pentanasolutions.com" and password "Password123#"
  When User clicks User Admin App
  Then Page is Redirected to User Admin App
  
  
  Scenario:
  When User Selects An account "Carl-Test"
  And clicks permissions 
  Then User is on Permission Profiles
  When User clicks on worksheet enable options
  And  User goes back and click Worksheet 
  Then User can disable worksheet options
  