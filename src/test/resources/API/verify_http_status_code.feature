Feature: Verify correct HTTP status codes on navigation to a certain page

  Scenario Outline: Verify correct HTTP status codes on navigation
    Given I navigate to the page with multiple HTTP status codes <Endpoint>
    Then I should see the correct HTTP status code <ResponseCode>

    Examples:
    | Endpoint | ResponseCode |
    | "200" | 200 |
    | "301" | 301 |
    | "404" | 404 |
    | "500" | 500 |
