package pages;

import app.WebDriverSetup;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class BasePage {
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver = WebDriverSetup.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = driver.findElement(By.xpath(xpath));
        return element;
    }
    protected String isTextDisplayed(String xpath) {
        String text =  findElementByXpath(xpath).getText();
        return text;
    }

    protected void clickElementByXpath(String xpath) {
        logger.info("Clicking element with xpath: " + xpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    protected boolean elementExists(String xpath) {
        try {
            logger.info("Check element with xpath exists: " + xpath);
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    protected String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public void takeScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}