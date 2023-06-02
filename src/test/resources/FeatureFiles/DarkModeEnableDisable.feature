@darkMode
Feature: Dark Mode Enable and Disable  functionality

  Scenario Outline: Verify Dark Mode enable
  Given User signs in to application with email "<email>" and password "<password>"
  And Navigates to Home Page
  When User clicks on User Icon button
  And clicks on Dark Mode checkbox 
  Then Dark Mode gets enabled 
  When User again clicks on Dark Mode
  Then Dark Mode gets disabled
  
  
  
    Examples: 
      |                  email                    | password    |
      | Garima.Shrivastav@pentanacontractor.com   | Password@1  |
      | Sameer.Tamboli+1@pentanacontractor.com    | Test1234!   | 
      
