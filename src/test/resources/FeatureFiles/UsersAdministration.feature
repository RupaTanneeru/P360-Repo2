@userAdmin
Feature: User Administration App

Scenario Outline: Verify user is able to access User Administration app
	Given User signs in to application with email "<email>" and password "<password>"
  Then User is able to Sign in successfully
  When User is able to see the User Administration button
  And User clicks the User Administration button
	Then User is able to access the User Administration app
 
 Examples: 
      |                  email                    | password    |
      | Sameer.Tamboli+1@pentanacontractor.com    | Test1234!   | 