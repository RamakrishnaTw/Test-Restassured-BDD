package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"starter/stepDefinitions"},
        plugin = {"pretty", "json:target/jsonReports/report.json", "html:target/localHTMLReports/report.html"},
        tags = "@smoke"
)
public class TestRunner {


}
