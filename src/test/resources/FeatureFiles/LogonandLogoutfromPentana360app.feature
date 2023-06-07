@Penetana360Login
Feature: user should be able to logon into Pentana360 application

  Scenario Outline: Login with valid credentials ad logout from App
    Given user nevigating to the Penatna360 webapp url
    And User enters "<email>" into Email field
    And User clicks on continue button
    And User enters Password "<password>" into Password field
    When click on signin button
    Then User is login into Pentana360 successfully
    Given user clicks on User Icon
    When User click on Signout button
    Then User should be able to logout successfully from Pentana360 Application
    

       Examples: 
           | email                              | password  |
           | Rupa.Tanneeru@pentanasolutions.com | Test1234! |