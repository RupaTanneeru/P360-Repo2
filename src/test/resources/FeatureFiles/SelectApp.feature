@selectApp
Feature: Access Different Apps

Scenario: Select Application on Apps Tab
	Given User signs in to application with email "Carl.Malubag@pentanasolutions.com" and password "Password123#"
  And User clicks on Menu Icon
  And Clicks on Apps tab
	Then User is redirected to Applications
	When User Clicks on a Application
	Then User Redirects to the Application Page

