package steps;

import consts.ConstsURL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageSteps {
    private final LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = new LoginPage();
    }

    @Given("I open the website login page")
    public void iOpenTheWebsiteLoginPage() {
        loginPage.navigateToLoginPage();
        String actualResult = loginPage.getLoginPageURL();
        assertEquals(ConstsURL.LOGIN_PAGE_URL, actualResult);
        String actualText = loginPage.isLoginPageTextDisplayed();
        assertEquals("Login Page", actualText);
        loginPage.takeScreenshot("LoginPageTest");
    }

    @Then("I should see username and password input fields, login button as well")
    public void iShouldSeeUsernameAndPasswordInputFieldsLoginButtonAsWell() {
        boolean successUserField = loginPage.isUsernameFieldDisplayed();
        assertTrue(successUserField);
        boolean successPasswordField = loginPage.isPasswordFieldDisplayed();
        assertTrue(successPasswordField);
        boolean successLoginButton = loginPage.isLoginButtonDisplayed();
        assertTrue(successLoginButton);
    }

    @And("The username and password texts input fields should be visible")
    public void theUsernameAndPasswordTextsInputFieldsShouldBeVisible() {
        String actualUsernameText = loginPage.isUsernameFieldTextDisplayed();
        assertEquals("Username", actualUsernameText);
        String actualPasswordText = loginPage.isPasswordFieldTextDisplayed();
        assertEquals("Password", actualPasswordText);
    }
}