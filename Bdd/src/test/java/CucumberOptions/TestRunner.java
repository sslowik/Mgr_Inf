package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",    // jeśli zawiera klasę z adnotacjami typu @Before, wykona je (tutaj klasa Hook)
        tags = {"@SmokeTest or @MobileTest"}
)
public class TestRunner {
}
