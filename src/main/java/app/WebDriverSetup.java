package app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSetup {
    private static WebDriver driver;
    public static void startWebDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void closeWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}