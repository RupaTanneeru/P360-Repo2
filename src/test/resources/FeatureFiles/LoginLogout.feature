@login
Feature: Sign in and Sign Out functionality

  Scenario Outline: Sign in with valid credentials and Sign out
  Given User is on Sign in page
  When User enters email "<email>" 
  And User clicks Continue button
  And User enters password "<password>"
  And Clicks on Sign In button
  Then User is able to Sign in successfully
  When User clicks on User Icon 
  And Clicks on Sign Out option
  Then User is able to Sign Out of application
    

    Examples: 
      |                  email                    | password    |
      | Garima.Shrivastav@pentanacontractor.com   | Password@1  |
      | Sameer.Tamboli+1@pentanacontractor.com    | Test1234!   | 
      
      
      