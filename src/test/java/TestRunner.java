import app.WebDriverSetup;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumberReports/report.html"}
)
@RunWith(Cucumber.class)
public class TestRunner {

    @BeforeClass
    public static void setup() {
        WebDriverSetup.startWebDriver();
    }

    @AfterClass
    public static void tearDown() {
        WebDriverSetup.closeWebDriver();
    }
}
