Feature: Verify user existence and address data

  Scenario: Verify user Nicholas Runolfsdottir V exists
    Given I send a GET request to "https://jsonplaceholder.typicode.com/users"
    Then I verify user "Nicholas Runolfsdottir V" exists

  Scenario: Verify user Nicholas Runolfsdottir V address data
    Given I send a GET request to "https://jsonplaceholder.typicode.com/users"
    And I verify user "Nicholas Runolfsdottir V" exists
    Then I verify user "Nicholas Runolfsdottir V" address contains data