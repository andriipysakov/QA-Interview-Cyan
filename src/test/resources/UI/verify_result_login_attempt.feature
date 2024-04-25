Feature: User Login
  As a user
  I want to log in to the system
  So that I can access my account

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username "tomsmith" and valid password "SuperSecretPassword!"
    And I click on the login button
    Then I should be logged in successfully. As well I see a new page secure area with text "Secure Area"

  Scenario: Login with blank username
    Given I am on the login page
    When I leave the username field blank
    And I enter valid password "SuperSecretPassword!"
    And I click on the login button
    Then I should see an error message "Your username is invalid!" indicating that the username is required

  Scenario: Login with blank password
    Given I am on the login page
    When I enter valid username "tomsmith"
    And I leave the password field blank
    And I click on the login button
    Then I should see an error message "Your password is invalid!" indicating that the password is required

  Scenario: Login with incorrect credentials
    Given I am on the login page
    When I enter invalid username "invalid_user" and invalid password "invalid_password"
    And I click on the login button
    Then I should see an error message "Your username is invalid!" indicating that the credentials are incorrect
