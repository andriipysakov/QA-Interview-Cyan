# Three exercises for Test Automation

## Overview
This project involves developing automated tests implemented for different functionalities of a web application and the backend.

## Acceptance Criteria
1. Form Authentication
- Positive Test Case: Verify that logging in with valid credentials successfully authenticates the user.
- Negative Test Case: Verify that logging in with invalid credentials results in an authentication failure.
2. HTTP Status Codes Verification
- Ensure that the correct HTTP status code is returned upon navigation to specific pages.
- Verify that for each expected HTTP status code (200, 301, 404, 500), the corresponding page returns the same status code.
3. REST API User Verification
- Confirm the existence of the user "Nicholas Runolfsdottir V" in the provided REST API.
- Verify that if the user "Nicholas Runolfsdottir V" exists, their address data contains the required information.

## API Details
1. Base URL for Form Authentication: `http://the-internet.herokuapp.com/login`
- Request Type: POST
- Request Body: JSON object containing username and password fields.
- Response Format: HTML page with login status (Success or Failure).
2. Base URL for HTTP Status Codes: `http://the-internet.herokuapp.com/status_codes`
- Available Endpoints: Various pages returning different HTTP status codes (e.g., 200, 301, 404, 500).
- Request Type: GET
- Response Format: HTML page with the corresponding HTTP status code.
3. Base URL for REST API: `https://jsonplaceholder.typicode.com/users`
- Request Type: GET
- Response Format: JSON array containing user objects with details such as name, username, email, address, etc.

## Automation Framework
- Language: Java
- Frameworks: Cucumber, TestNG, Selenium, RestAssured
- Build Tool: Maven
- BDD: Executed cucumber tests
- Reporting: Cucumber HTML report

## Installation and Setup
1. Clone the repository https://github.com/andriipysakov/QA-Interview-Cyan.
2. Open the project in your preferred IDE.
3. Ensure you have Java, Maven, and Selenium installed on your system.
4. Update the `pom.xml` file with any required dependencies.
5. Run the test cases using the provided test runner.

## Test Report
The test results are available in the `target/cucumberReports/report.html` file. This report provides detailed information about the executed scenarios, including pass/fail status, steps. The test screenshots are available in the `screenshots` folder.

---
### Note: Ensure proper internet connectivity and access to the APIs before running the tests.
