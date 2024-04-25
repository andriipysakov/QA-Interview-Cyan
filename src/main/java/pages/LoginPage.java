package pages;

import consts.ConstsURL;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    public static final String USERNAME_FIELD_TEXT = "//label[@for='username']";
    public static final String USERNAME_FIELD = "//*[@id='username']";
    public static final String PASSWORD_FIELD_TEXT = "//label[@for='password']";
    public static final String PASSWORD_FIELD = "//*[@id='password']";
    public static final String LOGIN_BUTTON = "//button[@type='submit']";
    public static final String LOGIN_PAGE_TEXT = "//h2[text()='Login Page']";
    public static final String SECURE_PAGE_TEXT = "//h2[contains(text(), 'Secure Area')]";
    public static final String ERROR_USERNAME_TEXT = "//*[contains(text(), 'Your username is invalid!')]";
    public static final String ERROR_PASSWORD_TEXT = "//*[contains(text(), 'Your password is invalid!')]";

    public void navigateToLoginPage() {
        driver.get(ConstsURL.LOGIN_PAGE_URL);
    }

    public String isUsernameFieldTextDisplayed() {
        return isTextDisplayed(USERNAME_FIELD_TEXT);
    }

    public boolean isUsernameFieldDisplayed() {
        return elementExists(USERNAME_FIELD);
    }

    public String isPasswordFieldTextDisplayed() {
        return isTextDisplayed(PASSWORD_FIELD_TEXT);
    }

    public boolean isPasswordFieldDisplayed() {
        return elementExists(PASSWORD_FIELD);
    }

    public boolean isLoginButtonDisplayed() {
        return elementExists(LOGIN_BUTTON);
    }

    public String getLoginPageURL() {
        return getCurrentPageURL();
    }
    public String getSecurePageURL() {
        return getCurrentPageURL();
    }

    public String isLoginPageTextDisplayed() {
        return isTextDisplayed(LOGIN_PAGE_TEXT);
    }
    public String isSecurePageTextDisplayed() {
        return isTextDisplayed(SECURE_PAGE_TEXT);
    }
    public String isErrorUsernameTextDisplayed() {
        return isTextDisplayed(ERROR_USERNAME_TEXT);
    }
    public String isErrorPasswordTextDisplayed() {
        return isTextDisplayed(ERROR_PASSWORD_TEXT);
    }

    public WebElement findUsernameField() {
        return findElementByXpath(USERNAME_FIELD);
    }

    public WebElement findPasswordField() {
        return findElementByXpath(PASSWORD_FIELD);
    }

    public void clickLoginButton() {
        clickElementByXpath(LOGIN_BUTTON);
    }
}
