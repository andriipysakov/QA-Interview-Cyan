package steps;

import consts.ConstsURL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultLoginAttemptSteps {
    private final LoginPage loginPage;

    public ResultLoginAttemptSteps() {
        loginPage = new LoginPage();
    }
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("I enter valid username {string} and valid password {string}")
    public void iEnterValidUsernameAndValidPassword(String username, String password) {
        WebElement usernameField = loginPage.findUsernameField();
        usernameField.sendKeys(username);
        WebElement passwordField = loginPage.findPasswordField();
        passwordField.sendKeys(password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully. As well I see a new page secure area with text {string}")
    public void iShouldBeLoggedInSuccessfully(String message) {
        String actualResult = loginPage.getSecurePageURL();
        assertEquals(ConstsURL.SECURE_PAGE_URL, actualResult);
        String actualText = loginPage.isSecurePageTextDisplayed();
        assertEquals(message, actualText);
        loginPage.takeScreenshot("SecurePageTest");
    }

    @When("I leave the username field blank")
    public void iLeaveTheUsernameFieldBlank() {
    }

    @And("I enter valid password {string}")
    public void iEnterValidPassword(String password) {
        WebElement passwordField = loginPage.findPasswordField();
        passwordField.sendKeys(password);
    }

    @Then("I should see an error message {string} indicating that the username is required")
    public void iShouldSeeAnErrorMessageIndicatingThatTheUsernameIsRequired(String errorMessage) {
        String actualText = loginPage.isErrorUsernameTextDisplayed();
        actualText = actualText.replaceAll("[^\\w!]+$", "");
        assertEquals(errorMessage, actualText);
        loginPage.takeScreenshot("ErrorUsernameMessage");
    }

    @When("I enter valid username {string}")
    public void iEnterValidUsername(String username) {
        WebElement usernameField = loginPage.findUsernameField();
        usernameField.sendKeys(username);
    }

    @And("I leave the password field blank")
    public void iLeaveThePasswordFieldBlank() {
    }

    @Then("I should see an error message {string} indicating that the password is required")
    public void iShouldSeeAnErrorMessageIndicatingThatThePasswordIsRequired(String errorMessage) {
        String actualText = loginPage.isErrorPasswordTextDisplayed();
        actualText = actualText.replaceAll("[^\\w!]+$", "");
        assertEquals(errorMessage, actualText);
        loginPage.takeScreenshot("ErrorPasswordMessage");
    }

    @When("I enter invalid username {string} and invalid password {string}")
    public void iEnterInvalidUsernameAndInvalidPassword(String username, String password) {
        WebElement usernameField = loginPage.findUsernameField();
        usernameField.sendKeys(username);
        WebElement passwordField = loginPage.findPasswordField();
        passwordField.sendKeys(password);
        loginPage.clickLoginButton();
    }

    @Then("I should see an error message {string} indicating that the credentials are incorrect")
    public void iShouldSeeAnErrorMessageIndicatingThatTheCredentialsAreIncorrect(String errorMessage) {
        String actualText = loginPage.isErrorUsernameTextDisplayed();
        actualText = actualText.replaceAll("[^\\w!]+$", "");
        assertEquals(errorMessage, actualText);
        loginPage.takeScreenshot("ErrorIncorrectCredentialsMessage");
    }
}
