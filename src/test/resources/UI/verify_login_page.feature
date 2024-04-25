Feature: Verify visibility of login page

  Scenario: Verify input fields and button are displayed correctly
    Given I open the website login page
    Then I should see username and password input fields, login button as well
    And The username and password texts input fields should be visible