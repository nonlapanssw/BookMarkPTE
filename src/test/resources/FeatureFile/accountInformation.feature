Feature: Check account information feature

  Background:
    Given User is on world ticket page


  Scenario: Account Information - The user should see his/her email in account information page
    When User login to world ticket website
    And User clicks on Account Information side tab
    Then User email address is displayed